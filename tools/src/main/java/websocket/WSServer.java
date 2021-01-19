package websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.websocket.Session;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/webSocket/{username}")
public class WSServer {
    private static int onlineClient = 0;
    private static Map<String, WSServer> clients = new ConcurrentHashMap();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) throws IOException {
        this.username = username;
        this.session = session;
        onlineClient++;
        clients.put(username, this);
        System.out.printf(session.getId() + "ws已连接");
    }

    @OnClose
    public void onClose() throws IOException {
        clients.remove(username);
        onlineClient--;
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        JSONObject jsonObject = JSON.parseObject(message);
        String mes = (String) jsonObject.get("message");
        if (!jsonObject.get("To").equals("All")) {
            sendMessageTo(mes, jsonObject.get("To").toString());
        } else {
            sendMessageAll("给所有人");
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();

    }

    public void sendMessageTo(String message, String To) throws IOException {
        //session.getBasicRemote().sendText(message);
        //session.getAsyncRemote().sendText(message);
        for (WSServer item : clients.values()) {
            if (item.username.equals(To) ) item.session.getAsyncRemote().sendText(message);
        }

    }

    public void sendMessageAll(String message) throws IOException {
        for (WSServer item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }

    }

    public static void main(String[] args) {
        WSServer ws = new WSServer();
        //JSONObject jo = new JSONObject();
        //jo.put("message", "这是后台返回的消息！");
        //jo.put("To", "test");
        //try {
        //    ws.onMessage(jo.toString());
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }
}
