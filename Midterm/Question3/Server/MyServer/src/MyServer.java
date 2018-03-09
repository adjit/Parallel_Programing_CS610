import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;

public class MyServer{
  public static void main(String args[]) throws RemoteException, MalformedURLException{
	  int port = 16790;
		String host = "localhost";
		VoteServerImpl exportedObj = new VoteServerImpl();
		LocateRegistry.createRegistry(port);
		String registryURL = "rmi://" + host + ":" + port + "/vote";
		Naming.rebind(registryURL, exportedObj);
		System.out.println("Server Ready");
  
  }
}
