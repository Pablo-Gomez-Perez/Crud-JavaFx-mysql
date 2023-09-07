package org.project.app.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataBaseConnect {
	
	/**
	 * bloque estatico para carga del controlador al momento de instanciar la clase
	 */
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException er) {
			er.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al cargar controlador: " + er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch(Exception er) {
			er.printStackTrace();
		}
		
	}
	
	/**
	 * establece la conexión al servidor de la base de datos que se le pase como argumento
	 * @param nombreBBDD
	 * @return
	 * @throws SQLException
	 */
	public static Connection establecerConexionLocal(String nombreBBDD) throws SQLException{
		final String url = "jdbc:mysql://localhost:3306/" + nombreBBDD;
		final String user = "root";
		return DriverManager.getConnection(url,user,"");
	}
	
	/**
	 * 
	 * @param cn
	 * @param stm
	 * @param rset
	 * @throws SQLException
	 */
	public static void cerrarConexion(Connection cn, CallableStatement stm, ResultSet rset) throws SQLException{
		if(cn != null) {
			cn.close();
		}
		
		if(stm != null) {
			stm.close();
		}
		
		if(rset != null) {
			rset.close();
		}
	}
	
	/**
	 * 
	 * @param cn
	 * @param stm
	 * @param rset
	 * @throws SQLException
	 */
	public static void cerrarConexion(Connection cn, PreparedStatement stm, ResultSet rset) throws SQLException{
		if(cn != null) {
			cn.close();
		}
		
		if(stm != null) {
			stm.close();
		}
		
		if(rset != null) {
			rset.close();
		}
	}
	
	/**
	 * 
	 * @param cn
	 * @param stm
	 * @throws SQLException
	 */
	public static void cerrarConexion(Connection cn, CallableStatement stm) throws SQLException{
		if(cn != null) {
			cn.close();
		}
		
		if(stm != null) {
			stm.close();
		}
				
	}
	
	/**
	 * 
	 * @param cn
	 * @param stm
	 * @throws SQLException
	 */
	public static void cerrarConexion(Connection cn, PreparedStatement stm) throws SQLException{
		if(cn != null) {
			cn.close();
		}
		
		if(stm != null) {
			stm.close();
		}
				
	}
	
}
