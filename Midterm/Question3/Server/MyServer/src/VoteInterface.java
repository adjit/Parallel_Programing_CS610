import java.rmi.Remote;
public interface VoteInterface  extends Remote{
  // This interface is complete. Do not change it.
  public String castVote(char vote )throws java.rmi.RemoteException;
}
