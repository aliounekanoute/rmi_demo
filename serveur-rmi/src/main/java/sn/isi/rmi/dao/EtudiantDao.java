package sn.isi.rmi.dao;

import sn.isi.rmi.models.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDao {

    public Etudiant ajouter(Etudiant etudiant) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO etudiants (nom, prenom, age) VALUES (?, ?, ?)");

        preparedStatement.setString(1, etudiant.getNom());
        preparedStatement.setString(2, etudiant.getPrenom());
        preparedStatement.setInt(3, etudiant.getAge());

        preparedStatement.executeUpdate();

        return etudiant;
    }

    public List<Etudiant> lire() throws SQLException, ClassNotFoundException {
        List<Etudiant> etudiants = new ArrayList<>();

        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiants");

        while (resultSet.next()) {
            Etudiant etudiant = Etudiant
                    .builder()
                    .id(resultSet.getInt("id"))
                    .age(resultSet.getInt("age"))
                    .nom(resultSet.getString("nom"))
                    .prenom(resultSet.getString("prenom"))
                    .build();

            etudiants.add(etudiant);
        }

        return etudiants;
    }
}
