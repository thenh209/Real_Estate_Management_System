package com.project.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="user_details")
public class UserModel {
	
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	private String userName;
	private String password;
	private int age;
	private long mobileNumber;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private List<PropModel>pm;
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserModel(String email, int userId, String userName, String password, int age, long mobileNumber,
			List<PropModel> pm) {
		super();
		this.email = email;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.pm = pm;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<PropModel> getPm() {
		return pm;
	}

	public void setPm(List<PropModel> pm) {
		this.pm = pm;
	}
	
}
