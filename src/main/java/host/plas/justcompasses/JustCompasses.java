package host.plas.justcompasses;

import host.plas.bou.BetterPlugin;
import host.plas.justcompasses.config.MainConfig;
import host.plas.justcompasses.events.BouListener;
import host.plas.justcompasses.events.BukkitListener;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class JustCompasses extends BetterPlugin {
    @Getter @Setter
    private static JustCompasses instance;
    @Getter @Setter
    private static MainConfig mainConfig;

    @Getter @Setter
    private static BukkitListener bukkitListener;
    @Getter @Setter
    private static BouListener bouListener;

    public JustCompasses() {
        super();
    }

    @Override
    public void onBaseEnabled() {
        // Plugin startup logic
        setInstance(this);

        setMainConfig(new MainConfig());

        setBukkitListener(new BukkitListener());
        setBouListener(new BouListener());
    }

    @Override
    public void onBaseDisable() {
        // Plugin shutdown logic
    }
}
