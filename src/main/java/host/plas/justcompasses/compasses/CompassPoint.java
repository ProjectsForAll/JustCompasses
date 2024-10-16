package host.plas.justcompasses.compasses;

import host.plas.bou.items.CraftingConfig;
import host.plas.bou.items.ItemUtils;
import host.plas.bou.utils.ColorUtils;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tv.quaint.objects.Identifiable;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Getter @Setter
public class CompassPoint implements Identifiable {
    public static final char[][] COMPASS_IDS = new char[][]{
        {'A', 'I', 'A'},
        {'I', 'R', 'I'},
        {'A', 'I', 'A'}
    };
    public static final ConcurrentSkipListMap<Character, Material> COMPASS_MATERIALS = new ConcurrentSkipListMap<>() {{
        put('A', Material.AIR);
        put('I', Material.IRON_INGOT);
        put('R', Material.REDSTONE);
    }};

    public static CraftingConfig getCraftingConfig(String identifier, ConcurrentSkipListSet<String> list, TrackType type) {
        StringBuilder l1 = new StringBuilder();
        StringBuilder l2 = new StringBuilder();
        StringBuilder l3 = new StringBuilder();

        int i = 1;
        for (char[] row : COMPASS_IDS) {
            for (char c : row) {
                switch (c) {
                    case 'A':
                        switch (i) {
                            case 1:
                                l1.append("AIR");
                                break;
                            case 2:
                                l2.append("AIR");
                                break;
                            case 3:
                                l3.append("AIR");
                                break;
                        }
                        break;
                    case 'I':
                        switch (i) {
                            case 1:
                                l1.append("IRON_INGOT");
                                break;
                            case 2:
                                l2.append("IRON_INGOT");
                                break;
                            case 3:
                                l3.append("IRON_INGOT");
                                break;
                        }
                        break;
                    case 'R':
                        switch (i) {
                            case 1:
                                l1.append("REDSTONE");
                                break;
                            case 2:
                                l2.append("REDSTONE");
                                break;
                            case 3:
                                l3.append("REDSTONE");
                                break;
                        }
                        break;
                }
            }

            i++;
        }

        ConcurrentSkipListMap<String, String> ingredients = new ConcurrentSkipListMap<>();
        COMPASS_MATERIALS.forEach((c, m) -> ingredients.put(c.toString(), ItemUtils.getItemNBT(new ItemStack(m))));

        return new CraftingConfig(identifier, l1.toString(), l2.toString(), l3.toString(), ingredients, ItemUtils.getItemNBT(getCompass(identifier, list, type)));
    }

    public static ItemStack getCompass(String identifier, ConcurrentSkipListSet<String> list, TrackType type) {
        ItemStack compass = new ItemStack(Material.COMPASS);

        ItemMeta meta = compass.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ColorUtils.colorizeHard("&f"));
            compass.setItemMeta(meta);
        }
    }

    private String identifier;
    private CraftingConfig craftingConfig;
    private ConcurrentSkipListSet<String> list;
    private TrackType type;

    public CompassPoint(String identifier, CraftingConfig craftingConfig, ConcurrentSkipListSet<String> list, TrackType type) {
        this.identifier = identifier;
        this.craftingConfig = craftingConfig;
        this.list = list;
        this.type = type;
    }

    public CompassPoint(String identifier, ConcurrentSkipListSet<String> list, TrackType type) {
        this(identifier, getCraftingConfig(identifier, list, type), list, type);
    }
}
