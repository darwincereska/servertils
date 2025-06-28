package dev.darwincereska.servertils.command

import com.mojang.brigadier.CommandDispatcher
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

object SpawnCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {
        dispatcher.register(
            literal("spawn").executes { context ->
                val player = context.source.playerOrThrow
                val world = player.serverWorld
                val spawn = world.spawnPos
                player.teleport(
                    world,
                    spawn.x.toDouble() + 0.5, 
                    spawn.y.toDouble(), 
                    spawn.z.toDouble() + 0.5,
                    null,
                    player.yaw, 
                    player.pitch,
                    false
                )
                player.sendMessage(Text.literal("Teleported to spawn."), false)
                1
            }
        )
    }
}
