import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.server.*;

public class Project3Impl extends UnicastRemoteObject implements Project3Interface {

	public Project3Impl() throws RemoteException {
		super();
	}
	
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a+b;
	}

	public int subtract(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a-b;
	}

	public int multiply(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a*b;
	}

	public int divid(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a/b;
	}

	public int gcd(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		int gcd = 1;
		
		if(a < 0) a = -a;
		if(b < 0) b = -b;
		
		for (int i = 1; i <= a && i <= b; i++) {
			if (a%i == 0 && b%i ==0) {
				gcd = i;				
			}
		}
		
		return gcd;
	}

	public int lcm(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a*b/gcd(a,b);
	}

}
