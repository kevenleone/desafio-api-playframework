package models;

import java.util.List;

public class Envelope {
	
	private List<Usuario> usuarios;
	
	public Envelope(List<Usuario> usuarios){
		this.usuarios = usuarios;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}

}
