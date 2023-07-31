package sn.isi.rmi.services.implementations;

import lombok.AllArgsConstructor;
import sn.isi.rmi.dao.EtudiantDao;
import sn.isi.rmi.models.Etudiant;
import sn.isi.rmi.services.interfaces.EtudiantService;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantDao etudiantDao;

    public EtudiantServiceImpl() {
        etudiantDao = new EtudiantDao();
    }
    @Override
    public Etudiant ajouter(Etudiant etudiant) throws RemoteException, SQLException, ClassNotFoundException {
        return etudiantDao.ajouter(etudiant);
    }

    @Override
    public List<Etudiant> lire() throws RemoteException, SQLException, ClassNotFoundException {
        return etudiantDao.lire();
    }
}
