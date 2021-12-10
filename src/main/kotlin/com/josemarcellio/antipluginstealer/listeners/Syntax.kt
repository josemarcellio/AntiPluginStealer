package com.josemarcellio.antipluginstealer.listeners

import com.josemarcellio.antipluginstealer.Main
import com.josemarcellio.antipluginstealer.utils.Utils
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class Syntax(private val main: Main) : Listener {

    @EventHandler
    fun onCommandPreprocess(e: PlayerCommandPreprocessEvent) {
        if (e.message.split(" ").toTypedArray()[0].contains(":") && !e.player.hasPermission("antipluginstealer.syntax")) {
            e.isCancelled = true
            e.player.sendMessage(Utils.getColor(main.config.getString("syntax")))
        }
    }
}