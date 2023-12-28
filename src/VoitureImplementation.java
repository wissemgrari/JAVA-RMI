import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VoitureImplementation extends UnicastRemoteObject implements Voiture {

  RoueImplementation roue;

  public VoitureImplementation() throws RemoteException {
    roue = new RoueImplementation();
    try {
      Naming.rebind("ROUE_" + roue.id, roue);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Roue getRoue() throws RemoteException {
    try {
      return (Roue) Naming.lookup("rmi://localhost/ROUE_" + roue.id);
    } catch (Exception e ) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String getNewVoiture() throws RemoteException {
    VoitureImplementation vi = new VoitureImplementation();
    try {
      Naming.rebind("VOITURE", vi);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Nouvelle voiture");
    return "VOITURE";
  }

  public static void main(String[] args) {
    try {
      // on lance l'annuaire des objets distants
      java.rmi.registry.LocateRegistry.createRegistry(1099);
      for(int i=0; i<10; i++) {
        VoitureImplementation vi = new VoitureImplementation();
        Naming.rebind("VOITURE_" + i, vi);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
