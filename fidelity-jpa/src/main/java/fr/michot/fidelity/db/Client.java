package fr.michot.fidelity.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1327684120381340106L;

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param name
	 * @param homePhone
	 * @param cellPhone
	 * @param homeAddress
	 * @param email
	 * @param birthDate
	 * @param membershipDate
	 */
	public Client(String name, String homePhone,
			String cellPhone, String homeAddress, String email, Date birthDate,
			Date membershipDate) {
		super();
		this.name = name;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.homeAddress = homeAddress;
		this.email = email;
		this.birthDate = birthDate;
		this.membershipDate = membershipDate;
	}

	@Id
	@GeneratedValue(generator = "client_seq")
	@SequenceGenerator(sequenceName = "client_sequence", name = "client_seq")
	private int id;
		
	@Column(name = "NAME", length = 100)
	private String name;
	
	@Column(name = "HOME_PHONE", length = 20)
	private String homePhone;
	
	@Column(name = "CELL_PHONE", length = 20)
	private String cellPhone;
	
	@Column(name = "HOME_ADDRESS", length = 1000)
	private String homeAddress;
	
	@Column(name = "EMAIL", length = 1000)
	private String email;
	
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "MEMBERSHIP_DATE")
	private Date membershipDate;
	
	@Column(name = "LAST_UPDATE", updatable= false, insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	
	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name  + ", homePhone=" + homePhone + ", cellPhone="
				+ cellPhone + ", homeAddress=" + homeAddress + ", email="
				+ email + ", birthDate=" + birthDate + ", membershipDate="
				+ membershipDate + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result
				+ ((cellPhone == null) ? 0 : cellPhone.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((homeAddress == null) ? 0 : homeAddress.hashCode());
		result = prime * result
				+ ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((membershipDate == null) ? 0 : membershipDate.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Client)) {
			return false;
		}
		Client other = (Client) obj;
		if (birthDate == null) {
			if (other.birthDate != null) {
				return false;
			}
		} else if (!birthDate.equals(other.birthDate)) {
			return false;
		}
		if (cellPhone == null) {
			if (other.cellPhone != null) {
				return false;
			}
		} else if (!cellPhone.equals(other.cellPhone)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (homeAddress == null) {
			if (other.homeAddress != null) {
				return false;
			}
		} else if (!homeAddress.equals(other.homeAddress)) {
			return false;
		}
		if (homePhone == null) {
			if (other.homePhone != null) {
				return false;
			}
		} else if (!homePhone.equals(other.homePhone)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (membershipDate == null) {
			if (other.membershipDate != null) {
				return false;
			}
		} else if (!membershipDate.equals(other.membershipDate)) {
			return false;
		}
		return true;
	}

}
