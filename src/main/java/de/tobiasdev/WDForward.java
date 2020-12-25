package de.tobiasdev;

import net.md_5.bungee.api.plugin.Plugin;

public class WDForward extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().registerChannel("forward");
        this.getProxy().getPluginManager().registerListener(this, new ForwardHandler(this));
    }
}
