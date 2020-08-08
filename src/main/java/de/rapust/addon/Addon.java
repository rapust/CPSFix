package de.rapust.addon;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

import java.util.List;

public class Addon extends LabyModAddon {
    private boolean enabled;



    @Override
    public void onEnable() {
        System.out.println("CPS Fix Addon is enabled!");
        this.getApi().registerForgeListener(new TrueClicks());
        this.getApi().registerModule(new TrueClicks());
    }

    @Override
    public void loadConfig() {

    }


    @Override
    protected void fillSettings(List<SettingsElement> list) {
    }

}