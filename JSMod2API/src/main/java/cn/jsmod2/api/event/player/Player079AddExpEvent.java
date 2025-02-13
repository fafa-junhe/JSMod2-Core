/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2.api.event.player;

import cn.jsmod2.api.player.ExperienceType;
import cn.jsmod2.api.player.Player;
import cn.jsmod2.core.annotations.UseForServerInit;

/**
 * @author kevinj
 */

public class Player079AddExpEvent extends PlayerEvent {
    private ExperienceType experienceType;
    private float expToAdd;

    public ExperienceType getExperienceType() {
        return experienceType;
    }

    public float getExpToAdd() {
        return expToAdd;
    }

    public void setExpToAdd(float expToAdd) {
        this.expToAdd = expToAdd;
    }



    public Player079AddExpEvent(Player player, ExperienceType experienceType, float expToAdd) {
        super(player);
        this.experienceType = experienceType;
        this.expToAdd = expToAdd;
    }

    public Player079AddExpEvent(){

    }
}
