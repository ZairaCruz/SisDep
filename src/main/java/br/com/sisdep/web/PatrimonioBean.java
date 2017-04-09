package br.com.sisdep.web;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.sisdep.model.patrimonio.Patrimonio;
import br.com.sisdep.model.patrimonio.PatrimonioRN;

@ManagedBean(name = "viewPatrimonio")

public class PatrimonioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Patrimonio patrimonio = new Patrimonio();
	private Date d = new Date();
	
	public List<Patrimonio> getListagem() {
		return new PatrimonioRN().listarTodos();
	}
	//listarAtivos
	public List<Patrimonio> getList() {
		return new PatrimonioRN().listarAtivos();
	}
	public String actionNovo() {
		this.patrimonio = new Patrimonio();
		return "patrimonio_incluir_modificar";
	}
	public String actionVoltarMenu(){
		return "menu?faces-redirect=true";
	}
	public String actionGravar() {
		new PatrimonioRN().salvar(patrimonio);
		return "manutencao?faces-redirect=true";
	}

	public String actionCalcularDep() {
		patrimonio = new PatrimonioRN().calcular(patrimonio);
		return "patrimonio_depreciado";
	}
	
	public String actionBaixar() {
		new PatrimonioRN().inserirBaixa(patrimonio); 
		return "baixar_patrimonio";
	}
	public String actionCalcularEbaixar() {
		patrimonio = new PatrimonioRN().calcular(patrimonio);
		return "baixar";
	}
	
	public String actionIrParaBaixa() {
		patrimonio = new PatrimonioRN().calcular(patrimonio);
		return "baixar_patrimonio";
	}
	
	
	////////getters e setters

	public Patrimonio getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(Patrimonio patrimonio) {
		this.patrimonio = patrimonio;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	
	


}
