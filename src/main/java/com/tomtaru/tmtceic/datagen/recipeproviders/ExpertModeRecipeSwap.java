package com.tomtaru.tmtceic.datagen.recipeproviders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public final class ExpertModeRecipeSwap {

    private ExpertModeRecipeSwap() {}

    public static CompletableFuture<?> apply(CachedOutput cache, PackOutput packOutput, Class<?> jarAnchor, ResourceLocation id) {
        try {
            JsonObject original = readOriginalRecipe(jarAnchor, id);

            if (original == null) {
                System.out.println("[tmtceic] No original recipe found for " + id + " — skipping entirely.");
                return CompletableFuture.completedFuture(null);
            }

            // Attach a "only load when expert mode is OFF" condition directly onto the original recipe.
            JsonObject notCondition = new JsonObject();
            notCondition.addProperty("type", "neoforge:not");
            JsonObject inner = new JsonObject();
            inner.addProperty("type", "tmtceic:expert_mode");
            notCondition.add("value", inner);

            JsonArray conditions = new JsonArray();
            conditions.add(notCondition);

            original.add("neoforge:conditions", conditions);

            Path outPath = packOutput.getOutputFolder(PackOutput.Target.DATA_PACK)
                    .resolve(id.getNamespace())
                    .resolve("recipe")
                    .resolve(id.getPath() + ".json");

            return DataProvider.saveStable(cache, original, outPath);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static JsonObject readOriginalRecipe(Class<?> jarAnchor, ResourceLocation id) throws IOException {
        String entryPath = "data/" + id.getNamespace() + "/recipe/" + id.getPath() + ".json";
        URL jarUrl = jarAnchor.getProtectionDomain().getCodeSource().getLocation();

        try {
            URI uri = jarUrl.toURI();

            if ("file".equals(uri.getScheme())) {
                File f = new File(uri);
                if (f.isFile()) {
                    try (JarFile jar = new JarFile(f)) {
                        ZipEntry entry = jar.getEntry(entryPath);
                        if (entry == null) return null;
                        try (InputStream in = jar.getInputStream(entry)) {
                            return GsonHelper.parse(new InputStreamReader(in));
                        }
                    }
                } else {
                    File target = new File(f, entryPath);
                    if (!target.exists()) return null;
                    try (InputStream in = new FileInputStream(target)) {
                        return GsonHelper.parse(new InputStreamReader(in));
                    }
                }
            } else {
                Path root = Path.of(uri);
                Path entry = root.resolve(entryPath);
                if (!Files.exists(entry)) return null;
                try (InputStream in = Files.newInputStream(entry)) {
                    return GsonHelper.parse(new InputStreamReader(in));
                }
            }
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
    }
}