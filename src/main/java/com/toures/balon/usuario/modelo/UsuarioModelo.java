package com.toures.balon.usuario.modelo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class UsuarioModelo {

	private String id;
	private TipoDocumentoModelo tipoDocumento;
	private String documento;
	private String correo;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private List<RolModelo> roles;
	private TipoUsuarioModelo tipoUsuario;
}
