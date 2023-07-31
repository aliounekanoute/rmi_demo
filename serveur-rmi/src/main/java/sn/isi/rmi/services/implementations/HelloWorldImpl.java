package sn.isi.rmi.services.implementations;

import sn.isi.rmi.services.interfaces.IHelloWorld;

import java.rmi.RemoteException;

public class HelloWorldImpl implements IHelloWorld {
    public String helloWorld() throws RemoteException {
        System.out.println("Apple de la méthode helloWorld()");
        return "Hello World";
    }
}
