package com.tomtaru.tmtceic.datagen.recipeproviders;

import java.util.HashMap;
import java.util.Map;

public final class Dexes {

    private Dexes() {
    }

    // The "Berrydex", list of all berries in cobblemon by name only, the rest is standard.
    public static final String[] BERRYDEX = {
            "cheri", "chesto", "pecha", "rawst", "aspear", "leppa", "oran", "persim",
            "lum", "sitrus", "figy", "wiki", "mago", "aguav", "iapapa",
            "razz", "bluk", "nanab", "wepear", "pinap", "pomeg", "kelpsy", "qualot",
            "hondew", "grepa", "tamato", "cornn", "magost", "rabuta", "nomel",
            "spelon", "pamtre", "watmel", "durin", "belue",
            "occa", "passho", "wacan", "rindo", "yache", "chople", "kebia", "shuca",
            "coba", "payapa", "tanga", "charti", "kasib", "haban", "colbur", "babiri",
            "chilan", "liechi", "ganlon", "salac", "petaya", "apicot", "lansat",
            "starf", "enigma", "micle", "custap", "jaboca", "rowap", "roseli",
            "kee", "maranga", "hopo", "touga", "eggant"
    };

    // The "Mintdex", list of all coloured mints in cobblemon by colour only, the rest is standard.
    public static final String[] MINTDEX = {
            "red", "blue", "cyan", "pink", "green", "white"
    };

    // The "Tumbledex", list of all tumblestones in cobblemon by type and _, the rest is standard.
    public static final String[] TUMBLEDEX = {
            "", "black_", "sky_"
    };

    // The "Apridex", lists all coloured apricorn sprouts in cobblemon by colour only, the rest is standard.
    public static final String[] APRIDEX = {
            "red", "yellow", "blue", "black", "pink", "green", "white"
    };

    public static final String[] BASICBALLDEX = {
            "poke", "citrine", "azure", "slate", "roseate", "verdant", "premier"
    };

    public static final String[] ANCIENTBALLDEX = {
            "ancient_poke", "ancient_citrine", "ancient_azure", "ancient_slate", "ancient_roseate",
            "ancient_verdant", "ancient_ivory"
    };

    public static final Map<String, String> APRICORN_TO_BALL = new HashMap<>();
    public static final Map<String, String> APRICORN_TO_ANCIENTBALL = new HashMap<>();

    static {
        for (int index = 0; index < APRIDEX.length; index++) {
            APRICORN_TO_BALL.put(APRIDEX[index], BASICBALLDEX[index]);
        }
    }
    static {
        for (int index = 0; index < BASICBALLDEX.length; index++) {
            APRICORN_TO_ANCIENTBALL.put(APRIDEX[index], ANCIENTBALLDEX[index]);
        }
    }

    public static final String[] POTIONDEX = {
            "potion", "super_potion", "hyper_potion", "max_potion", "ether", "max_ether", "elixir", "max_elixir",
            "antidote", "awakening", "paralyze_heal", "burn_heal", "ice_heal", "full_heal", "full_restore",
            "throat_spray"
    };
}
