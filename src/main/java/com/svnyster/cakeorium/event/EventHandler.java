package com.svnyster.cakeorium.event;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void cabitaLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player.getName().equals("Cabita")) {
            FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().sendChatMsg(new TextComponentString("The mother of cakes has arrived!"));
        } else {
            System.out.println(event.player.getName());
            System.out.println(event.player.getDisplayNameString());
        }
    }
}
