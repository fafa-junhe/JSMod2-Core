package cn.jsmod2.network.protocol.event.admin;

import cn.jsmod2.api.player.Player;
import cn.jsmod2.network.protocol.event.packet.EventSetPacket;

public class AdminQueryAdminSet extends EventSetPacket {

    public Player admin;

    public static final int ID = 0x66;
    public AdminQueryAdminSet() {
        super(ID);
    }

    @Override
    public void send() {
        requester.with("admin",admin)
                .with("player",playerName)
                .to();
    }
}
