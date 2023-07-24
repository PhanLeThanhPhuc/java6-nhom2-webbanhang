package thanhphuc.java6.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username")
	String username;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "fullname")
	String fullname;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "id_google")
	String id_google;
	
	@Column(name = "id_facebook")
	String id_facebook;
	
	@OneToMany(mappedBy = "account")
	List<Authorities> authorities;

	
	@OneToMany(mappedBy = "account")
	List<Order> orders;	
}
