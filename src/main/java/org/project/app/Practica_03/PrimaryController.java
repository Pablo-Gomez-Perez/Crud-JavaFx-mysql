package org.project.app.Practica_03;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import org.project.app.model.Cliente;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

public class PrimaryController {
	@FXML
	private TextField txfCodigoCliente;
	@FXML
	private TextField txfNombreCliente;
	@FXML
	private TextField txfApellidoCliente;
	@FXML
	private TextField txfEmailCliente;
	@FXML
	private Button btnGuardarCliente;
	@FXML
	private TableView<Cliente> tblDatosClientes;

	// Event Listener on Button[#btnGuardarCliente].onAction
	@FXML
	public void insertarNuevoCliente(ActionEvent event) {
		
		Cliente cliente = new Cliente();
		
		cliente.setCodigo(this.txfCodigoCliente.getText());
		cliente.setNombre(this.txfNombreCliente.getText());
		cliente.setApellido(this.txfApellidoCliente.getText());
		cliente.setEmail(this.txfEmailCliente.getText());
		
		System.out.println(cliente.toString());
	}
}
