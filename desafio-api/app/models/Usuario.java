package models;

import java.util.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.avaje.ebean.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.Required;
import play.data.format.*;
import play.data.validation.*;
@Entity
public class Usuario extends Model {
	
	
	@Id
	@GeneratedValue

	public static Finder<Integer, Usuario> find = new Finder<Integer, Usuario>(Integer.class, Usuario.class);
	


    @Id
	private Long id;
	
	@Required(message = "Campo nome é obrigatório")
	private String nome;
	@Required(message = "O Email é obrigatório")
	private String email;
	@Required(message = "Campo senha é obrigatório")
	private String senha;
	private String telefone;
	//@Formats.DateTime(pattern="dd/MM/yyyy - hh-mm-ss")
	private Date criado;
	
	private Date modificado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCriado() {
		return criado;
	}
	public void setCriado(Date criado) {
		this.criado =  criado;
	}
	public Date getModificado() {
		return modificado;
	}
	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	
	
	
	
	
}
