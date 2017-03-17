package daos;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Finder;

import models.Usuario;

public class UsuarioDAO {

	private Finder<Long, Usuario> usuarios = new Finder<>(Usuario.class);
	
	public Optional<Usuario> comEmail(String email){
	
		Usuario usuario = usuarios.query().where().eq("email", email).findUnique();
		return Optional.ofNullable(usuario);
	}

	public List<Usuario> todos() {
		return usuarios.all();
	}

	public List<Usuario> doEmail(String email) {
		return usuarios.query().where().eq("email", email).findList();
	}

	public List<Usuario> comFiltro(Map<String, String> parametros) {
		ExpressionList<Usuario> consulta = usuarios.query().where();
		parametros.entrySet().forEach(entrada -> {
			consulta.eq(entrada.getKey(), entrada.getValue());
		});
		return consulta.findList();
		
		
		
	}
}
