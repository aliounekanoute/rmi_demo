package sn.isi.rmi.services.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloWorld extends Remote {
    String helloWorld() throws RemoteException;
}
