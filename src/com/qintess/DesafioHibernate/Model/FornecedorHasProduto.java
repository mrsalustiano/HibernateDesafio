package com.qintess.DesafioHibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor_has_produto")
public class FornecedorHasProduto implements InterfaceModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne
	@JoinColumn(name = "Fornecedor_id")
	Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "Produtor_id")
	Produto produto;
	
	private int estoque;
	
	@Column(length = 10, precision = 2)
	private double preco_custo;

	public FornecedorHasProduto() {

	}

	public FornecedorHasProduto(Fornecedor fornecedor, Produto produto, int estoque, double preco_custo) {
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.estoque = estoque;
		this.preco_custo = preco_custo;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}

	@Override
	public String toString() {
		return "FornecedorHasProduto [Id=" + Id + ", fornecedor=" + fornecedor + ", produto=" + produto + ", estoque="
				+ estoque + ", preco_custo=" + preco_custo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + estoque;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco_custo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorHasProduto other = (FornecedorHasProduto) obj;
		if (Id != other.Id)
			return false;
		if (estoque != other.estoque)
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (Double.doubleToLongBits(preco_custo) != Double.doubleToLongBits(other.preco_custo))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
	
	
	

}
