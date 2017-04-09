package br.com.sisdep.model.patrimonio;

import java.util.Date;

public class Patrimonio {

	private Long id;
	private String nome;
	private Date dataAquisicao;
	private Date dataAtual;
	private Integer periodo;
	private String categoria;
	private Float vidaUtil;
	private String bemUsado;
	private Float tempoDeUso;
	private Float turnos;
	private Float taxaResidual;
	///////utilizados para calculos
	private Float restanteVidaUtil;
	private Float metadeVidaUtil;
	private Float vidaAdmissivel;
	private Float taxaDepreciacao;
	private Float valorAquisicao;
	private Float valorResidual;
	private Float valorDepreciado;
	private Float valorContabil;
	///////utilizados par baixa
	private Date dataBaixa;
	private Float valorBaixa;
	private Long idBaixa;
	
	
	
	////////getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	public Date getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getVidaUtil() {
		return vidaUtil;
	}
	public void setVidaUtil(Float vidaUtil) {
		this.vidaUtil = vidaUtil;
	}
	public String getBemUsado() {
		return bemUsado;
	}
	public void setBemUsado(String bemUsado) {
		this.bemUsado = bemUsado;
	}
	public Float getTempoDeUso() {
		return tempoDeUso;
	}
	public void setTempoDeUso(Float tempoDeUso) {
		this.tempoDeUso = tempoDeUso;
	}
	public Float getTurnos() {
		return turnos;
	}
	public void setTurnos(Float turnos) {
		this.turnos = turnos;
	}
	public Float getTaxaResidual() {
		return taxaResidual;
	}
	public void setTaxaResidual(Float taxaResidual) {
		this.taxaResidual = taxaResidual;
	}
	public Float getRestanteVidaUtil() {
		return restanteVidaUtil;
	}
	public void setRestanteVidaUtil(Float restanteVidaUtil) {
		this.restanteVidaUtil = restanteVidaUtil;
	}
	public Float getMetadeVidaUtil() {
		return metadeVidaUtil;
	}
	public void setMetadeVidaUtil(Float metadeVidaUtil) {
		this.metadeVidaUtil = metadeVidaUtil;
	}
	public Float getVidaAdmissivel() {
		return vidaAdmissivel;
	}
	public void setVidaAdmissivel(Float vidaAdmissivel) {
		this.vidaAdmissivel = vidaAdmissivel;
	}
	public Float getTaxaDepreciacao() {
		return taxaDepreciacao;
	}
	public void setTaxaDepreciacao(Float taxaDepreciacao) {
		this.taxaDepreciacao = taxaDepreciacao;
	}
	public Float getValorAquisicao() {
		return valorAquisicao;
	}
	public void setValorAquisicao(Float valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}
	public Float getValorResidual() {
		return valorResidual;
	}
	public void setValorResidual(Float valorResidual) {
		this.valorResidual = valorResidual;
	}
	public Float getValorDepreciado() {
		return valorDepreciado;
	}
	public void setValorDepreciado(Float valorDepreciado) {
		this.valorDepreciado = valorDepreciado;
	}
	public Float getValorContabil() {
		return valorContabil;
	}
	public void setValorContabil(Float valorContabil) {
		this.valorContabil = valorContabil;
	}
	public Date getDataBaixa() {
		return dataBaixa;
	}
	public void setDataBaixa(Date dataBaixa) {
		this.dataBaixa = dataBaixa;
	}
	public Float getValorBaixa() {
		return valorBaixa;
	}
	public void setValorBaixa(Float valorBaixa) {
		this.valorBaixa = valorBaixa;
	}
	public Long getIdBaixa() {
		return idBaixa;
	}
	public void setIdBaixa(Long idBaixa) {
		this.idBaixa = idBaixa;
	}

}
