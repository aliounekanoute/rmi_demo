package sn.isi.rmi.services.interfaces;

import sn.isi.rmi.models.Etudiant;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface EtudiantService extends Remote {
    Etudiant ajouter(Etudiant etudiant) throws RemoteException, SQLException, ClassNotFoundException;
    List<Etudiant> lire() throws RemoteException, SQLException, ClassNotFoundException;
}
