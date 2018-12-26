package bgu.spl.net.api.bidi;

import java.util.concurrent.ConcurrentHashMap;

public class Post extends Msg {
    private final int opCode=5;
    private String userName;
    private String content;

    public Post(String userName,String content){
        this.userName=userName;
        this.content=content;

    }

    public Msg process(ConcurrentHashMap<String,String> users){
        if (users.containsKey(userName)) {
            if (connected.containsKey(userName))
                return new Ack(opCode);
        }
        return new Error(opCode);
    }
}
