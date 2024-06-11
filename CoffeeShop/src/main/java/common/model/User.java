package common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 3L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String password;
	public User(Integer iD, String name, String username, String password) {
		
		ID = iD;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public User(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	public User(String name, String username, String password) {
		
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
