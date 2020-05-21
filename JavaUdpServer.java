import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/*
reference:
https://docs.oracle.com/javase/tutorial/networking/datagrams/clientServer.html
*/
public class JavaUdpServer {
    
    static UdpServerThread udpServerThread;

    public static void main(String[] args) throws IOException {
        System.out.println("Server start");
        System.out.println("Runtime Java: " 
                + System.getProperty("java.runtime.version"));
        
        
        new UdpServerThread().start();
    }

    private static class UdpServerThread extends Thread{
        
        final int serverport = 4445;
        
        protected DatagramSocket socket = null;
        
        public UdpServerThread() throws IOException {
            this("UdpServerThread");
        }
        
        public UdpServerThread(String name) throws IOException {
            super(name);
            socket = new DatagramSocket(serverport);
            System.out.println("JavaUdpServer run on: " + serverport);
        }

        @Override
        public void run() {
            
            while(true){
                
                try {
                    byte[] buf = new byte[256];
                    
                    // receive request
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    
                    String dString = new Date().toString();
                    buf = dString.getBytes();
                    
                    // send the response to the client at "address" and "port"
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
                    System.out.println("Request from: " + address + ":" + port);
                    packet = new DatagramPacket(buf, buf.length, address, port);
                    socket.send(packet);
                    
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
                
            }
            
        }
        
    }
    
}