package sample;

import sun.nio.ch.Net;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pass implements Runnable {
    static public String filereciever,filesender;

    private Thread thr;
    public HashMap<String, NetworkUtil> clientMap;
    String username;
    Object message;

    public Pass(HashMap<String, NetworkUtil> map,Object msg,String un) {
        this.clientMap = map;
        message=msg;
        username=un;
        this.thr = new Thread(this);
        thr.setDaemon(true);
        thr.setName("Pass");
        thr.start();
    }
    @Override
    public void run() {
        if(message instanceof String)
        {
            try {
                String messages=(String)message;
                BufferedWriter bw=new BufferedWriter(new FileWriter("Messages.txt",true));
                bw.append(messages+"\n");
                bw.close();
                //while (true) {
                String temp[]=messages.split(":");
                String target=temp[1];
                System.out.println(target);
                NetworkUtil nc = clientMap.get(target);
                if (nc != null) {
                    if(messages!=null)
                        nc.write(messages);
                }
                // }

            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
        else
        {
            Data data=(Data)message;
            NetworkUtil nc = clientMap.get(data.reciever);
            if (nc != null) {
                //System.out.println("passing");
                if(data!=null)
                    nc.write(data);
                NetworkUtil nc1=clientMap.get(username);
                nc1.write("Your file has been sent");
            }
            else if(nc==null||!nc.socket.isConnected())
            {
                NetworkUtil nc2=clientMap.get(username);
                nc2.write("Your friend is not online");
            }
        }


    }
}
