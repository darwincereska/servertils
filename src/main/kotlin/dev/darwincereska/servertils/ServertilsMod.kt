package dev.darwincereska.servertils

import dev.darwincereska.servertils.command.SpawnCommand
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback

class ServertilsMod : ModInitializer {
    override fun onInitialize() {
        println("Servertils Initializing...")

        CommandRegistrationCallback.EVENT.register { dispatcher, _, _ ->
            SpawnCommand.register(dispatcher)
        }
    }
}
