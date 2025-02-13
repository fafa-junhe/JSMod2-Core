package cn.jsmod2.test.foundbug.jsmod2;

import cn.jsmod2.DefaultServer;
import cn.jsmod2.api.event.player.PlayerEvent;
import cn.jsmod2.api.event.player.PlayerJoinEvent;
import cn.jsmod2.core.ApiId;
import cn.jsmod2.core.Application;
import cn.jsmod2.core.annotations.ServerApplication;
import cn.jsmod2.core.event.Event;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.UUID;

@ServerApplication(DefaultServer.class)
public class PacketTest {

    //一个简单解析jsmod2协议的代码
    @Test
    public void eventRe(){
        Application.run(PacketTest.class,new String[]{});
    }

    @Test
    public void eventSend() throws Exception{
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("127.0.0.1",19938));
        socket.connect(new InetSocketAddress("127.0.0.1",19935));
        socket.getOutputStream().write(Base64.getEncoder().encode(("45-{}|player-scp079Data-playerName:"+ UUID.randomUUID()).getBytes()));
        socket.close();
    }

    @Test
    public void eventId() throws Exception{
        PlayerEvent playerEvent = new PlayerJoinEvent();
        insertField(new String[]{"player-scp079Data-playerName:"+UUID.randomUUID().toString()},playerEvent);

    }

    private void insertField(String[] props,Object o) throws Exception{
        for(int i = 0;i<props.length;i++){
            String[] key_value = props[i].split(":");
            String[] fields = key_value[0].split("-");
            Object field = o;
            for(int j = 0;j<fields.length-1;j++){
                field = invokeGetMethod(field,fields[j]);
            }
            invokeSetMethod(field,fields[fields.length-1],key_value[1]);
        }
    }

    private Object invokeGetMethod(Object o,String field) throws Exception{
        StringBuilder builder = new StringBuilder((field.charAt(0)+"").toUpperCase());
        String first = "get"+builder.append(field.substring(1));
        return getMethod(o.getClass(),first);
    }

    private void invokeSetMethod(Object o,String field,String value) throws Exception{
        System.out.println(field);
        System.out.println(o);
        Field field1 = getField(o.getClass(),field);
        field1.setAccessible(true);
        Class<?> clz = field1.getType();
        Object object;
        try {
            object = JSON.parseObject(value, clz);
        }catch (JSONException e){
            object = value;
        }
        field1.set(o,object);
    }

    private Field getField(Class clz,String field) throws NoSuchFieldException{
        while (!clz.equals(Object.class)){
            clz = clz.getSuperclass();
            if(hasField(clz,field)){
                Field field1 = clz.getDeclaredField(field);
                field1.setAccessible(true);
                return field1;
            }
        }
        return null;
    }

    private boolean hasField(Class clz,String field){
        try {
            clz.getDeclaredField(field);
            return true;
        }catch (NoSuchFieldException e){

        }
        return false;
    }

    private Method getMethod(Class clz,String method) throws Exception{
        while (!clz.equals(Object.class)) {
            clz = clz.getSuperclass();
            if(hasMethod(clz,method)){
                return clz.getMethod(method);
            }
        }
        return null;
    }

    private boolean hasMethod(Class clz,String method){
        try{
            clz.getDeclaredMethod(method);
            return true;
        }catch (NoSuchMethodException e){
        }
        return false;
    }



}
