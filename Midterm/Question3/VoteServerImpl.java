import java.rmi.*;
import java.rmi.server.*;

public class VoteServerImpl extends UnicastRemoteObject implements VoteInterface {
  // Complete this class.
	private int yesNum;
	private int noNum;
	
	public VoteServerImpl() throws RemoteException {
		super();
	}
	
	public String castVote(char vote )throws java.rmi.RemoteException{
		if (vote == 'y') { 
			yesNum += 1;
		}
		else if (vote == 'n')  {
		
			noNum += 1;
		}
		return ("Yes = " + yesNum + "; " + "No = " + noNum);
		
	}
}
