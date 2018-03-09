import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;

public class MyClient{
  public static void main(String args[])  throws MalformedURLException, RemoteException, NotBoundException{
	  int port = 16792;
		String host = "localhost";
		String registryURL = "rmi://" + host + ":" + port + "/vote";
		VoteInterface voteI = (VoteInterface)Naming.lookup(registryURL);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is your vote?[yes|no] : ");
		String vote = scan.nextLine();
		if (vote.equals("yes")) {
			System.out.println(voteI.castVote('y'));
		}else if (vote.equals("no")) {
			System.out.println(voteI.castVote('n'));
		}else {
			System.out.println("Incorrect choice");
			System.out.println(voteI.castVote('w'));
		}

  }
}

