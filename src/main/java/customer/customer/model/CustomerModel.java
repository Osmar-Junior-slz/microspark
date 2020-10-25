package customer.customer.model;

import java.util.ArrayList;
import java.util.List;




public class CustomerModel {
	private Integer id;
	private String name;
	private String email;
	private String   birthDate;
	private String cpf;
	private String gender;
	private AdressModel address;
	private List<AdressModel> listadress = new ArrayList<>();
	
	
	
	

	public CustomerModel(String name, String email, String birthDate, String cpf, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.gender = gender;
		
	}

	
	
	
	public CustomerModel(Integer id, String name, String email, String birthDate, String cpf, String gender,
			List<AdressModel> listadress) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.gender = gender;
		this.listadress = listadress;
	}




	public CustomerModel(Integer id, String name, String email, String birthDate, String cpf, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.gender = gender;
	}





	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public AdressModel getAddress() {
		return address;
	}

	public void setAddress(AdressModel address) {
		this.address = address;
	}

	public List<AdressModel> getListadress() {
		return listadress;
	}

	public void setListadress(List<AdressModel> listadress) {
		this.listadress = listadress;
	}




	@Override
	public String toString() {
		return "id=" + id + ""
				+ ", nome=" + name + ""
				+ ", email=" + email + ""
				+ ", birthDate=" + birthDate + ""
				+ ", cpf="+ cpf + ""
				+ ", gender=" + gender;
	}
	
	
	

}
