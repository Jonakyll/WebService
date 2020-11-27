/**
 * Garage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.webServices.project;

public interface Garage extends java.rmi.Remote {
    public int addAccount(long id, java.lang.String currency, int amount) throws java.rmi.RemoteException;
    public double getAmountAccount(long id) throws java.rmi.RemoteException;
    public boolean checkAccount(long id) throws java.rmi.RemoteException;
    public java.lang.String getCurrencyAccount(long id) throws java.rmi.RemoteException;
    public void depositOf(long account_id, double amount) throws java.rmi.RemoteException;
    public double getAmountAccountEUR(long id) throws java.rmi.RemoteException;
    public long createBankAccount(java.lang.String currency) throws java.rmi.RemoteException;
    public boolean getAvailability(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException;
    public long getPrice(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException;
    public void addCar(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException;
    public float getRating(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException;
    public void displayBank() throws java.rmi.RemoteException;
    public boolean buy(long id_account, fr.uge.webServices.project.Car[] cart) throws java.rmi.RemoteException;
    public fr.uge.webServices.project.Car[] getCars() throws java.rmi.RemoteException;
    public int bankSize() throws java.rmi.RemoteException;
}
