package bgu.spl.net.api.bidi;

import java.util.concurrent.ConcurrentHashMap;

public class Logout extends Msg {

    private final int opCode=3;
    private String userName;

    public Logout(String userName){
        this.userName=userName;

    }

    public Msg process(ConcurrentHashMap<String,String> users, ConcurrentHashMap<String,String> connected){
        if (users.containsKey(userName)) {
            if (connected.containsKey(userName))
                return new Ack(opCode);
        }
        return new Error(opCode);
    }
}
