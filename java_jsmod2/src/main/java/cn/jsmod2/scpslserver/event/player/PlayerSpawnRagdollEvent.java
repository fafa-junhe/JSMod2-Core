/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2.scpslserver.event.player;

import cn.jsmod2.scpslserver.annotations.UseForServerInit;
import cn.jsmod2.scpslserver.utils.api.Role;
import cn.jsmod2.scpslserver.utils.player.DamageType;
import cn.jsmod2.scpslserver.utils.entity.Player;
import cn.jsmod2.scpslserver.event.Event;
import cn.jsmod2.scpslserver.math.Vector;

/**
 * @author kevinj
 */
public class PlayerSpawnRagdollEvent extends Event {
    private Role role;
    private Vector position;
    private Vector Rotation;
    private Player attacker;
    private DamageType damageType;
    private boolean allowRecall;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getRotation() {
        return Rotation;
    }

    public void setRotation(Vector rotation) {
        Rotation = rotation;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public boolean isAllowRecall() {
        return allowRecall;
    }

    public void setAllowRecall(boolean allowRecall) {
        this.allowRecall = allowRecall;
    }

    public Player getAttacker() {
        return attacker;
    }
    /** java-bean */
    @UseForServerInit
    public void setAttacker(Player attacker) {
        this.attacker = attacker;
    }

    public PlayerSpawnRagdollEvent(Role role, Vector position, Vector rotation, Player attacker, DamageType damageType, boolean allowRecall) {
        this.role = role;
        this.position = position;
        Rotation = rotation;
        this.attacker = attacker;
        this.damageType = damageType;
        this.allowRecall = allowRecall;
    }

    public PlayerSpawnRagdollEvent(){

    }
}
