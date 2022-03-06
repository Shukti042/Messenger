package sample;

import java.io.Serializable;
import java.util.Random;

public class Data implements Serializable {
    public String reciever,sender,filename;
    byte[] b;

    public Data(String sender,String reciever,String filename) {
        Random rand=new Random();
        int n=rand.nextInt()%99;
        this.sender=sender;
        this.reciever=reciever;
        this.filename=n+filename;
    }

    public byte[] getElement() {
        return this.b;
    }
}