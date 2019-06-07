/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2.scpslserver.event.environment;

import cn.jsmod2.scpslserver.annotations.UseForServerInit;
import cn.jsmod2.scpslserver.utils.api.Role;
import cn.jsmod2.scpslserver.utils.entity.Player;
import cn.jsmod2.scpslserver.event.Event;

/**
 * @author Kevinj
 * @author magiclu550
 */

public class ScpDeathAnnouncementEvent extends Event {
    private boolean shouldPlay;
    private Player deadPlayer;
    private Role playerRole;

    public boolean isShouldPlay() {
        return shouldPlay;
    }

    public void setShouldPlay(boolean shouldPlay) {
        this.shouldPlay = shouldPlay;
    }

    public Player getDeadPlayer() {
        return deadPlayer;
    }

    public Role getPlayerRole() {
        return playerRole;
    }

    public ScpDeathAnnouncementEvent(boolean shouldPlay, Player deadPlayer, Role playerRole) {
        this.shouldPlay = shouldPlay;
        this.deadPlayer = deadPlayer;
        this.playerRole = playerRole;
    }

    public ScpDeathAnnouncementEvent(){

    }

    /** java-bean */
    @UseForServerInit
    public void setDeadPlayer(Player deadPlayer) {
        this.deadPlayer = deadPlayer;
    }

    /** java-bean */
    @UseForServerInit
    public void setPlayerRole(Role playerRole) {
        this.playerRole = playerRole;
    }
}
