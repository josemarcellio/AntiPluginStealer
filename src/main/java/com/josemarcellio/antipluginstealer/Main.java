package com.josemarcellio.antipluginstealer;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.josemarcellio.antipluginstealer.listeners.Packet;
import com.josemarcellio.antipluginstealer.listeners.Syntax;
import com.josemarcellio.antipluginstealer.metrics.Metrics;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin {

    public void register(Listener... listeners) {
        Arrays.stream ( listeners ).forEach ( listener -> this.getServer ().getPluginManager ().registerEvents ( listener, this ) );
    }

    @Override
    public void onEnable() {
        new Metrics (this, 13539);
        getLogger ().info ( "AntiPluginStealer by JoseMarcellio" );
        if (this.getServer ().getPluginManager ().getPlugin ( "ProtocolLib" ) != null) {
            ProtocolLibrary.getProtocolManager ().addPacketListener ( new Packet ( this, PacketType.Play.Client.TAB_COMPLETE ) );
        }

        register ( new Syntax (this));

        saveDefaultConfig ();
    }

    @Override
    public void onDisable() {
        getLogger ().info ( "Disabling AntiPluginStealer" );
        ProtocolLibrary.getProtocolManager().removePacketListeners(this);
    }
}
