/**
 * Garage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.webServices.project;

public interface Garage extends java.rmi.Remote {
    public void initCars() throws java.rmi.RemoteException;
    public boolean getAvailability(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException;
    public void addToCart() throws java.rmi.RemoteException;
    public void buy() throws java.rmi.RemoteException;
    public long getPrice(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException;
    public void addCar(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException;
    public fr.uge.webServices.project.Car[] getCars() throws java.rmi.RemoteException;
}
