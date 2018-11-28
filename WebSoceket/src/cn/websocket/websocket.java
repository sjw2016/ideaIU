package cn.websocket;

import sun.awt.SunHints;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/Websocket/{hehe}")
public class websocket {
    //静态变量，用于记录当前在线连接数，应该设计成线程安全的
    private static int onlineCount = 0;
    //concurrent包的线程安全set，用于存放每个客户端对应的mywebsocket对象，若要实现服务端与单一客户
    //端通信的话，可以使用map来存放，其中key可以为用户标识
   // private static CopyOnWriteArraySet<websocket> websocketSet = new CopyOnWriteArraySet<websocket>();
    private static Map<String, websocket> map = new HashMap<String, websocket>();
    //与某个客户端连接会哈，需要通过他来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param session 可选的参数，session为某个客户端的连接会话，需要通过他来给客户发送数据
     */
    @OnOpen
    public void onOpen(@PathParam(value = "hehe") String hehe, Session session){
        this.session = session;
        map.put(hehe,this);//加入set中
        addOnlineCount();//在线数加1
        System.out.println("有新连接加入，在线数为"+getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        map.remove(this);//从set中删除
        subOnlineCount();//在线数减1
        System.out.println("有一连接关闭，在线人数为"+getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("来自客户端的消息"+message);
        //群发消息
        Set<Map.Entry<String,websocket>> set = map.entrySet();
        for(Map.Entry<String,websocket> item:set){
            try {
                String k = item.getKey();
                websocket w = item.getValue();
                sendMessage(k,message);
            } catch (IOException e){
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }
    /**
     * 发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String k,String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 获取在线人数
     * @return
     */
    public static  synchronized  int getOnlineCount(){
        return  onlineCount;
}

    /**
     * 添加一个在线人数
     */
    public static  synchronized void addOnlineCount(){
        websocket.onlineCount++;
    }

    /**
     * 减少一个在线人数
     */
    public static synchronized  void subOnlineCount(){
        websocket.onlineCount--;
    }
}
