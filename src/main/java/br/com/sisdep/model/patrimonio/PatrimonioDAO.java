package br.com.sisdep.model.patrimonio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sisdep.util.ConnectionFactory;

public class PatrimonioDAO extends ConnectionFactory {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public List<Patrimonio> selectBaixados(){
		List<Patrimonio> listaBaixados = null;
		String sql = "select * from patrimonio inner join baixa on patrimonio.id = "
				+ "baixa.idpatrimonio order by nome";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listaBaixados = new ArrayList<Patrimonio>();
			while (rs.next()){
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setId(rs.getLong("id"));
				patrimonio.setNome(rs.getString("nome"));
				patrimonio.setDataAquisicao(rs.getDate("dataaquisicao"));
				patrimonio.setCategoria(rs.getString("categoria"));
				patrimonio.setVidaUtil(rs.getFloat("vidautil"));
				patrimonio.setBemUsado(rs.getString("bemusado"));
				patrimonio.setValorAquisicao(rs.getFloat("valoraquisicao"));
				patrimonio.setTempoDeUso(rs.getFloat("tempodeuso"));
				patrimonio.setTaxaResidual(rs.getFloat("taxaresidual"));
				patrimonio.setTurnos(rs.getFloat("turnos"));
				patrimonio.setDataBaixa(rs.getDate("databaixa"));
				patrimonio.setValorBaixa(rs.getFloat("valorbaixa"));
				listaBaixados.add(patrimonio);
			}
		}catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps, rs);
		}
		return listaBaixados;
	}
	public List<Patrimonio> lista(){
		List<Patrimonio> listaAtivos = null;
		String sql = "select * from patrimonio where id not in "
				+ "(select idpatrimonio from baixa) "
				+ "order by id";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listaAtivos = new ArrayList<Patrimonio>();
			while (rs.next()){
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setId(rs.getLong("id"));
				patrimonio.setNome(rs.getString("nome"));
				patrimonio.setDataAquisicao(rs.getDate("dataaquisicao"));
				patrimonio.setCategoria(rs.getString("categoria"));
				patrimonio.setVidaUtil(rs.getFloat("vidautil"));
				patrimonio.setBemUsado(rs.getString("bemusado"));
				patrimonio.setValorAquisicao(rs.getFloat("valoraquisicao"));
				patrimonio.setTempoDeUso(rs.getFloat("tempodeuso"));
				patrimonio.setTaxaResidual(rs.getFloat("taxaresidual"));
				patrimonio.setTurnos(rs.getFloat("turnos"));
				listaAtivos.add(patrimonio);
			}
		}catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps, rs);
		}
		return listaAtivos;
	}
	public Patrimonio insert(Patrimonio patrimonio){
		
		String sql = "INSERT INTO patrimonio (nome, dataaquisicao, categoria, vidautil, "
				+ "bemusado, valoraquisicao, taxaresidual, turnos, tempodeuso) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, patrimonio.getNome());
			ps.setDate(2, new Date(patrimonio.getDataAquisicao()
					.getTime()));
			System.out.println(patrimonio.getDataAquisicao()
					.getTime());
			ps.setString(3, patrimonio.getCategoria());
			ps.setFloat(4, patrimonio.getVidaUtil());
			ps.setString(5, patrimonio.getBemUsado());
			ps.setFloat(6, patrimonio.getValorAquisicao());
			ps.setFloat(7, patrimonio.getTaxaResidual());
			ps.setFloat(8, patrimonio.getTurnos());
			ps.setFloat(9, patrimonio.getTempoDeUso());
			ps.executeUpdate();
			//System.out.println("feito insert");
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return patrimonio;
	}
	
	public Patrimonio insertBaixa(Patrimonio patrimonio){
		String sql = "INSERT INTO baixa (databaixa, valorbaixa, idpatrimonio) "
				+ " VALUES (?, ?, ?)";
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setDate(1, new Date(patrimonio.getDataBaixa().getTime()));
			ps.setFloat(2, patrimonio.getValorBaixa());
			ps.setLong(3, patrimonio.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return patrimonio;
	}
	
	public Patrimonio update(Patrimonio patrimonio){
		String sql = "UPDATE patrimonio SET  bemusado = ?, tempodeuso =?, nome = ?, "
				+ "dataaquisicao = ?, categoria = ?, vidautil = ?, "
				+ "valoraquisicao = ?, taxaresidual = ?, turnos = ? WHERE id = ?";
		
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, patrimonio.getBemUsado());
			ps.setFloat(2, patrimonio.getTempoDeUso());
			ps.setString(3, patrimonio.getNome());
			System.out.println(patrimonio.getNome());
			ps.setDate(4, new Date(patrimonio.getDataAquisicao()
					.getTime()));
			ps.setString(5, patrimonio.getCategoria());
			ps.setFloat(6, patrimonio.getVidaUtil());
			ps.setFloat(7, patrimonio.getValorAquisicao());
			ps.setFloat(8, patrimonio.getTaxaResidual());
			ps.setFloat(9, patrimonio.getTurnos());
			ps.setLong(10, patrimonio.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return patrimonio;
	}
	 
	public Patrimonio buscarPorCodigo(Patrimonio p){
	     String sql = "SELECT * from patrimonio WHERE id = ? ;";
	     Patrimonio objP = null;
	     try {
	    	con = openConnection();
	        ps = con.prepareStatement(sql);
	        ps.setLong(1, p.getId());
	        rs = ps.executeQuery();
	        while (rs.next()){
	        	objP = new Patrimonio();
	        	objP.setId(rs.getLong("id"));
	        	objP.setNome(rs.getString("nome"));
				objP.setDataAquisicao(rs.getDate("dataaquisicao"));
				objP.setVidaUtil(rs.getFloat("vidautil"));
				objP.setValorAquisicao(rs.getFloat("valoraquisicao"));
				objP.setTaxaResidual(rs.getFloat("taxaresidual"));
				objP.setTurnos(rs.getFloat("turnos"));
				objP.setTempoDeUso(rs.getFloat("tempodeuso"));
				objP.setBemUsado(rs.getString("bemusado"));
	        }
	    } catch (Exception e){
	    	System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	     return objP;
	}

}
