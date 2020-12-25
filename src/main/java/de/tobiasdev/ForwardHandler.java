package de.tobiasdev;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class ForwardHandler implements Listener {

    private final WDForward plugin;

    public ForwardHandler(WDForward plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPluginMessageRcv(PluginMessageEvent event) {
        if (event.getTag().equals("legacy:forward")) {
            ByteArrayDataInput input = ByteStreams.newDataInput(event.getData());
            String targetServer = input.readUTF();
            final byte[] payload = new byte[input.readInt()];
            input.readFully(payload);
            ServerInfo i = this.plugin.getProxy().getServerInfo(targetServer);
            if (i != null) {
                i.sendData("forward", payload);
            } else {
                this.plugin.getLogger().warning("Forward Message targets invalid server: " + targetServer);
            }
        }
    }
}
