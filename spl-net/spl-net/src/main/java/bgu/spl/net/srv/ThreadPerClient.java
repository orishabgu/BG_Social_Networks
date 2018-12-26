package bgu.spl.net.srv;
import bgu.spl.net.api.bidi.Msg;
import bgu.spl.net.api.bidi.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Supplier;

public class ThreadPerClient extends BaseServer{


    ConcurrentLinkedQueue<User> registeredUsers;
    ConcurrentLinkedQueue<User> whoIsLoggedIn;
    ConcurrentHashMap <User,ConcurrentLinkedQueue<User>> whoIsFollowingWho;
    ConcurrentHashMap<String,? extends Msg> posts;

    public ThreadPerClient(int port, Supplier protocolFactory, Supplier encdecFactory) {
        super(port, protocolFactory, encdecFactory);
    }

    @Override
    protected void execute(BlockingConnectionHandler handler) {
        new Thread(handler).start();
    }
}
