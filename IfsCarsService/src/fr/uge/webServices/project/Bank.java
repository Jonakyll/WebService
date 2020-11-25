/**
 * Bank.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.webServices.project;

public interface Bank extends java.rmi.Remote {
    public void display() throws java.rmi.RemoteException;
    public int addAccount(long id, java.lang.String currency) throws java.rmi.RemoteException;
    public void payVehicle(long id, double amountEUR) throws java.rmi.RemoteException;
    public boolean checkAccount(long id) throws java.rmi.RemoteException;
    public void depositOf(long id, double amount) throws java.rmi.RemoteException;
    public double getAmountAccount(long id) throws java.rmi.RemoteException;
}
