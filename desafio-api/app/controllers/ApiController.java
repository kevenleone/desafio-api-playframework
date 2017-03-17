package controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import models.Envelope;
import models.Usuario;
import daos.UsuarioDAO;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.data.validation.ValidationError;
import play.libs.Json;
import play.mvc.*;

public class ApiController extends Controller {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	private static final List<String> ATRIBUTOS = Arrays.asList("id", "nome","email","senha","telefone");
	
	@Inject
	private FormFactory formularios;
	public Result todos(){
		Envelope envelopeUsuarios = new Envelope(usuarioDAO.todos());
		
		return ok(Json.toJson(envelopeUsuarios));
	}

	
	public Result doEmail(String email){
		Envelope envelope = new Envelope(usuarioDAO.doEmail(email));
		return ok(Json.toJson(envelope));
	}
	
	public Result comFiltros(){
		DynamicForm formulario = formularios.form().bindFromRequest();
		validaFormulario(formulario);
		
		if(formulario.hasErrors()){
			JsonNode erros = Json.newObject().set("erros", formulario.errorsAsJson());
			return badRequest(erros);
		}
		 Map<String, String> parametros = formulario.data();
		List<Usuario> usuarios = usuarioDAO.comFiltro(parametros);
		Envelope envelope = new Envelope(usuarios);
		return ok(Json.toJson(envelope));
	}


	private void validaFormulario(DynamicForm formulario) {
		Map<String, String> parametros = formulario.data();
		parametros.keySet().forEach(chave ->{
			if(!ATRIBUTOS.contains(chave)){
				formulario.reject(new ValidationError("Atributo Inválido", chave));
			}
		});
		
	}
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
