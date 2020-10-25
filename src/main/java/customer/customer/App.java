package customer.customer;

import customer.customer.controller.AdressController;
import customer.customer.controller.CustomerController;
import customer.customer.service.AdressService;
import customer.customer.service.CustomerService;

public class App {


	public static void main(String[] args) {
	
		new CustomerController(new CustomerService());
		new AdressController(new AdressService());
	}
}
