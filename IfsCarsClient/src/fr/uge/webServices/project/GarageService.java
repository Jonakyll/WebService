/**
 * GarageService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.webServices.project;

public interface GarageService extends javax.xml.rpc.Service {
    public java.lang.String getGarageAddress();

    public fr.uge.webServices.project.Garage getGarage() throws javax.xml.rpc.ServiceException;

    public fr.uge.webServices.project.Garage getGarage(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
