import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RoueImplementation extends UnicastRemoteObject implements Roue, Serializable {

  public static final long serialVersionUID = 1L;
  static int ID = 0;
  String couleur;
  int id = ID++;

  public RoueImplementation() throws RemoteException {
    couleur = "rouge";
  }
  @Override
  public String getCouleur() throws RemoteException {
    return couleur;
  }

  @Override
  public void setCouleur(String couleur) throws RemoteException {
    this.couleur = couleur;
  }
}
