package fr.uge.webServices.project;

public class GarageProxy implements fr.uge.webServices.project.Garage {
  private String _endpoint = null;
  private fr.uge.webServices.project.Garage garage = null;
  
  public GarageProxy() {
    _initGarageProxy();
  }
  
  public GarageProxy(String endpoint) {
    _endpoint = endpoint;
    _initGarageProxy();
  }
  
  private void _initGarageProxy() {
    try {
      garage = (new fr.uge.webServices.project.GarageServiceLocator()).getGarage();
      if (garage != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)garage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)garage)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (garage != null)
      ((javax.xml.rpc.Stub)garage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.webServices.project.Garage getGarage() {
    if (garage == null)
      _initGarageProxy();
    return garage;
  }
  
  public long createBankAccount(java.lang.String currency) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.createBankAccount(currency);
  }
  
  public int bankSize() throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.bankSize();
  }
  
  public boolean getAvailability(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getAvailability(car);
  }
  
  public fr.uge.webServices.project.Car[] getCars() throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getCars();
  }
  
  public double getAmountAccount(long id) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getAmountAccount(id);
  }
  
  public boolean checkAccount(long id) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.checkAccount(id);
  }
  
  public java.lang.String getCurrencyAccount(long id) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getCurrencyAccount(id);
  }
  
  public int addAccount(long id, java.lang.String currency, int amount) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.addAccount(id, currency, amount);
  }
  
  public void addCar(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    garage.addCar(car);
  }
  
  public long getPrice(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getPrice(car);
  }
  
  public float getRating(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getRating(car);
  }
  
  public void displayBank() throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    garage.displayBank();
  }
  
  public void depositOf(long account_id, double amount) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    garage.depositOf(account_id, amount);
  }
  
  public java.lang.String getModel(fr.uge.webServices.project.Car car) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getModel(car);
  }
  
  public double getAmountAccountEUR(long id) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.getAmountAccountEUR(id);
  }
  
  public boolean buy(long id_account, fr.uge.webServices.project.Car[] cart, double amount) throws java.rmi.RemoteException{
    if (garage == null)
      _initGarageProxy();
    return garage.buy(id_account, cart, amount);
  }
  
  
}