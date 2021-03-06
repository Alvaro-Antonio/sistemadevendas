package com.udemy.models;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
	}
	
	
	public PagamentoComCartao(Integer id, Integer estadoPagamento, Pedido pedido,Integer parcelas) {
		super(id, estadoPagamento, pedido);
		this.numeroDeParcelas = parcelas;
	}


	public PagamentoComCartao(Integer numeroDeParcelas) {
		super();
		this.numeroDeParcelas = numeroDeParcelas;
	}
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}
	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	

}
