package controllers;
import javax.inject.Inject;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import daos.UsuarioDAO;
import models.Usuario;
import static play.libs.Json.toJson;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import play.libs.Json;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.ValidationError;
import play.mvc.*;
import validadores.Validador;
import views.html.*;

public class UsuarioController extends Controller {

	@Inject
	private FormFactory formularios;
	@Inject
	private Validador validador;
	
	//FUNCIONANDO (adicionar)
		public Result salvaUsuario(){
		Form<Usuario> formulario = formularios.form(Usuario.class).bindFromRequest();
		
		Usuario usuario = formulario.get();
		
		
		if(validador.temErros(formulario)){
			flash("danger", "Alguma informação no seu formulário contém erro");
			return badRequest(formularioCadastroUsuario.render(formulario));
		}
		usuario.setCriado(Calendar.getInstance().getTime());
		
		usuario.save();
		flash("success", "O Usuário "+usuario.getNome()+" foi cadastrado, criado em "+usuario.getCriado()+" Email:"+usuario.getEmail()+" modificado em "+usuario.getModificado()+" e possui o ID "+usuario.getId());
				//Redireciona para um outro controller ou o mesmo.
		return redirect(routes.UsuarioController.formularioCadastroUsuario());
	}
	
	public Result formularioCadastroUsuario(){
		Usuario usuario = new Usuario();
				
		
		Form<Usuario> formulario = formularios.form(Usuario.class).fill(usuario);
		return ok(formularioCadastroUsuario.render(formulario));
	}
	
	//FUNCIONANDO (remover)	
    public Result removerUsuario(int id){

        Usuario usuario = Usuario.find.byId(id);

        if (usuario == null){
            return notFound("ID inválido / inexistente");
        }

        usuario.delete();
        return ok("O Usuário "+usuario.getNome()+" com email "+usuario.getEmail()+" e senha "+usuario.getSenha()+" o telefone "+usuario.getTelefone()+" Criou a conta em "+
        usuario.getCriado()+" E modificou suas informações em "+usuario.getModificado()+" "+" foi Removido em"+Calendar.getInstance().getTime());
    }
	
    //FUNCIONANDO (atualizar)
    @BodyParser.Of(BodyParser.Json.class)
    public Result atualizarUsuario(int id){

        Usuario usuario = Usuario.find.byId(id);

        if (usuario == null){
            return notFound("Usuário não encontrado / existente");
        }

        JsonNode json = request().body().asJson();
        Usuario novaPessoa = Json.fromJson(json, Usuario.class);
        usuario = novaPessoa;
        
        novaPessoa.setModificado(Calendar.getInstance().getTime());
        
        usuario.update();
        
        return ok("Atualizado, dados atuais: "+usuario.getNome()+" com email "+usuario.getEmail()+" e senha "+usuario.getSenha()+" o telefone "+usuario.getTelefone()+" Criou a conta em "+
                usuario.getCriado()+" E modificou suas informações em "+usuario.getModificado());
    }

    //FUNCIONANDO (adicionar)
    @BodyParser.Of(BodyParser.Json.class)
    public Result adicionarUser(){
        JsonNode json = request().body().asJson();

        Usuario usuario = Json.fromJson(json, Usuario.class);

        if (usuario.toString().equals("")){
            return badRequest("Faltando Parâmetro");
        }

        usuario.save();
        return ok();
    }
    //FUNCIONANDO (Listar)
    public Result listarUser(){

        List<Usuario> usuarios = new Model.Finder(String.class, Usuario.class).all();

        return ok(toJson(usuarios));
    }
    //FUNCIONANDO
    public Result pegarUsuario(int id){

        Usuario usuario = Usuario.find.byId(id);

        if (usuario == null){
            return notFound("Usuário nao encontrado!");
        }

        return ok(toJson(usuario));

    }
  
    
	
	
	
	
	
}
