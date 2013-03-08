package br.eti.ftxavier.base.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8350234883392937780L;

	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
			.append("ID...............:").append(this.getId()).append("\n")
			.append("Nome.............:").append(this.getName()).append("\n");
		return stringBuilder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getId().equals(((Role)obj).getId());
	}
}
