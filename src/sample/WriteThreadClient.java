package sample;


import java.util.Scanner;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    String message;

    public WriteThreadClient(NetworkUtil nc, String message) {
        this.nc = nc;
        this.message = message;
        this.thr = new Thread(this);
        thr.setName("WriteThreadClient");
        thr.setDaemon(true);
        thr.start();
    }

    public void run() {
        try {
                nc.write(message);
            } catch (Exception e) {
            System.out.println(e);
        }
    }
}



