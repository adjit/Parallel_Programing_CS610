import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;

public class MyClient {
	
	public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		int port = 16790;
		String host = "localhost";
		String registryURL = "rmi://" + host + ":" + port + "/calculator";
		Project3Interface p3i = (Project3Interface)Naming.lookup(registryURL);
		
		Scanner scan = new Scanner(System.in);
		
		//Begin polling
		System.out.println("Enter 1, 2, 3, 4, 5, or 6 to add subtract, multiply, divide, GCD, or LCM of two integers: ");
		int funct = scan.nextInt();
		
		//Poll for two integers
		System.out.println("Enter two integers:");
		String[] stringInput = scan.nextLine().split(" ");
		int[] inputArr = new int[stringInput.length];
		
		for(int i = 0; i < stringInput.length; i++) {
			inputArr[i] = Integer.parseInt(stringInput[i]);
		}
		
		switch(funct) {
			case 1:
				int result = p3i.add(inputArr[0], inputArr[1]);
				
				break;
		}
	}
}