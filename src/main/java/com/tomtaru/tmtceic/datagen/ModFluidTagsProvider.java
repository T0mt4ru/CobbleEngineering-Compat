package com.tomtaru.tmtceic.datagen;

import com.tomtaru.tmtceic.Tmtceic;
import com.tomtaru.tmtceic.registry.ModAprigels;
import com.tomtaru.tmtceic.registry.ModMedicinals;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Tmtceic.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        // CREATE TAG KEYS
        // --- UMBRELLA TAGS ---
        TagKey<Fluid> allRestoratives = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "restoratives"));
        TagKey<Fluid> allPotions = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/all_potions"));
        TagKey<Fluid> allStatusCures = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "status_cures/all_cures"));
        TagKey<Fluid> allPpRestores = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "pp_restores/all_pp_restores"));
        TagKey<Fluid> allAprigels = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/all_aprigels"));
        TagKey<Fluid> fullHealIngredients = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "full_heal_ingredients"));

        // --- HP POTIONS ---
        TagKey<Fluid> potion = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/potion"));
        TagKey<Fluid> superPotion = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/super_potion"));
        TagKey<Fluid> hyperPotion = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/hyper_potion"));
        TagKey<Fluid> maxPotion = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "potions/max_potion"));

        // --- STATUS CURES ---
        TagKey<Fluid> antidote = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "status_cures/antidote"));
        TagKey<Fluid> burnHeal = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "status_cures/burn_heal"));
        TagKey<Fluid> iceHeal = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "status_cures/ice_heal"));
        TagKey<Fluid> paralyzeHeal = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "status_cures/paralyze_heal"));
        TagKey<Fluid> awakening = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "status_cures/awakening"));
        TagKey<Fluid> fullHeal = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "status_cures/full_heal"));

        // --- PP RESTORES ---
        TagKey<Fluid> ether = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "pp_restores/ether"));
        TagKey<Fluid> maxEther = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "pp_restores/max_ether"));
        TagKey<Fluid> elixir = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "pp_restores/elixir"));
        TagKey<Fluid> maxElixir = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "pp_restores/max_elixir"));

        // --- BASES & HYBRIDS ---
        TagKey<Fluid> medicinalBrew = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "bases/medicinal_brew"));
        TagKey<Fluid> fullRestore = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "restoratives/full_restore"));
        TagKey<Fluid> throatSpray = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "throat_spray"));

        // --- APRIGELS ---
        TagKey<Fluid> redAprigel = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/red_aprigel"));
        TagKey<Fluid> yellowAprigel = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/yellow_aprigel"));
        TagKey<Fluid> blueAprigel = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/blue_aprigel"));
        TagKey<Fluid> greenAprigel = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/green_aprigel"));
        TagKey<Fluid> pinkAprigel = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/pink_aprigel"));
        TagKey<Fluid> blackAprigel = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/black_aprigel"));
        TagKey<Fluid> whiteAprigel = TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(Tmtceic.MODID, "aprigels/white_aprigel"));

        // ASSIGN FLUIDS TO LEAF TAGS
        // --- HP POTIONS ---
        tag(potion).add(ModMedicinals.POTION.source().get());
        tag(superPotion).add(ModMedicinals.SUPER_POTION.source().get());
        tag(hyperPotion).add(ModMedicinals.HYPER_POTION.source().get());
        tag(maxPotion).add(ModMedicinals.MAX_POTION.source().get());

        // --- STATUS CURES ---
        tag(antidote).add(ModMedicinals.ANTIDOTE.source().get());
        tag(burnHeal).add(ModMedicinals.BURN_HEAL.source().get());
        tag(iceHeal).add(ModMedicinals.ICE_HEAL.source().get());
        tag(paralyzeHeal).add(ModMedicinals.PARALYZE_HEAL.source().get());
        tag(awakening).add(ModMedicinals.AWAKENING.source().get());
        tag(fullHeal).add(ModMedicinals.FULL_HEAL.source().get());

        // --- PP RESTORES ---
        tag(ether).add(ModMedicinals.ETHER.source().get());
        tag(maxEther).add(ModMedicinals.MAX_ETHER.source().get());
        tag(elixir).add(ModMedicinals.ELIXIR.source().get());
        tag(maxElixir).add(ModMedicinals.MAX_ELIXIR.source().get());

        // --- BASES & HYBRIDS ---
        tag(medicinalBrew).add(ModMedicinals.MEDICINAL_BREW.source().get());
        tag(fullRestore).add(ModMedicinals.FULL_RESTORE.source().get());
        tag(throatSpray).add(ModMedicinals.THROAT_SPRAY.source().get());

        // --- APRIGELS ---
        tag(redAprigel).add(ModAprigels.RED_APRIGEL.source().get());
        tag(yellowAprigel).add(ModAprigels.YELLOW_APRIGEL.source().get());
        tag(blueAprigel).add(ModAprigels.BLUE_APRIGEL.source().get());
        tag(greenAprigel).add(ModAprigels.GREEN_APRIGEL.source().get());
        tag(pinkAprigel).add(ModAprigels.PINK_APRIGEL.source().get());
        tag(blackAprigel).add(ModAprigels.BLACK_APRIGEL.source().get());
        tag(whiteAprigel).add(ModAprigels.WHITE_APRIGEL.source().get());



        // 3. GROUP TAGS INTO UMBRELLAS
        // Group individual HP potions into the category tag
        tag(allPotions)
                .addTag(potion)
                .addTag(superPotion)
                .addTag(hyperPotion)
                .addTag(maxPotion);

        // Group status cures into the category tag
        tag(allStatusCures)
                .addTag(antidote)
                .addTag(burnHeal)
                .addTag(iceHeal)
                .addTag(paralyzeHeal)
                .addTag(awakening)
                .addTag(fullHeal);

        // Group PP restores into the category tag
        tag(allPpRestores)
                .addTag(ether)
                .addTag(maxEther)
                .addTag(elixir)
                .addTag(maxElixir);

        // Group aprigels into the category tag
        tag(allAprigels)
                .addTag(redAprigel)
                .addTag(yellowAprigel)
                .addTag(blueAprigel)
                .addTag(greenAprigel)
                .addTag(pinkAprigel)
                .addTag(blackAprigel)
                .addTag(whiteAprigel);

        // Full Restore restores both HP and Status, so it belongs in both sub-groups!
        tag(allPotions).addTag(fullRestore);
        tag(allStatusCures).addTag(fullRestore);

        // Top-level umbrella tag that groups ALL restorative medicines together
        tag(allRestoratives)
                .addTag(allPotions)
                .addTag(allStatusCures)
                .addTag(allPpRestores)
                .addTag(medicinalBrew);

        // Extra umbrella tag used for crafting full heals

        tag(fullHealIngredients)
                .addTag(antidote)
                .addTag(burnHeal)
                .addTag(iceHeal)
                .addTag(paralyzeHeal)
                .addTag(awakening);

    }
}