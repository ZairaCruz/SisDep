package br.com.sisdep.model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

import br.com.sisdep.util.ConnectionFactory;

public class UsuarioDAO extends ConnectionFactory{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private Usuario usuario;
	
	public Usuario selectLoginAndSenha(Usuario usuario){
		
		String sql = "SELECT id, nome, tipo FROM usuario WHERE login = ? AND senha = ?";
		Usuario user = null;
		try {
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			rs = ps.executeQuery();
			if (rs.next()){
				user = new Usuario();
				user.setId(rs.getLong("id"));
				user.setNome(rs.getString("nome"));
				user.setTipo(rs.getString("tipo"));
			}
		}catch (Exception e){
			System.err.println("Erro: ");
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, rs);
		}
		return user;
	}
	public Usuario insertUsuario(Usuario usuario){
		String sql = "INSERT INTO usuario (nome, login, senha, tipo) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getTipo());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return usuario;
	}
	
	public void updateUsuario(Usuario usuario){
		String sql = "UPDATE usuario SET  nome = ?, login =?, senha = ?, tipo = ? "
				+ "WHERE id = ?";	
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getTipo());
			ps.setLong(5, usuario.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	
	
	public void deleteUsuario(Usuario usuario){
		String sql = "DELETE FROM usuario WHERE id = ?";
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, usuario.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	public List<Usuario> selectAll(){
		List<Usuario> listagem = null;
		String sql = "SELECT id, nome, login, tipo "
				+ "FROM usuario order by nome";
		try {
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listagem = new ArrayList<Usuario>();
			while (rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setTipo(rs.getString("tipo"));
				listagem.add(usuario);
			}
		}catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps, rs);
		}
		return listagem;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
