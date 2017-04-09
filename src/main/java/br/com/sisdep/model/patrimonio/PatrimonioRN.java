package br.com.sisdep.model.patrimonio;


import java.util.List;

import br.com.sisdep.util.Calculos;


public class PatrimonioRN {

	private Patrimonio p = new Patrimonio();
	private Calculos calculos = new Calculos();

	public List<Patrimonio> listarTodos() {
		return new PatrimonioDAO().selectBaixados();
	}
	public List<Patrimonio> listarAtivos() {
		return new PatrimonioDAO().lista();
	}
	public void inserir(Patrimonio patrimonio){
		new PatrimonioDAO().insert(patrimonio);
	}
	public void salvar(Patrimonio patrimonio) {
		if (patrimonio.getId() == null) {
			new PatrimonioDAO().insert(patrimonio);
		} else {
			new PatrimonioDAO().update(patrimonio);
		}
	}
	public void inserirBaixa(Patrimonio patrimonio){
		new PatrimonioDAO().insertBaixa(patrimonio);
		
	}
	
	public Patrimonio buscar(Patrimonio p) {
		return new PatrimonioDAO().buscarPorCodigo(p);
	}
	public Patrimonio calcular(Patrimonio p) {
		Patrimonio objP = new PatrimonioDAO().buscarPorCodigo(p);
		Patrimonio x = new Calculos().calcularDep(objP);
		objP.setValorContabil(x.getValorContabil());
		objP.setValorResidual(x.getValorResidual());
		objP.setPeriodo(x.getPeriodo());
		return objP;
	}

	/////getters e setters
	public Patrimonio getP() {
		return p;
	}

	public void setP(Patrimonio p) {
		this.p = p;
	}

	public Calculos getCalculos() {
		return calculos;
	}

	public void setCalculos(Calculos calculos) {
		this.calculos = calculos;
	}



}
