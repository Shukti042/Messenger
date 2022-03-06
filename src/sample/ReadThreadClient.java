package sample;


import  java.io.*;
import javafx.application.Platform;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class ReadThreadClient implements Runnable {
   private Thread thr;
    private NetworkUtil nc;
    messageController cont;
    Main main;
    String owner;

    public ReadThreadClient(NetworkUtil nc, messageController controller, Main main, String name) {
        this.nc = nc;
        cont=controller;
       this.thr = new Thread(this);
       this.main=main;
        thr.setDaemon(true);
        thr.setName("Read Thread Client");
       // Platform.setImplicitExit(false);
        thr.start();
        owner=name;

    }

    public void run() {
        try {
            while (true) {
                Object s = nc.read();
                if(s instanceof String&&s!=null)
                {
                    String ss=(String)s;
                    if(ss.equals("Your friend is not online"))
                    {
                        Platform.runLater(
                                () -> {
                                    cont.givealart(ss);
                                }
                        );
                    }
                    else if(ss.equals("Your file has been sent"))
                    {
                        Platform.runLater(
                                () -> {
                                    cont.givealart2(ss);
                                }
                        );
                    }

                    else
                    {
                        Platform.runLater(
                                () -> {
                                    cont.Show(ss);
                                }
                        );

                    }
                }
                else if(s!=null&&s instanceof Data)
                {
                    Data d=(Data)s;
                    String destination=d.reciever+"/"+d.filename;
                    OutputStream out=new FileOutputStream(destination);
                    out.write(d.b);
                    out.close();
                    Platform.runLater(
                            () -> {
                                cont.notification(d.sender,d.filename);
                            }
                    );


                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}