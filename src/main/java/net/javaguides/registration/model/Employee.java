package net.javaguides.registration.model;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String contact;
	private int id;

	public Employee() {
		
	}
	public Employee(String firstName, String lastName, String username, String password, String address,
			String contact) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}

	public Employee(int id,String firstName, String lastName, String username, String password, String address, String contact
			) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contact = contact;
		
	}



	/*
	 * public Employee(int id, String firstname2, String lastname2, String
	 * username2, String password2, String address2, String contact2) { this.id=id;
	 * this.firstName=firstname2; this.lastName = lastname2; this.username =
	 * username2; this.password = password2; this.address = address2; this.contact =
	 * contact2; }
	 */
	public String getFirstName() {
		return firstName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
