package com.tomtaru.tmtceic.datagen.recipeproviders;

import com.cobblemon.mod.common.CobblemonBlocks;
import com.cobblemon.mod.common.CobblemonItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Dexes {

    private Dexes() {
    }

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

    public static final String[] ADVANCEDBALLDEX = {
            "dive", "dream", "dusk", "fast", "friend", "great", "heal", "heavy", "level", "love", "lure",
            "luxury", "moon", "nest", "net", "park", "quick", "repeat", "safari", "sport", "ultra", "timer"
    };

    public static final String[] FRAMEDEX = {
            "azure", "love", "slate", "citrine", "nest", "azure", "premier", "slate", "ultra", "roseate",
            "park", "ultra", "heavy", "citrine", "azure", "verdant", "azure", "sport", "verdant", "poke", "slate", "premier"
    };

    public static final String[] SPRAYDEX = {
            "white", "blue", "green", "red", "red", "red", "pink", "blue", "pink", "white", "blue",
            "red", "yellow", "green", "black", "white", "yellow", "black", "yellow", "white", "yellow", "black"
    };

    public static final Map<String, String> APRICORN_TO_BALL = new HashMap<>();
    public static final Map<String, String> APRICORN_TO_ANCIENTBALL = new HashMap<>();
    public static final Map<String, String> ADVANCEDBALL_TO_FRAME = new HashMap<>();
    public static final Map<String, String> ADVANCEDBALL_TO_SPRAY = new HashMap<>();

    static {
        for (int index = 0; index < APRIDEX.length; index++) {
            APRICORN_TO_BALL.put(APRIDEX[index], BASICBALLDEX[index]);
        }

        for (int index = 0; index < APRIDEX.length; index++) {
            APRICORN_TO_ANCIENTBALL.put(APRIDEX[index], ANCIENTBALLDEX[index]);
        }

        for (int index = 0; index < ADVANCEDBALLDEX.length; index++) {
            ADVANCEDBALL_TO_FRAME.put(ADVANCEDBALLDEX[index], FRAMEDEX[index]);
        }

        for (int index = 0; index < ADVANCEDBALLDEX.length; index++) {
            ADVANCEDBALL_TO_SPRAY.put(ADVANCEDBALLDEX[index], SPRAYDEX[index]);
        }
    }

    public static final String[] POTIONDEX = {
            "potion", "super_potion", "hyper_potion", "max_potion", "ether", "max_ether", "elixir", "max_elixir",
            "antidote", "awakening", "paralyze_heal", "burn_heal", "ice_heal", "full_heal", "full_restore",
            "throat_spray"
    };

    public static final String[] EVOLUTIONSTONEDEX = {
            "dawn", "dusk", "fire", "ice", "leaf", "moon", "shiny", "sun", "thunder", "water"
    };

    public record AncientSkyDex(Item ball, String ingot) {}

    public static final List<AncientSkyDex> ANCIENTSKYDEX = List.of(
            new AncientSkyDex(CobblemonItems.ANCIENT_FEATHER_BALL,    "copper"),
            new AncientSkyDex(CobblemonItems.ANCIENT_WING_BALL,       "iron"),
            new AncientSkyDex(CobblemonItems.ANCIENT_JET_BALL,        "gold")
    );

    public record AncientBlackDex(String name, String ingot) {}

    public static final List<AncientBlackDex> ANCIENTBLACKDEX = List.of(
            new AncientBlackDex("heavy",    "copper"),
            new AncientBlackDex("leaden",   "iron"),
            new AncientBlackDex("gigaton",   "gold")
    );

    public record TumbleCrystalDex(Item crystal, int yield, Item result) {}

    public static final List<TumbleCrystalDex> TUMBLECRYSTALDEX = List.of(

            new TumbleCrystalDex(CobblemonItems.SMALL_BUDDING_TUMBLESTONE,        1, CobblemonItems.TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.MEDIUM_BUDDING_TUMBLESTONE,       1, CobblemonItems.TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.LARGE_BUDDING_TUMBLESTONE,        1, CobblemonItems.TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.TUMBLESTONE_CLUSTER,              4, CobblemonItems.TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.SMALL_BUDDING_SKY_TUMBLESTONE,    1, CobblemonItems.SKY_TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.MEDIUM_BUDDING_SKY_TUMBLESTONE,   1, CobblemonItems.SKY_TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.LARGE_BUDDING_SKY_TUMBLESTONE,    1, CobblemonItems.SKY_TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.SKY_TUMBLESTONE_CLUSTER,          4, CobblemonItems.SKY_TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.SMALL_BUDDING_BLACK_TUMBLESTONE,  1, CobblemonItems.BLACK_TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.MEDIUM_BUDDING_BLACK_TUMBLESTONE, 1, CobblemonItems.BLACK_TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.LARGE_BUDDING_BLACK_TUMBLESTONE,  1, CobblemonItems.BLACK_TUMBLESTONE),
            new TumbleCrystalDex(CobblemonItems.BLACK_TUMBLESTONE_CLUSTER,        4, CobblemonItems.BLACK_TUMBLESTONE)
    );

    public record BerryDex(Item berryItem, Block berryBlock) {}
    public static final List<BerryDex> BERRYDEX = List.of(
            new BerryDex(CobblemonItems.CHERI_BERRY,    CobblemonBlocks.CHERI_BERRY),
            new BerryDex(CobblemonItems.CHESTO_BERRY,   CobblemonBlocks.CHESTO_BERRY),
            new BerryDex(CobblemonItems.PECHA_BERRY,    CobblemonBlocks.PECHA_BERRY),
            new BerryDex(CobblemonItems.RAWST_BERRY,    CobblemonBlocks.RAWST_BERRY),
            new BerryDex(CobblemonItems.ASPEAR_BERRY,   CobblemonBlocks.ASPEAR_BERRY),
            new BerryDex(CobblemonItems.LEPPA_BERRY,    CobblemonBlocks.LEPPA_BERRY),
            new BerryDex(CobblemonItems.ORAN_BERRY,     CobblemonBlocks.ORAN_BERRY),
            new BerryDex(CobblemonItems.PERSIM_BERRY,   CobblemonBlocks.PERSIM_BERRY),
            new BerryDex(CobblemonItems.LUM_BERRY,      CobblemonBlocks.LUM_BERRY),
            new BerryDex(CobblemonItems.SITRUS_BERRY,   CobblemonBlocks.SITRUS_BERRY),
            new BerryDex(CobblemonItems.FIGY_BERRY,     CobblemonBlocks.FIGY_BERRY),
            new BerryDex(CobblemonItems.WIKI_BERRY,     CobblemonBlocks.WIKI_BERRY),
            new BerryDex(CobblemonItems.MAGO_BERRY,     CobblemonBlocks.MAGO_BERRY),
            new BerryDex(CobblemonItems.AGUAV_BERRY,    CobblemonBlocks.AGUAV_BERRY),
            new BerryDex(CobblemonItems.IAPAPA_BERRY,   CobblemonBlocks.IAPAPA_BERRY),
            new BerryDex(CobblemonItems.RAZZ_BERRY,     CobblemonBlocks.RAZZ_BERRY),
            new BerryDex(CobblemonItems.BLUK_BERRY,     CobblemonBlocks.BLUK_BERRY),
            new BerryDex(CobblemonItems.NANAB_BERRY,    CobblemonBlocks.NANAB_BERRY),
            new BerryDex(CobblemonItems.WEPEAR_BERRY,   CobblemonBlocks.WEPEAR_BERRY),
            new BerryDex(CobblemonItems.PINAP_BERRY,    CobblemonBlocks.PINAP_BERRY),
            new BerryDex(CobblemonItems.POMEG_BERRY,    CobblemonBlocks.POMEG_BERRY),
            new BerryDex(CobblemonItems.KELPSY_BERRY,   CobblemonBlocks.KELPSY_BERRY),
            new BerryDex(CobblemonItems.QUALOT_BERRY,   CobblemonBlocks.QUALOT_BERRY),
            new BerryDex(CobblemonItems.HONDEW_BERRY,   CobblemonBlocks.HONDEW_BERRY),
            new BerryDex(CobblemonItems.GREPA_BERRY,    CobblemonBlocks.GREPA_BERRY),
            new BerryDex(CobblemonItems.TAMATO_BERRY,   CobblemonBlocks.TAMATO_BERRY),
            new BerryDex(CobblemonItems.CORNN_BERRY,    CobblemonBlocks.CORNN_BERRY),
            new BerryDex(CobblemonItems.MAGOST_BERRY,   CobblemonBlocks.MAGOST_BERRY),
            new BerryDex(CobblemonItems.RABUTA_BERRY,   CobblemonBlocks.RABUTA_BERRY),
            new BerryDex(CobblemonItems.NOMEL_BERRY,    CobblemonBlocks.NOMEL_BERRY),
            new BerryDex(CobblemonItems.SPELON_BERRY,   CobblemonBlocks.SPELON_BERRY),
            new BerryDex(CobblemonItems.PAMTRE_BERRY,   CobblemonBlocks.PAMTRE_BERRY),
            new BerryDex(CobblemonItems.WATMEL_BERRY,   CobblemonBlocks.WATMEL_BERRY),
            new BerryDex(CobblemonItems.DURIN_BERRY,    CobblemonBlocks.DURIN_BERRY),
            new BerryDex(CobblemonItems.BELUE_BERRY,    CobblemonBlocks.BELUE_BERRY),
            new BerryDex(CobblemonItems.OCCA_BERRY,     CobblemonBlocks.OCCA_BERRY),
            new BerryDex(CobblemonItems.PASSHO_BERRY,   CobblemonBlocks.PASSHO_BERRY),
            new BerryDex(CobblemonItems.WACAN_BERRY,    CobblemonBlocks.WACAN_BERRY),
            new BerryDex(CobblemonItems.RINDO_BERRY,    CobblemonBlocks.RINDO_BERRY),
            new BerryDex(CobblemonItems.YACHE_BERRY,    CobblemonBlocks.YACHE_BERRY),
            new BerryDex(CobblemonItems.CHOPLE_BERRY,   CobblemonBlocks.CHOPLE_BERRY),
            new BerryDex(CobblemonItems.KEBIA_BERRY,    CobblemonBlocks.KEBIA_BERRY),
            new BerryDex(CobblemonItems.SHUCA_BERRY,    CobblemonBlocks.SHUCA_BERRY),
            new BerryDex(CobblemonItems.COBA_BERRY,     CobblemonBlocks.COBA_BERRY),
            new BerryDex(CobblemonItems.PAYAPA_BERRY,   CobblemonBlocks.PAYAPA_BERRY),
            new BerryDex(CobblemonItems.TANGA_BERRY,    CobblemonBlocks.TANGA_BERRY),
            new BerryDex(CobblemonItems.CHARTI_BERRY,   CobblemonBlocks.CHARTI_BERRY),
            new BerryDex(CobblemonItems.KASIB_BERRY,    CobblemonBlocks.KASIB_BERRY),
            new BerryDex(CobblemonItems.HABAN_BERRY,    CobblemonBlocks.HABAN_BERRY),
            new BerryDex(CobblemonItems.COLBUR_BERRY,   CobblemonBlocks.COLBUR_BERRY),
            new BerryDex(CobblemonItems.BABIRI_BERRY,   CobblemonBlocks.BABIRI_BERRY),
            new BerryDex(CobblemonItems.CHILAN_BERRY,   CobblemonBlocks.CHILAN_BERRY),
            new BerryDex(CobblemonItems.LIECHI_BERRY,   CobblemonBlocks.LIECHI_BERRY),
            new BerryDex(CobblemonItems.GANLON_BERRY,   CobblemonBlocks.GANLON_BERRY),
            new BerryDex(CobblemonItems.SALAC_BERRY,    CobblemonBlocks.SALAC_BERRY),
            new BerryDex(CobblemonItems.PETAYA_BERRY,   CobblemonBlocks.PETAYA_BERRY),
            new BerryDex(CobblemonItems.APICOT_BERRY,   CobblemonBlocks.APICOT_BERRY),
            new BerryDex(CobblemonItems.LANSAT_BERRY,   CobblemonBlocks.LANSAT_BERRY),
            new BerryDex(CobblemonItems.STARF_BERRY,    CobblemonBlocks.STARF_BERRY),
            new BerryDex(CobblemonItems.ENIGMA_BERRY,   CobblemonBlocks.ENIGMA_BERRY),
            new BerryDex(CobblemonItems.MICLE_BERRY,    CobblemonBlocks.MICLE_BERRY),
            new BerryDex(CobblemonItems.CUSTAP_BERRY,   CobblemonBlocks.CUSTAP_BERRY),
            new BerryDex(CobblemonItems.JABOCA_BERRY,   CobblemonBlocks.JABOCA_BERRY),
            new BerryDex(CobblemonItems.ROWAP_BERRY,    CobblemonBlocks.ROWAP_BERRY),
            new BerryDex(CobblemonItems.ROSELI_BERRY,   CobblemonBlocks.ROSELI_BERRY),
            new BerryDex(CobblemonItems.KEE_BERRY,      CobblemonBlocks.KEE_BERRY),
            new BerryDex(CobblemonItems.MARANGA_BERRY,  CobblemonBlocks.MARANGA_BERRY),
            new BerryDex(CobblemonItems.HOPO_BERRY,     CobblemonBlocks.HOPO_BERRY),
            new BerryDex(CobblemonItems.TOUGA_BERRY,    CobblemonBlocks.TOUGA_BERRY),
            new BerryDex(CobblemonItems.EGGANT_BERRY,   CobblemonBlocks.EGGANT_BERRY)
    );

    public record AllPokeBalls(Item pokeballs) {}

    public static List<AllPokeBalls> ALLPOKEBALLDEX = List.of(

            // Basic Balls
            new AllPokeBalls(CobblemonItems.POKE_BALL),
            new AllPokeBalls(CobblemonItems.CITRINE_BALL),
            new AllPokeBalls(CobblemonItems.AZURE_BALL),
            new AllPokeBalls(CobblemonItems.SLATE_BALL),
            new AllPokeBalls(CobblemonItems.ROSEATE_BALL),
            new AllPokeBalls(CobblemonItems.VERDANT_BALL),
            new AllPokeBalls(CobblemonItems.PREMIER_BALL),
            // Ancient Balls
            new AllPokeBalls(CobblemonItems.ANCIENT_POKE_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_CITRINE_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_AZURE_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_SLATE_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_ROSEATE_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_VERDANT_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_IVORY_BALL),
            // Advanced Balls
            new AllPokeBalls(CobblemonItems.DIVE_BALL),
            new AllPokeBalls(CobblemonItems.DREAM_BALL),
            new AllPokeBalls(CobblemonItems.DUSK_BALL),
            new AllPokeBalls(CobblemonItems.FAST_BALL),
            new AllPokeBalls(CobblemonItems.FRIEND_BALL),
            new AllPokeBalls(CobblemonItems.GREAT_BALL),
            new AllPokeBalls(CobblemonItems.HEAL_BALL),
            new AllPokeBalls(CobblemonItems.HEAVY_BALL),
            new AllPokeBalls(CobblemonItems.LEVEL_BALL),
            new AllPokeBalls(CobblemonItems.LOVE_BALL),
            new AllPokeBalls(CobblemonItems.LURE_BALL),
            new AllPokeBalls(CobblemonItems.LUXURY_BALL),
            new AllPokeBalls(CobblemonItems.MOON_BALL),
            new AllPokeBalls(CobblemonItems.NEST_BALL),
            new AllPokeBalls(CobblemonItems.NET_BALL),
            new AllPokeBalls(CobblemonItems.PARK_BALL),
            new AllPokeBalls(CobblemonItems.QUICK_BALL),
            new AllPokeBalls(CobblemonItems.REPEAT_BALL),
            new AllPokeBalls(CobblemonItems.SAFARI_BALL),
            new AllPokeBalls(CobblemonItems.SPORT_BALL),
            new AllPokeBalls(CobblemonItems.ULTRA_BALL),
            new AllPokeBalls(CobblemonItems.TIMER_BALL),
            new AllPokeBalls(CobblemonItems.MASTER_BALL),
            // Advanced Ancient Balls
            new AllPokeBalls(CobblemonItems.ANCIENT_FEATHER_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_JET_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_WING_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_HEAVY_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_LEADEN_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_GIGATON_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_GREAT_BALL),
            new AllPokeBalls(CobblemonItems.ANCIENT_ULTRA_BALL)
    );
}
