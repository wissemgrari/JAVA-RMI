import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Roue extends Remote {
  public String getCouleur() throws RemoteException;
  public void setCouleur(String couleur) throws RemoteException;
}
