package org.project.app.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.project.app.model.Cliente;
import org.project.app.utils.DataBaseConnect;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteController {	
	
	private static Connection cn;
	
	public void insertNewCliente(Cliente cl){
				
		CallableStatement stm = null;
		
		try {
			
			cn = DataBaseConnect.establecerConexionLocal("ventas");			
			stm = cn.prepareCall("CALL insertar_cliente(?,?,?,?,?);");
			
			stm.setString(1, cl.getCodigo());
			stm.setString(2, cl.getNombre());
			stm.setString(3, cl.getApellido());
			stm.setString(4, cl.getEmail());
			stm.setString(5, cl.getTelefono());
			
			stm.execute();
			
		}catch(SQLException er) {
			er.printStackTrace();
		}catch(Exception er) {
			er.printStackTrace();
		}finally {
			try {
				DataBaseConnect.cerrarConexion(cn, stm);
			}catch(SQLException er) {
				er.printStackTrace();
			}
		}
	}
	
	/** 
	 * @return lista de clientes en la base de datos
	 */
	public ObservableList<Cliente> listaPersonas(){
		
		ObservableList<Cliente> clientes = FXCollections.observableArrayList();
		Cliente cliente;
		CallableStatement stm = null;
		ResultSet rset = null;
		
		try {
			
			cn = DataBaseConnect.establecerConexionLocal("ventas");
			stm = cn.prepareCall("CALL consultar_clientes();");
			rset = stm.executeQuery();
			
			while(rset.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rset.getString(2));
				cliente.setNombre(rset.getString(3));
				cliente.setApellido(rset.getString(4));
				cliente.setEmail(rset.getString(5));
				cliente.setTelefono(rset.getString(6));
				
				clientes.add(cliente);
			}
			
			return clientes;
			
		}catch(SQLException er) {
			er.printStackTrace();
		}catch(Exception er) {
			er.printStackTrace();
		}finally {
			
		}
		
		return null;
	}
}
