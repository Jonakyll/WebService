package fr.uge.webServices.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICustomer extends Remote {

	Long getId() throws RemoteException;

	void notify(String msg) throws RemoteException;

}
