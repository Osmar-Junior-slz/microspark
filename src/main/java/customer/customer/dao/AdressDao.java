package customer.customer.dao;


import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import com.google.inject.Inject;

import customer.customer.bancodados.Conexao;
import customer.customer.model.AdressModel;




public class AdressDao {
	
	@Inject
	Conexao conexao;
	
	@Transaction
	public void inserirAdress(AdressModel adress) throws Exception {

		
		Handle handle = Conexao.conectar().open();
			handle.createUpdate("insert into public.adress (state,city,neighborhood,zipcode,"
					+ "street,numero,additionalinformation,idcustomer)"
					+ " values(:state,:city,:neighborhood,:zipcode,"
					+ ":street,:numero,:additionalinformation,:idcustomer)")
			.bind("state", adress.getState())
			.bind("city", adress.getCity())
			.bind("neighborhood", adress.getNeighborhood())
			.bind("zipcode", adress.getZipCode())
			.bind("street", adress.getStreet())
			.bind("numero", adress.getNumber())
			.bind("additionalinformation", adress.getAdditionalInformation())
			.bind("idcustomer", adress.getIdcustomer())
            .execute();
			handle.close();

	}
	
	
	@Transaction
	public void atualizarAdress(AdressModel adress) throws Exception {
		
		Handle handle = Conexao.conectar().open();
		handle.createUpdate("update public.adress set state=:state,city=:city,"
				+ "neighborhood=:neighborhood,zipcode=:zipcode,street=:street,"
				+ "numero=:numero,additionalinformation=:additionalinformation"
				+ " where idcustomer=:idcustomer")
				.bind("state", adress.getState())
				.bind("city", adress.getCity())
				.bind("neighborhood", adress.getNeighborhood())
				.bind("zipcode", adress.getZipCode())
				.bind("street", adress.getStreet())
				.bind("numero", adress.getNumber())
				.bind("additionalinformation", adress.getAdditionalInformation())
				.bind("idcustomer", adress.getIdcustomer())
				.execute();
		handle.close();
	}

	@Transaction
	public List<AdressModel> listartodos() throws Exception {

		Handle handle = Conexao.conectar().open();
		List<AdressModel> listadress = handle.createQuery("SELECT * FROM public.adress")
				.map((rs, ctx) -> new AdressModel(
						rs.getString("state"), 
						rs.getString("city"),
						rs.getString("neighborhood"), 
						rs.getString("zipCode"), 
						rs.getString("street"), 
						rs.getInt("numero"),
						rs.getString("additionalInformation"),
						rs.getInt("idcustomer"),
						rs.getBoolean("main")

				)).list();
		handle.close();
		return listadress;

	}

	@Transaction
	public List<AdressModel> listarPorID(int id) throws Exception {
		Handle handle = Conexao.conectar().open();
		List<AdressModel> listadress = handle
				.createQuery("SELECT * FROM public.adress"
				+ " where idcustomer=:idcustomer").bind("idcustomer", id)
				.map((rs, ctx) -> new AdressModel(
						rs.getString("state"), 
						rs.getString("city"),
						rs.getString("neighborhood"), 
						rs.getString("zipCode"), 
						rs.getString("street"), 
						rs.getInt("numero"),
						rs.getString("additionalInformation"),
						rs.getInt("idcustomer"),
						rs.getBoolean("main")

				)).list();
		handle.close();
		return listadress;

	}

	@Transaction
	public void deletarAdress(int id) throws Exception {
		Handle handle = Conexao.conectar().open();
		handle.createUpdate("delete from public.adress where idcustomer=:idcustomer").bind("idcustomer", id)
				.execute();
		handle.close();
	}


}
