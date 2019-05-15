package net.noyark.scpslserver.jsmod2.utils.api;

import net.noyark.scpslserver.jsmod2.math.SCPVector;

/**
 * @author magiclu550
 */

public class Generator {

    private boolean open;
    private boolean locked;
    private boolean hasTablet;
    private boolean engaged;
    private float startTime;
    private float timeLeft;
    private SCPVector position;
    private Room room;

    //TODO 解锁发包

    public void unlock(){
        if(locked){
            locked = false;
        }
    }

    //TODO 截包返回值

    public Object getComponent(){
          return null;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isHasTablet() {
        return hasTablet;
    }

    public boolean isEngaged() {
        return engaged;
    }

    public float getStartTime() {
        return startTime;
    }

    public float getTimeLeft() {
        return timeLeft;
    }

    public SCPVector getPosition() {
        return position;
    }

    public Room getRoom() {
        return room;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setHasTablet(boolean hasTablet) {
        this.hasTablet = hasTablet;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }
}
