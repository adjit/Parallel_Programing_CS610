import java.io.*;
import java.net.*;

public class MyClient {
  public static void main(String[] args) throws IOException {
    
    try {
      final int MAX_LEN = 100;
      byte[] buffer = new byte[MAX_LEN];
      int port = 16790;
      DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
      DatagramSocket clientSocket = new DatagramSocket(port);
      clientSocket.setSoTimeout(5000);
      try {
    	  clientSocket.receive(datagram);
      } catch (SocketTimeoutException e)
      {
    	  System.out.println("timed out on receiver");
    	  System.exit(0);
      }
      
      String message = new String(buffer);
      System.out.println(message);
      clientSocket.close();
    } catch (IOException e) {
        System.out.println("Error: " + e);
        System.exit(0);
    }
  }
}
