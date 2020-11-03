package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

import fr.uge.webServices.project.Car;
import fr.uge.webServices.project.ICar;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);

		ICar car = new Car();
		car.setId(1234L);
		car.setRating(4.5F);
		car.setState(true);
		car.setTenants(List.of(2222L, 3333L));
		Naming.rebind("rmi://localhost:1099/car", car);
		System.out.println("server launched!");
	}

}
