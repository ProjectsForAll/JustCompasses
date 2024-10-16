package host.plas.justcompasses.events;

import host.plas.justcompasses.JustCompasses;
import tv.quaint.events.BaseEventHandler;
import tv.quaint.events.BaseEventListener;

public class BouListener implements BaseEventListener {
    public BouListener() {
        BaseEventHandler.bake(this, JustCompasses.getInstance());
        JustCompasses.getInstance().logInfo("Registered BouListener!");
    }
}
