import java.rmi.Naming;

public class Client {
  public static void main(String[] args) {
    try {
      // on récupère la liste des noms des objets disponbiles
      String [] objetsDispo = Naming.list("rmi://localhost:1099/vi");
      for(String obj: objetsDispo){
        System.out.println(obj);
      }

      // on récupère un pointeur sur le premier objet Voiture
      Voiture voiture = (Voiture) Naming.lookup(objetsDispo[0]);
      // voiture.getRoue() returne un pointeur sur l'objet
      // Roue de l'objet voiture courant
      System.out.println(voiture.getRoue().getCouleur());
      voiture.getRoue().setCouleur("vert");
      System.out.println(voiture.getRoue().getCouleur());
      // on récupère un pointeur sur le nouvel objet distant créé
      Voiture v = (Voiture) Naming.lookup(voiture.getNewVoiture());
      // getNewVoiture() créé un nouvel objet VoitureImplementation
      System.out.println(v.getRoue().getCouleur());
      v.getRoue().setCouleur("rose");
      System.out.println(v.getRoue().getCouleur());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
