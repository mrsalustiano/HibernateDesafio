package com.qintess.DesafioHibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venda_itens")
public class VendaItens implements InterfaceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Venda venda;

	@OneToOne
	private Produto produto;

	@Column(name = "quantidade", nullable = false)
	private int quantidade;

	@Column(name = "preco_custo", nullable = false, precision = 2, length = 10)
	private double precoCusto;

	@Column(name = "preco_unit", nullable = false, precision = 2, length = 10)
	private double precoUnitario;

	public VendaItens() {
	}

	public VendaItens(Venda venda, Produto produto, int quantidade, double precoCusto, double precoUnitario) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoUnitario = precoUnitario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	@Override
	public String toString() {
		return "VendaItens [id=" + id + ", venda=" + venda + ", produto=" + produto + ", quantidade=" + quantidade
				+ ", precoCusto=" + precoCusto + ", precoUnitario=" + precoUnitario + "]";
	}

	
}
