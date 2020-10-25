package customer.customer.model;

public class AdressModel {

	private String state;
	private String city;
	private String neighborhood;
	private String zipCode;
	private String street;
	private Integer number;
	private String additionalInformation;
	private Integer idcustomer;
	private boolean main;

	public AdressModel(String state, String city, String neighborhood, String zipCode, String street, Integer number,
			String additionalInformation, Integer idcustomer) {
		super();
		this.state = state;
		this.city = city;
		this.neighborhood = neighborhood;
		this.zipCode = zipCode;
		this.street = street;
		this.number = number;
		this.additionalInformation = additionalInformation;
		this.idcustomer = idcustomer;
		
	}
	
	
	

	public AdressModel(String state, String city, String neighborhood, String zipCode,
			String street, Integer number,String additionalInformation,
			Integer idcustomer, boolean main) {
		super();
		this.state = state;
		this.city = city;
		this.neighborhood = neighborhood;
		this.zipCode = zipCode;
		this.street = street;
		this.number = number;
		this.additionalInformation = additionalInformation;
		this.idcustomer = idcustomer;
		this.main = main;
	}




	public AdressModel() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public Integer getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	
}
