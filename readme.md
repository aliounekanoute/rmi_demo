# Projet Java avec Maven, JavaFx, JDBC et RMI

## Description

Projet Java simple pour la prise en main de Maven, JavaFx, RMI et JDBC. 

Nous avons deux projets, serveur-rmi qui correspond au serveur et expose les fonctionnalités suivantes:
- Ajouter étudiant
- Lister les étudiants

Le projet client-rmi qui contient les interfaces qui permettent d'exécuter les fonctionnalités sur le serveur de manière distant en utilisant le protocole RMI.

## Pré-recquis
- Java 17
- Maven
- PostgreSQL

## Lancer serveur-rmi

### Configurer la base de données

Dans ce projet, nous avons utilisé une base de données PostgreSQL. Il faut donc préparer la base de données, voici ce qu'il faut faire:

- #### Créer la base de données
    Sur votre serveur postgres, créez la base de données ```isi_db```, et donnez tous les droits à l'utilisateur ```postgres``` identifiable avec le mot de passe ```postgres```. Si vous voulez ajouter votre propre configuration, vous pouvez modifier le fichier ```DatabaseConfig``` qui se trouve dans le package ```sn.isi.rmi.dao```.

- #### Créer la table étudiants
    Voici la requête suivante pour créer la table ```etudiants```:

    ```sql
        CREATE TABLE etudiants (
            id SERIAL PRIMARY KEY,
            nom VARCHAR(100) NOT NULL,
            prenom VARCHAR(100) NOT NULL,
            age INTEGER NOT NULL
        );
    ```

### Lancer le serveur

- #### Générer le fichier jar
    Ouvrir une console dans le dossier du projet server-rmi puis exécuter cette commande pour générer le fichier jar du projet:

    ```mvn package```

- #### Démarrer le serveur:
    Ouvrir une console dans le dossier du projet server-rmi puis exécuter cette commande pour démarrer le serveur:

    ```java -jar target/serveur-rmi-1.0-SNAPSHOT.jar```

### Lancer le client    
Pour démarrer le client, il faut ouvrir une console dans le dossier client-rmi et exécuter cette commande:

```mvn javafx:run```
