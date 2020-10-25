package customer.customer.service;

import java.util.List;

import customer.customer.dao.AdressDao;
import customer.customer.dao.CustomerDao;
import customer.customer.model.AdressModel;
import customer.customer.model.CustomerModel;

public class CustomerService {

	// INSERINDO DADOS NA TABELA
	public void inserirCustomer(CustomerModel customers) throws Exception {
		CustomerDao dao = new CustomerDao();
		AdressDao adressDao = new AdressDao();
		dao.inserirCustomer(customers);
		int id = dao.listarPorNome(customers.getName());
		customers.getAddress().setIdcustomer(id);
		adressDao.inserirAdress(customers.getAddress());

	}

	// ATUALIZANDO DADOS NA TABELA
	public void atualizarCustomer(CustomerModel customers) throws Exception {
		CustomerDao dao = new CustomerDao();
		dao.atualizarCustomer(customers);
	}

	// LISTANDO TODOS OS DADOS DA TABELA
	public List<CustomerModel> listarTodos() throws Exception {
		CustomerDao dao = new CustomerDao();
		return dao.listartodos();
	}

	// LISTAR DADOS PELO ID DA TABELA
	public List<CustomerModel> listarPorID(int id) throws Exception {
		CustomerDao dao = new CustomerDao();
		AdressDao adressdao = new AdressDao();

		List<CustomerModel> listcustomer = dao.listarPorID(id);
		List<AdressModel> listadress = adressdao.listarPorID(id);
		listcustomer.get(0).getListadress().addAll(listadress);

		return listcustomer;
	}

	// DELETANDO DADOS
	public void deletarCustomer(int id) throws Exception {
		CustomerDao dao = new CustomerDao();
		dao.deletarCustomer(id);
	}

}
