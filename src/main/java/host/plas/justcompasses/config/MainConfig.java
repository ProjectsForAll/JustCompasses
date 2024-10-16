package host.plas.justcompasses.config;

import host.plas.justcompasses.JustCompasses;
import tv.quaint.storage.resources.flat.simple.SimpleConfiguration;

public class MainConfig extends SimpleConfiguration {
    public MainConfig() {
        super("config.yml", JustCompasses.getInstance(), false);
    }

    @Override
    public void init() {

    }
}
