/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2.api.event.player;

import cn.jsmod2.api.map.TeslaGate;
import cn.jsmod2.api.player.Player;
import cn.jsmod2.core.annotations.UseForServerInit;

/**
 * @author kevinj
 */

public class PlayerTriggerTeslaEvent extends PlayerEvent {
    private TeslaGate TeslaGate;
    private boolean Triggerable;

    public PlayerTriggerTeslaEvent(Player player, TeslaGate teslaGate, boolean triggerable) {
        super(player);
        TeslaGate = teslaGate;
        Triggerable = triggerable;
    }

    public PlayerTriggerTeslaEvent(){

    }

    public void setTriggerable(boolean triggerable) {
        Triggerable = triggerable;
    }

    public TeslaGate getTeslaGate() {
        return TeslaGate;
    }

    public boolean isTriggerable() {
        return Triggerable;
    }


}
