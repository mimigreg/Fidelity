package fr.michot.fidelity.viewModel;

import java.io.Serializable;
import java.util.Date;

import fr.michot.fidelity.db.Client;

public class ListClientLineView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1239976613938063629L;
	
	private String id;
	private String name;
	private String homePhone;
	private String cellPhone;
	private String homeAddress;
	private String email;
	private Date birthDate;
	private Date membershipDate;
	
	public static ListClientLineView fromDatabaseClient(Client client) {
		return new ListClientLineView(Integer.toString(client.getId()),client.getName(),client.getHomePhone(),client.getCellPhone(),client.getHomeAddress(),client.getEmail(), client.getBirthDate(), client.getMembershipDate());
	}

	/**
	 * 
	 */
	public ListClientLineView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param homePhone
	 * @param cellPhone
	 * @param homeAddress
	 * @param email
	 * @param birthDate
	 * @param membershipDate
	 */
	public ListClientLineView(String id, String name, 
			String homePhone, String cellPhone, String homeAddress,
			String email, Date birthDate, Date membershipDate) {
		super();
		this.id = id;
		this.name = name;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.homeAddress = homeAddress;
		this.email = email;
		this.birthDate = birthDate;
		this.membershipDate = membershipDate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the membershipDate
	 */
	public Date getMembershipDate() {
		return membershipDate;
	}

	/**
	 * @param membershipDate the membershipDate to set
	 */
	public void setMembershipDate(Date membershipDate) {
		this.membershipDate = membershipDate;
	}
	
	
}
