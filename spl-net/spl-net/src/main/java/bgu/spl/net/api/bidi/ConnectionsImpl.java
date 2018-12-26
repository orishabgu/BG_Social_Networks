package bgu.spl.net.api.bidi;

import bgu.spl.net.api.bidi.Connections;
import bgu.spl.net.srv.ConnectionHandler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionsImpl<T> implements Connections<T> {

    private int IDCounter;
    private ConcurrentHashMap<Integer,String> userIdName; //all users
    private ConcurrentHashMap<Integer,String> activeUsers; //active users
    private ConcurrentHashMap<Integer,ConcurrentLinkedQueue<ConnectionHandler>> userIDConnectionHandler;

    public ConnectionsImpl(){
        userIdName=new ConcurrentHashMap<>();
        activeUsers=new ConcurrentHashMap<>();
        userIDConnectionHandler=new ConcurrentHashMap<>();
        IDCounter=0;

    }

    @Override
    public boolean send(int connectionId, T msg) {
        return false;
        //userNameConnectionHandler.get(connectionId).
    }

    @Override
    public void broadcast(T msg) {
        for(Map.Entry<Integer,String> users:activeUsers.entrySet()){
            send(users.getKey(),msg);
        }
    }

    @Override
    public void disconnect(int connectionId) {
        if(activeUsers.get(connectionId)!=null)
            activeUsers.remove(activeUsers.get(connectionId));
    }

    private void connect(String userName){
        activeUsers.put(IDCounter,userName);
        userIDConnectionHandler.put(IDCounter, new ConcurrentLinkedQueue<>());
        userIdName.put(IDCounter,userName);

        IDCounter++;

    }
}
