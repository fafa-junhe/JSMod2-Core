/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2.scpslserver.event.player;

import cn.jsmod2.scpslserver.utils.entity.Player;
/**
 * @author kevinj
 */
public class Scp096CooldownStartEvent extends PlayerEvent {
    private boolean allow;

    public Scp096CooldownStartEvent(Player player, boolean allow) {
        super(player);
        this.allow = allow;
    }

    public Scp096CooldownStartEvent(){

    }

    public boolean isAllow() {
        return allow;
    }

    public void setAllow(boolean allow) {
        this.allow = allow;
    }


}
