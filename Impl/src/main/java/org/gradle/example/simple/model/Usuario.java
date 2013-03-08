package org.gradle.example.simple.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -6350451104358647101L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String login;
	private String senha;
	private String nome;
	private String email;
	
	@Column(name="account_expiration_date")
	private Calendar accountExpiration;
	
	@Column(name="password_expiration_date")
	private Calendar passwordExpiration;

	@Column(name="account_locked", nullable=false)
	private boolean accountLocked;
	
	@Column(name="account_enabled", nullable=false)
	private boolean enabled;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinTable(name = "UsuarioRole", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getAccountExpiration() {
		return accountExpiration;
	}

	public void setAccountExpiration(Calendar accountExpiration) {
		this.accountExpiration = accountExpiration;
	}

	public Calendar getPasswordExpiration() {
		return passwordExpiration;
	}

	public void setPasswordExpiration(Calendar passwordExpiration) {
		this.passwordExpiration = passwordExpiration;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public boolean isAccountNonLocked() {
		return !isAccountLocked();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ID...............:").append(this.getId())
				.append("\n").append("Login............:")
				.append(this.getLogin()).append("\n")
				.append("Nome.............:").append(this.getNome())
				.append("\n").append("Senha............:")
				.append(this.getSenha()).append("\n")
				.append("Expiração Conta..:")
				.append(this.getAccountExpiration()).append("\n")
				.append("Expiração Senha..:")
				.append(this.getPasswordExpiration()).append("\n")
				.append("Conta Bloquqada..:").append(this.isAccountLocked())
				.append("\n").append("Conta Habilitada.:")
				.append(this.isEnabled()).append("\n");
		return stringBuilder.toString();
	}
}
