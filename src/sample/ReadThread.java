package sample;

import javafx.application.Platform;

import java.util.HashMap;

public class ReadThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    public HashMap<String, NetworkUtil> clientMap;
    String name;

    public ReadThread(String cname,final HashMap<String, NetworkUtil> map) {
        clientMap=map;
        this.nc = clientMap.get(cname);
        name=cname;
        this.thr = new Thread(this);
        thr.setDaemon(true);
        thr.setName("Read Thread Server");
        thr.start();
    }


    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if (o != null) {
                    if(o instanceof  String && o.equals("Remove me"))
                    {
                        clientMap.get(name).closeConnection();
                        clientMap.remove(name);

                    }
                    //System.out.println(s);
                    else
                    new Pass(clientMap,o,name);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



