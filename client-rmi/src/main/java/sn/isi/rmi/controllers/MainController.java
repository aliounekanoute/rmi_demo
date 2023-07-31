package sn.isi.rmi.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sn.isi.rmi.models.Etudiant;
import sn.isi.rmi.services.interfaces.EtudiantService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class MainController {
    @FXML
    private TableColumn<Etudiant, ?> ageColumn;

    @FXML
    private TextField ageInput;

    @FXML
    private TableColumn<Etudiant, ?> idColumn;

    @FXML
    private TableView<Etudiant> listeEtudiantTable;

    @FXML
    private TableColumn<Etudiant, ?> nomColumn;

    @FXML
    private TextField nomInput;

    @FXML
    private TableColumn<Etudiant, ?> prenomColumn;

    @FXML
    private TextField prenomInput;
    EtudiantService etudiantService;
    Etudiant etudiant;
    List<Etudiant> etudiants;
    public MainController() {

        try {
            etudiantService = (EtudiantService) Naming.lookup("rmi://localhost:2000/hello");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println(e.getCause() + " : " + e.getMessage());
            System.exit(-1);
        }
    }

    public void initialize() {
        listerEtudiant();
    }

    @FXML
    public void ajouterEtudiantEvent(MouseEvent event) {
        etudiant = Etudiant
                .builder()
                .nom(nomInput.getText())
                .prenom(prenomInput.getText())
                .age(Integer.parseInt(ageInput.getText()))
                .build();

        try {
            Etudiant newEtudiant = etudiantService.ajouter(etudiant);
            System.out.println(newEtudiant.toString());
            listerEtudiant();
        } catch (RemoteException | SQLException | ClassNotFoundException e) {
            System.out.println(e.getCause() + " : " + e.getMessage());
        }
    }

    private void listerEtudiant() {
        try {
            etudiants = etudiantService.lire();


            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

            listeEtudiantTable.setItems(FXCollections.observableList(etudiants));

        } catch (RemoteException | SQLException | ClassNotFoundException e) {
            System.out.println(e.getCause() + " : " + e.getMessage());
        }
    }
}
