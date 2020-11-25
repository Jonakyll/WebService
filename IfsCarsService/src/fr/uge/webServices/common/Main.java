package fr.uge.webServices.common;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.project.Bank;
import fr.uge.webServices.project.BankServiceLocator;
import fr.uge.webServices.project.BankSoapBindingStub;
import fr.uge.webServices.project.Garage;

public class Main {

	public static void main(String[] args) throws RemoteException, ServiceException {
//		Bank bank = new BankServiceLocator().getBank();
//		((BankSoapBindingStub) bank).setMaintainSession(true);
//		bank.display();
		Garage garage = new Garage();
		garage.displayBank();
	}

}
