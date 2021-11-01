package com.maxxi.maxxi.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;


	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	private String nama;
	private String code;
	private String alamat;
	private String no_ktp;
	private String no_telp;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String password, String nama, String code, String alamat, String no_ktp, String no_telp) {
		this.username = username;
		this.password = password;
		this.nama = nama;
		this.code = code;
		this.alamat = alamat;
		this.no_ktp = no_ktp;
		this.no_telp = no_telp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNo_ktp() {
		return no_ktp;
	}

	public void setNo_ktp(String no_ktp) {
		this.no_ktp = no_ktp;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
