package bgu.spl.net.api.bidi;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Follow extends Msg {
    private final int opCode=4;
    private String userName;
    private int numOfUsers;
    private List<String> userNameList;
    private boolean toFollow;

    public Follow(String userName,int numOfUsers,List<String> userNameList,boolean toFollow){
        this.userName=userName;
        this.numOfUsers=numOfUsers;
        this.userNameList=userNameList;
        this.toFollow=toFollow;

    }

    public Msg process(ConcurrentHashMap<String,String> users, ConcurrentHashMap<String,String> connected){
        if (!connected.containsKey(userName))
           return new Error(opCode);
        for (int i=0;i<userNameList.size();i++) {
            if (users.containsKey(userNameList.get(i))) {
                //if the current user is already followed by the user
                //send new Error.
                // else - add new follow
            }
        }
        return new Ack(opCode);

    }
}
