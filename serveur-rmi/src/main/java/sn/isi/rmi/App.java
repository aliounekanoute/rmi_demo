package sn.isi.rmi;

import sn.isi.rmi.services.implementations.EtudiantServiceImpl;
import sn.isi.rmi.services.implementations.HelloWorldImpl;
import sn.isi.rmi.services.interfaces.EtudiantService;
import sn.isi.rmi.services.interfaces.IHelloWorld;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            EtudiantServiceImpl etudiantService = new EtudiantServiceImpl();
            EtudiantService stub = (EtudiantService) UnicastRemoteObject.exportObject(etudiantService, 0);
            LocateRegistry.createRegistry(2000);

            Naming.rebind("rmi://localhost:2000/hello", stub);
            System.out.println("Le serveur a démarré");
        } catch (Exception exception ) {
            System.out.println( exception.getCause() + " : " + exception.getMessage());
        }
    }
}
