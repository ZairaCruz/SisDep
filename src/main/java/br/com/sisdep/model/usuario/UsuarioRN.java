package br.com.sisdep.model.usuario;

import java.util.List;

public class UsuarioRN {

	private Usuario usuario = new Usuario();
	
	public String irPara(Usuario usuario) {
		String irPara = "login_erro";
		Usuario usuarioConsultado = new UsuarioDAO().selectLoginAndSenha(usuario);
		if (usuarioConsultado != null) {
			if (usuarioConsultado.getTipo().equals("administrador")) {
				irPara = "login_administrador";
			} else {
				irPara = "menu";
			}
		}
		return irPara;
	}
	public void salvar(Usuario usuario) {
		if (usuario.getId() == null) {
			new UsuarioDAO().insertUsuario(usuario);
		} else {
			new UsuarioDAO().updateUsuario(usuario);
		}
	}
	
	public void apagar(Usuario usuario) {
		new UsuarioDAO().deleteUsuario(usuario);
	}
	public List<Usuario> listarTodos() {
		return new UsuarioDAO().selectAll();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
