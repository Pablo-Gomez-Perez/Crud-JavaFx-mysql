package org.project.app.Practica_03;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;

import java.net.URL;
import java.util.PropertyPermission;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.project.app.controller.ClienteController;
import org.project.app.model.Cliente;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

public class PrimaryController implements Initializable{
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
	private TextField txfTelefonoCliente;
	@FXML
	private TableView<Cliente> tblDatosClientes;
	@FXML
	private TableColumn<Cliente, String> colCodigo;
	@FXML
	private TableColumn<Cliente, String> colNombre;
	@FXML
	private TableColumn<Cliente, String> colApellido;
	@FXML
	private TableColumn<Cliente, String> colEmail;
	private ClienteController clienteController = new ClienteController();
	
	

	// Event Listener on Button[#btnGuardarCliente].onAction
	@FXML
	public void insertarNuevoCliente(ActionEvent event) {			
		
		if(this.validarCamposNull()) {
			JOptionPane.showMessageDialog(null, "No deje campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Cliente cliente = new Cliente();
		
		cliente.setCodigo(this.txfCodigoCliente.getText());
		cliente.setNombre(this.txfNombreCliente.getText());
		cliente.setApellido(this.txfApellidoCliente.getText());
		cliente.setEmail(this.txfEmailCliente.getText());
		cliente.setTelefono(this.txfTelefonoCliente.getText());
		
		clienteController.insertNewCliente(cliente);
		
		System.out.println(cliente.toString());
	}
	
	private boolean validarCamposNull() {
		
		if(this.txfCodigoCliente.getText().isEmpty() || this.txfCodigoCliente.getText().length() < 1) {
			return true;
		}
		
		if(this.txfNombreCliente.getText().isEmpty() || this.txfNombreCliente.getText().length() < 1) {
			return true;
		}
		
		if(this.txfApellidoCliente.getText().isEmpty() || this.txfApellidoCliente.getText().length() < 1) {
			return true;
		}
		
		if(this.txfEmailCliente.getText().isEmpty() || this.txfEmailCliente.getText().length() < 1) {
			return true;
		}
		
		if(this.txfTelefonoCliente.getText().isEmpty() || this.txfTelefonoCliente.getText().length() < 1) {
			return true;
		}
		
		return false;
	}
	
	private void llenarTablaClientes() {
		this.tblDatosClientes.setItems(clienteController.listaPersonas());
		this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.llenarTablaClientes();
		
	}
}
