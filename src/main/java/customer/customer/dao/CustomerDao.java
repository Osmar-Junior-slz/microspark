package customer.customer.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import com.google.inject.Inject;

import customer.customer.bancodados.Conexao;
import customer.customer.model.CustomerModel;

public class CustomerDao {

	@Inject
	Conexao conexao;

	@Transaction
	public void inserirCustomer(CustomerModel customer) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Handle handle = Conexao.conectar().open();
			handle.createUpdate("insert into public.customer (nome,email,birthdate,cpf,gender)"
					+ " values(:nome,:email,:birthdate,:cpf,:gender)")
			.bind("nome", customer.getName())
			.bind("email", customer.getEmail())
			.bind("birthdate", sdf.parse(customer.getBirthDate()))
			.bind("cpf", customer.getCpf())
			.bind("gender", customer.getGender())

					.execute();
			handle.close();

	}

	@Transaction
	public void atualizarCustomer(CustomerModel customer) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Handle handle = Conexao.conectar().open();
		handle.createUpdate("update public.customer set nome=:nome,email=:email,"
				+ "birthdate=:birthdate,cpf=:cpf,gender=:gender where id_customer=:id_customer")
				.bind("nome", customer.getName()).bind("email", customer.getEmail())
				.bind("birthdate", sdf.parse(customer.getBirthDate())).bind("cpf", customer.getCpf())
				.bind("gender", customer.getGender()).bind("id_customer", customer.getId()).execute();
		handle.close();
	}

	@Transaction
	public List<CustomerModel> listartodos() throws Exception {

		Handle handle = Conexao.conectar().open();
		List<CustomerModel> listcustomer = handle.createQuery("SELECT * FROM public.customer")
				.map((rs, ctx) -> new CustomerModel(rs.getInt("id_customer"), rs.getString("nome"),
						rs.getString("email"), rs.getString("birthdate"), rs.getString("cpf"), rs.getString("gender")

				)).list();
		handle.close();
		return listcustomer;

	}

	@Transaction
	public List<CustomerModel> listarPorID(int id) throws Exception {
		Handle handle = Conexao.conectar().open();
		List<CustomerModel> listcustomer = handle
				.createQuery("SELECT * FROM public.customer where id_customer=:id_customer").bind("id_customer", id)
				.map((rs, ctx) -> new CustomerModel(rs.getInt("id_customer"), rs.getString("nome"),
						rs.getString("email"), rs.getString("birthdate"), rs.getString("cpf"), rs.getString("gender")

				)).list();
		handle.close();
		return listcustomer;

	}
	
	@Transaction
	public int listarPorNome(String nome) throws Exception {
		Handle handle = Conexao.conectar().open();
		Optional<CustomerModel> customer = handle
				.createQuery("SELECT * FROM public.customer where nome=:nome").bind("nome", nome)
				.map((rs, ctx) -> new CustomerModel(rs.getInt("id_customer"), rs.getString("nome"),
						rs.getString("email"), rs.getString("birthdate"), rs.getString("cpf"), rs.getString("gender")

				)).findOne();
		handle.close();
		return customer.get().getId();

	}
	
	
	

	@Transaction
	public void deletarCustomer(int id) throws Exception {
		Handle handle = Conexao.conectar().open();
		handle.createUpdate("delete from public.customer where id_customer=:id_customer").bind("id_customer", id)
				.execute();
		handle.close();
	}
}
