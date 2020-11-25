package fr.uge.webServices.project;

public class BankProxy implements fr.uge.webServices.project.Bank {
  private String _endpoint = null;
  private fr.uge.webServices.project.Bank bank = null;
  
  public BankProxy() {
    _initBankProxy();
  }
  
  public BankProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankProxy();
  }
  
  private void _initBankProxy() {
    try {
      bank = (new fr.uge.webServices.project.BankServiceLocator()).getBank();
      if (bank != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bank)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bank)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bank != null)
      ((javax.xml.rpc.Stub)bank)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.webServices.project.Bank getBank() {
    if (bank == null)
      _initBankProxy();
    return bank;
  }
  
  public void display() throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    bank.display();
  }
  
  public int addAccount(long id, java.lang.String currency) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.addAccount(id, currency);
  }
  
  public void payVehicle(long id, double amountEUR) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    bank.payVehicle(id, amountEUR);
  }
  
  public boolean checkAccount(long id) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.checkAccount(id);
  }
  
  public void depositOf(long id, double amount) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    bank.depositOf(id, amount);
  }
  
  public double getAmountAccount(long id) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.getAmountAccount(id);
  }
  
  
}