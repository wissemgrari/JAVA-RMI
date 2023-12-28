import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Voiture extends Remote {
  public Roue getRoue() throws RemoteException;
  public String getNewVoiture() throws RemoteException;
}
