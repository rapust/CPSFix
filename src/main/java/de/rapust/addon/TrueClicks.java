package de.rapust.addon;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Mouse;
import java.util.LinkedList;
import java.util.Queue;

public class TrueClicks extends SimpleModule {

    private final Queue<Long> clicksleft = new LinkedList<>();
    private final Queue<Long> clicksright = new LinkedList<>();



    public int cpsleft() {
        long time = System.currentTimeMillis();

        while (!clicksleft.isEmpty() && clicksleft.peek() < time) {
            clicksleft.remove();
        }

        return clicksleft.size();
    }
    public int cpsright() {
        long time = System.currentTimeMillis();

        while (!clicksright.isEmpty() && clicksright.peek() < time) {
            clicksright.remove();
        }

        return clicksright.size();
    }



    @SubscribeEvent
    public void onMouseInput(InputEvent.MouseInputEvent event) {
        if (!Mouse.getEventButtonState()) {
            return;
        }

        switch (Mouse.getEventButton()) {
            case 0:
                clicksleft.add(System.currentTimeMillis() + 1000L);
                return;
            case 1:
                clicksright.add(System.currentTimeMillis() + 1000L);
                return;
            default:
        }
    }


    @Override
    public String getDisplayName() { return "CPS"; }
    @Override
    public String getControlName() {
        return "CPS";
    }
    @Override
    public String getDisplayValue() {
        return String.valueOf(cpsleft()) + " : " + String.valueOf(cpsright());

    }


    @Override
    public String getDefaultValue() { return String.valueOf(0) + " : " + String.valueOf(0); }
    @Override
    public ControlElement.IconData getIconData() { return new ControlElement.IconData(Material.STONE_BUTTON); }
    @Override
    public void loadSettings() {


    }
    @Override
    public String getSettingName() {
        return "CPS";
    }
    @Override
    public String getDescription() {
        return "CPS";
    }
    @Override
    public int getSortingId() {
        return 1;
    }
    @Override
    public ModuleCategory getCategory() {
        return ModuleCategoryRegistry.CATEGORY_OTHER;
    }
}

