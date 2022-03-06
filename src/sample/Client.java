package sample;


public class Client {
   public String clientName;
    public NetworkUtil nc;
    messageController cont;
    String to;
    public void setto(String s)
    {
        to=s;
        nc.write(to);
    }

    public Client(String serverAddress, int serverPort,String name,messageController m) {
        try {
            clientName = name;
            nc = new NetworkUtil(serverAddress, serverPort);
            nc.write(clientName);
            cont=m;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

