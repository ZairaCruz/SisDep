package br.com.sisdep.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.sisdep.model.usuario.Usuario;
import br.com.sisdep.model.usuario.UsuarioRN;

@ManagedBean (name="viewLogin")
public class UsuarioBean implements Serializable {

private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();

	public String actionLogar(){
		return new UsuarioRN().irPara(usuario);
	}
	public String actionApagar() {
		new UsuarioRN().apagar(usuario);
		return "listagem_usuario?faces-redirect=true";
	}
	public String actionNovo() {
		this.usuario = new Usuario();
		return "formulario_usuario";
	}
	public String actionGravar() {
		new UsuarioRN().salvar(usuario);
		return "listagem_usuario?faces-redirect=true";
	}
	
	public List<Usuario> getListagem() {
		return new UsuarioRN().listarTodos();
	}
	
	////////////////////////get e set
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}