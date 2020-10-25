package customer.customer.service;

import java.util.List;

import customer.customer.dao.AdressDao;
import customer.customer.dao.CustomerDao;
import customer.customer.model.AdressModel;
import customer.customer.model.CustomerModel;

public class AdressService {

	// INSERINDO DADOS NA TABELA
	public void inserirAdress(AdressModel adress) throws Exception {
		AdressDao dao = new AdressDao();
		dao.inserirAdress(adress);
	}

	// ATUALIZANDO DADOS NA TABELA
	public void atualizarAdress(AdressModel adress) throws Exception {
		AdressDao dao = new AdressDao();
		dao.atualizarAdress(adress);
	}

	// LISTANDO TODOS OS DADOS DA TABELA
	public List<AdressModel> listarTodos() throws Exception {
		AdressDao dao = new AdressDao();
		return dao.listartodos();
	}

	// LISTAR DADOS PELO ID DA TABELA
	public List<AdressModel> listarPorID(int id) throws Exception {
		AdressDao dao = new AdressDao();
		return dao.listarPorID(id);
	}

	// DELETANDO DADOS
	public void deletarAdress(int id) throws Exception {
		AdressDao dao = new AdressDao();
		dao.deletarAdress(id);
	}

}
