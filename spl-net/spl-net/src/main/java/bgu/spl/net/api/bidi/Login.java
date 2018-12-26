package bgu.spl.net.api.bidi;

import java.util.concurrent.ConcurrentHashMap;

public class Login extends Msg {

    private final int opCode=2;
    private String userName;
    private String password;

    public Login(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public Msg process(ConcurrentHashMap<String,String> users,ConcurrentHashMap<String,String> connected){
        if (users.containsKey(userName)) {
            if (users.get(userName).equals(password) && !connected.containsKey(userName))
                return new Ack(opCode);
        }
        return new Error(opCode);
    }
}
