package com.epam.restapi.restapi;

public class EmployeeInformation {
	private Integer id;
	private String name;
	private String username;
	private String email;
	private Address address;
	private String website;
	private String phone;
	private Company company;
	
	

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Class POJO [Address=" + getAddress().getCity() + ", id=" + getId() + ", Username=" + getUsername() + ", Name="
				+ getName() + ", Phone Number=" + getPhone() + ", Email=" + getEmail() + ", Company=" + getCompany()!=null?getCompany().getName():""				
				+ ", Company=" + getCompany().getCatchPhrase()
				+ ", Company=" + getCompany().getBs()
				+ "]";
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
