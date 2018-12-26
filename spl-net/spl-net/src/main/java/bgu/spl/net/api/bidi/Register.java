package bgu.spl.net.api.bidi;

import java.util.concurrent.ConcurrentHashMap;

public class Register extends Msg {
    private final int opCode=1;
    private String userName;
    private String password;

    public Register(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public Msg process(ConcurrentHashMap<String,String> users){
        if (users.containsKey(userName)) {
            return new Error(opCode);
        }
        else
            return new Ack(opCode);
}
