package sn.isi.rmi.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    static final long serialVersionUID = -7621311663069743219L;
    int id;
    String nom;
    String prenom;
    int age;

    @Override
    public String toString() {
        return String.format(
                "Etudiant(id = %d, nom = %s, prenom = %s, age = %d)",
                id,
                nom,
                prenom,
                age
        );
    }
}
