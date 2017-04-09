package br.com.sisdep.util;


import java.util.Calendar;
import java.util.Date;

import br.com.sisdep.model.patrimonio.Patrimonio;

public class Calculos {

	private Patrimonio patrimonio = new Patrimonio();
		
	public int calcularPeriodo(Patrimonio p) {
		int periodoDepreciado;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(p.getDataAquisicao().getTime()));
		Calendar calendarAtual = Calendar.getInstance();
		calendarAtual.setTime(new Date());
		int diaAquisicao = calendar.get(Calendar.DAY_OF_MONTH);
		int mesAquisicao = calendar.get(Calendar.MONTH) + 1;
		int anoAquisicao = calendar.get(Calendar.YEAR);
		int diaAtual = calendarAtual.get(Calendar.DAY_OF_MONTH);
		int mesAtual = calendarAtual.get(Calendar.MONTH) + 1;
		int anoAtual = calendarAtual.get(Calendar.YEAR);
		periodoDepreciado = (anoAtual - anoAquisicao) * 12;
		
		if (periodoDepreciado > 0) {
			mesAquisicao = 12 - mesAquisicao;
			//Se bem for adiquirido até o dia 15 do mês, inclui-se o mês da compra//
			if (diaAquisicao <= 15) {
				mesAquisicao += 1;
			}
		}
		//Se o bem for vendido até o dia 15 do mês, não conta o mês da venda//
		if (diaAtual < 15) {
			mesAtual -= 1;
		}
		if (periodoDepreciado < 12) {
			periodoDepreciado = mesAquisicao - mesAtual;
			if (periodoDepreciado < 0) {
				periodoDepreciado *= -1;
			}
		} else {
			if (periodoDepreciado == 12) {
				periodoDepreciado = mesAquisicao + mesAtual;
			} else {
				periodoDepreciado += (mesAquisicao + mesAtual) - 12;
			}
		}
		if (periodoDepreciado > p.getVidaUtil() * 12) {
			periodoDepreciado = (int) (p.getVidaUtil() * 12);
		}

		return periodoDepreciado;
	}
	
	public Patrimonio calcularDep(Patrimonio p){
		float calcTurno; 
		int periodo = this.calcularPeriodo(p);
		p.setPeriodo(periodo);
		
		p.setValorResidual((p.getValorAquisicao() * p.getTaxaResidual()) / 100);
		
		///se o bem for usado ou não
		if (p.getBemUsado() == "não"){
			p.setVidaAdmissivel(p.getVidaUtil());
		}else{
			p.setMetadeVidaUtil(p.getVidaUtil() / 2);
			p.setRestanteVidaUtil(p.getVidaUtil() - p.getTempoDeUso());
			
			if(p.getVidaUtil() < p.getTempoDeUso() || p.getMetadeVidaUtil() > p.getRestanteVidaUtil()){
				p.setVidaAdmissivel(p.getMetadeVidaUtil());
			}else{
				p.setVidaAdmissivel(p.getRestanteVidaUtil());
			}
		}	
		
		if(p.getVidaAdmissivel() <= 1 || p.getValorAquisicao() <= 326.61){
			p.setValorDepreciado((float) 0);
		}else{
			///Depreciação acelerada
			if(p.getTurnos() == 1){
				calcTurno = 1;
			}else{
				if(p.getTurnos() == 2){
					calcTurno = (float) 1.5;
				}else{
					calcTurno = 2;
				}
			}
			///taxa de depreciação 
			p.setTaxaDepreciacao((100 / p.getVidaAdmissivel()) * calcTurno);

			
			///valor depreciado no periodo
			p.setValorDepreciado(((p.getValorAquisicao() - p.getValorResidual()) * 
					(p.getTaxaDepreciacao() / 100) / 12) * periodo); //p.getPeriodo());
			}
		
		// valor contábil do bem até esse periodo
		p.setValorContabil(p.getValorAquisicao() - p.getValorDepreciado());
				
				
		///caso a depreciação ultrapasse o valor residual
		if(p.getValorDepreciado() >= (p.getValorAquisicao() - p.getValorResidual())){
			p.setValorContabil(p.getValorResidual());
			p.setValorDepreciado(p.getValorAquisicao());
		}
		
		return p;
	}

	////////getters e setters

	public Patrimonio getP() {
		return patrimonio;
	}

	public void setP(Patrimonio p) {
		this.patrimonio = p;
	}

		
}
	
	
