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
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		scan.close();
		
		int result = 0;
		
		switch(funct) {
			case 1:
				result = p3i.add(a, b);
				System.out.println(a + " + " + b + " = " + result);
				break;
			case 2:
				result = p3i.subtract(a, b);
				System.out.println(a + " - " + b + " = " + result);
				break;
			case 3:
				result = p3i.multiply(a, b);
				System.out.println(a + " * " + b + " = " + result);
				break;
			case 4:
				if(b == 0) {
					System.out.println("Division by zero is wrong.");
					break;
				}
				else {
					result = p3i.divid(a, b);
					System.out.println(a + " / " + b + " = " + result);
					break;
				}
			case 5:
				result = p3i.gcd(a, b);
				System.out.println("gcd(" + a + ", " + b + ") = " + result);
				break;
			case 6:
				result = p3i.lcm(a, b);
				System.out.println("lcm(" + a + ", " + b + ") = " + result);
				break;
		}
	}
}
