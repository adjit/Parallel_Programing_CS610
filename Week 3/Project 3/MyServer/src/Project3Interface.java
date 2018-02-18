import java.rmi.*;
public interface Project3Interface extends Remote {
  //This interface is complete. Do NOT CHANGE IT.
	
	public int add(int a, int b) throws RemoteException;		//returns a+b
	public int subtract(int a, int b) throws RemoteException; 	//returns a-b
	public int multiply(int a, int b) throws RemoteException; 	//returns a*b
	
	//For division the client should check the case of division by zero.
	//If it happens issues an error message. If not calls the following method.
	public int divid(int a, int b) throws RemoteException; 	//returns a/b.
	public int gcd(int a, int b) throws RemoteException; 	//returns gcd(a, b).
	public int lcm(int a, int b) throws RemoteException; 	//returns lcm(a, b).
}
