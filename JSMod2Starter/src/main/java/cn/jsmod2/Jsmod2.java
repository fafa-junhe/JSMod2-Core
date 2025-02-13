/*
Jsmod2 is a java-based scpsl server initiated by jsmod2.cn.
It needs to rely on smod2 and proxy. jsmod2 is an open source
free plugin that is released under the GNU license. Please read
the GNU open source license before using the software. To understand
the appropriateness, if infringement, will be handled in accordance
with the law, @Copyright Jsmod2 China,more can see <a href="http://jsmod2.cn">that<a>
 */
package cn.jsmod2;

import cn.jsmod2.core.Application;
import cn.jsmod2.core.annotations.ServerApplication;
import cn.jsmod2.core.utils.Utils;
import java.util.concurrent.CountDownLatch;

/**
 * @author magiclu550 #(code) jsmod2
 */
//目前jsmod2还差的功能
//1.UI启动器，未来将设计UI启动器，可视化的开启关闭服务器，检测服务器流量，人数，其他参数，控制台信息
//2.测试框架，实现离线测试操作，即不连接游戏即可测试程序
//3.基本的数据定义
//4.a链接SteamCMD 子工程
//5.emerald 脚本 子工程
@ServerApplication(DefaultServer.class)
public class Jsmod2 {

    public static void main(String[]args){
        Utils.TryCatch(()->{
            CountDownLatch latch = new CountDownLatch(1);
            new Thread(()->{
                Starter.run(args);
                latch.countDown();
            }).start();
            latch.await();
            CountDownLatch latch1 = new CountDownLatch(1);
            new Thread(()->{
                latch1.countDown();
                Application.run(Jsmod2.class,args);
            }).start();
            latch1.await();
            UIStarter.run(args);
        });
    }


}
