package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.service.CadastroEmpresaService;
import com.algaworks.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresa;
	
	private TipoEmpresa tipoEmpresa;
	
	private Empresa empresaEdicao = new Empresa();	

	private List<Empresa> todasEmpresas;
	
	@Inject
	private FacesMessages messages;
	
	public void prepararNovoCadastro(){
		this.empresaEdicao = new Empresa(); 
	}
	
	public void salvar() {
		this.cadastroEmpresa.salvar(empresaEdicao);
		this.consultar();
		messages.info("Empresa salva com sucesso");
	}
	
	public void consultar() {
		todasEmpresas = empresas.todas();
	}

	public List<Empresa> getTodasEmpresas() {
		return todasEmpresas;
	}
	
	public TipoEmpresa[] getTipoEmpresa() {
		return TipoEmpresa.values();
	}
	
	public Empresa getEmpresaEdicao() {
		return empresaEdicao;
	}

	public void setEmpresaEdicao(Empresa empresaEdicao) {
		this.empresaEdicao = empresaEdicao;
	}
}