import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.net.*;


public class Project3Server {

	public static void main(String args[]) throws RemoteException, MalformedURLException {
		int port = 16790;
		String host = "localhost";
		Project3Impl exportedObj = new Project3Impl();
		LocateRegistry.createRegistry(port);
		String registryURL = "rmi://" + host + ":" + port + "/calculator";
		Naming.rebind(registryURL, exportedObj);
		System.out.println("Server Ready");
	}
}
