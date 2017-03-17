package validadores;

import javax.inject.Inject;

import daos.UsuarioDAO;
import models.Usuario;
import play.data.Form;
import play.data.validation.ValidationError;

public class Validador {

	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	public boolean temErros(Form<Usuario> formulario){
		Usuario usuario = formulario.get();
		if(usuarioDAO.comEmail(usuario.getEmail()).isPresent()){
			formulario.reject(new ValidationError("email", "O Email já está cadastrado"));
		}
		
		return formulario.hasErrors() ;
	}
	
}
