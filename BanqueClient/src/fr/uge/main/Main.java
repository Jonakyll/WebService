package fr.uge.main;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.webServices.project.Bank;
import fr.uge.webServices.project.BankServiceLocator;
import fr.uge.webServices.project.BankSoapBindingStub;

public class Main {

	public static void main(String[] args) throws ServiceException, RemoteException {
		Bank bank = new BankServiceLocator().getBank();
		((BankSoapBindingStub)bank).setMaintainSession(true);
		bank.addAccount(1, "USD");
		bank.addAccount(2, "JPY");
		bank.addAccount(3, "EUR");
		bank.display();
		bank.depositOf(1, 10000);
		bank.payVehicle(1, 8000);
		bank.payVehicle(2, 8000);

	}

}
