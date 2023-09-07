package org.project.app.model;

import java.sql.Date;
import java.util.Objects;

public class Cliente {
	private int idCliente;
	private String codigo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private Date fechaRegistro;
		
	
	public Cliente(int idCliente, String codigo, String nombre, String email, String telefono, Date fechaRegistro) {
		super();
		this.idCliente = idCliente;
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fechaRegistro = fechaRegistro;
	}

	public Cliente() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return this.apellido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", codigo=" + codigo + ", nombre=" + nombre + ", email=" + email
				+ ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + "]";
	}
	
	
}
