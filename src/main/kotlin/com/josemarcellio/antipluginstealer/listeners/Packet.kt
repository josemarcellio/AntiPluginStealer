package com.josemarcellio.antipluginstealer.listeners

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.plugin.Plugin

class Packet(plugin: Plugin?, vararg types: PacketType?) : PacketAdapter(plugin, *types) {

    override fun onPacketReceiving(e: PacketEvent) {
        val packetType = e.packetType
        if (packetType == PacketType.Play.Client.TAB_COMPLETE) {
            e.isCancelled = true
        }
    }
}