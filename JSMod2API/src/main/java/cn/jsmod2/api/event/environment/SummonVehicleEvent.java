/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2.api.event.environment;

import cn.jsmod2.core.event.Event;

/**
 * @author Kevinj
 * @author magiclu550
 */

public class SummonVehicleEvent extends Event {
    private boolean IsCI;

    private boolean allowSummon;

    public boolean isCI() {
        return IsCI;
    }

    public void setCI(boolean CI) {
        IsCI = CI;
    }

    public boolean isAllowSummon() {
        return allowSummon;
    }

    public void setAllowSummon(boolean allowSummon) {
        this.allowSummon = allowSummon;
    }

    public SummonVehicleEvent(boolean isCI, boolean allowSummon) {
        IsCI = isCI;
        this.allowSummon = allowSummon;
    }

    public SummonVehicleEvent(){

    }

}
