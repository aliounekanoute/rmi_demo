package sn.isi.rmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sn.isi.rmi.models.Etudiant;
import sn.isi.rmi.services.interfaces.EtudiantService;
import sn.isi.rmi.services.interfaces.IHelloWorld;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {

        launch(args);
        
//        try {
//            Scanner scanner = new Scanner(System.in);
//            int action = 0;
//            EtudiantService etudiantService = (EtudiantService) Naming.lookup("rmi://localhost:2000/hello");
//
//            do {
//                System.out.println("Choisir une action effectuer:\n 1. Afficher la liste des étudiants\n 2. Ajouter un étudiant\n 0. Pour quitter");
//                action = scanner.nextInt();
//
//                switch (action) {
//                    case 1:
//                        List<Etudiant> etudiants = etudiantService.lire();
//                        System.out.println("--------------------------------");
//                        System.out.println("Nombre : " + etudiants.size());
//                        for (Etudiant etudiant: etudiants
//                        ) {
//                            System.out.println(etudiant.toString());
//                        }
//                        System.out.println("--------------------------------");
//                        break;
//                    case 2:
//                        scanner.nextLine();
//                        System.out.println("nom:");
//                        String nom = scanner.nextLine();
//                        System.out.println("prenom:");
//                        String prenom = scanner.nextLine();
//                        System.out.println("age:");
//                        int age = scanner.nextInt();
//                        Etudiant etudiant = etudiantService.ajouter(Etudiant.builder().nom(nom).prenom(prenom).age(age).build());
//
//                        System.out.println("Etudiant ajouté avec succés : " + etudiant.toString());
//                        break;
//                    default:
//                        System.exit(0);
//                        break;
//                }
//            } while (true);
//
//        } catch (RemoteException | NotBoundException | MalformedURLException | SQLException |
//                 ClassNotFoundException exception) {
//            System.out.println(exception.getMessage());
//        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/main.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
