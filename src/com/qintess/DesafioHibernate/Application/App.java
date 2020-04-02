package com.qintess.DesafioHibernate.Application;

import java.util.Date;

import com.qintess.DesafioHibernate.DAO.GenericDAO;
import com.qintess.DesafioHibernate.Model.Fornecedor;
import com.qintess.DesafioHibernate.Model.FornecedorHasProduto;
import com.qintess.DesafioHibernate.Model.Produto;
import com.qintess.DesafioHibernate.Model.Venda;
import com.qintess.DesafioHibernate.Model.VendaItens;

public class App {
	private static int estoqueAtual = 0;

	public static void main(String[] args) throws Exception {

		System.out.println("Testando Criacao Tables");

		// PRODUTO 1
		Produto produto1 = new Produto();
		GenericDAO<Produto> daoProduto1 = new GenericDAO<Produto>();

		produto1.setNome("PS4");
		produto1.setMin_estoque(10);
		produto1.setFoto("foto");
		produto1.setPreco_venda(2500.00);
		daoProduto1.salvar(produto1);
		System.out.println(produto1);

		// PRODUTO 2
		Produto produto2 = new Produto();
		GenericDAO<Produto> daoProduto2 = new GenericDAO<Produto>();

		produto2.setNome("PS5");
		produto2.setMin_estoque(10);
		produto2.setFoto("foto");
		produto2.setPreco_venda(5500.00);
		daoProduto2.salvar(produto2);
		System.out.println(produto2);

		// PRODUTO 3
		Produto produto3 = new Produto();
		GenericDAO<Produto> daoProduto3 = new GenericDAO<Produto>();

		produto3.setNome("MI 9TPRO");
		produto3.setMin_estoque(10);
		produto3.setFoto("foto");
		produto3.setPreco_venda(2500.00);
		daoProduto3.salvar(produto3);
		System.out.println(produto3);

		System.out.println("Produtos inseridos");

		// Fornecedor1
		Fornecedor fornecedor1 = new Fornecedor();
		GenericDAO<Fornecedor> daoFornecedor1 = new GenericDAO<Fornecedor>();

		fornecedor1.setNome("FNAC");
		fornecedor1.setTelefone("11 2222-3333");
		fornecedor1.setContato("Vendas ");
		daoFornecedor1.salvar(fornecedor1);
		System.out.println(fornecedor1);
		// Fornecedor2

		Fornecedor fornecedor2 = new Fornecedor();
		GenericDAO<Fornecedor> daoFornecedor2 = new GenericDAO<Fornecedor>();

		fornecedor2.setNome("KABOOM");
		fornecedor2.setTelefone("11 4444-5555");
		fornecedor2.setContato("Vendas ONLINE");
		daoFornecedor2.salvar(fornecedor2);
		System.out.println(fornecedor2);
		// Venda
		System.out.println("Inserindo Vendas");
		Venda venda1 = new Venda();
		GenericDAO<Venda> daoVenda1 = new GenericDAO<Venda>();

		venda1.setCliente_id(1);
		venda1.setData_pagamento(new Date());
		venda1.setDesconto(0);
		venda1.setForma_de_pagamento(1);
		daoVenda1.salvar(venda1);
		System.out.println(venda1);
		// fornecedor 1 - produto1 x fornecedor 1
		FornecedorHasProduto fornecedorHasProduto1 = new FornecedorHasProduto();
		GenericDAO<FornecedorHasProduto> daoFornecedorHasProduto1 = new GenericDAO<FornecedorHasProduto>();

		fornecedorHasProduto1.setEstoque(100);
		fornecedorHasProduto1.setPreco_custo(2000);
		fornecedorHasProduto1.setFornecedor(fornecedor1);
		fornecedorHasProduto1.setProduto(produto1);
		daoFornecedorHasProduto1.salvar(fornecedorHasProduto1);
		System.out.println(fornecedorHasProduto1);

		// fornecedor 2 - produto2 x fornecedor 1
		FornecedorHasProduto fornecedorHasProduto2 = new FornecedorHasProduto();
		GenericDAO<FornecedorHasProduto> daoFornecedorHasProduto2 = new GenericDAO<FornecedorHasProduto>();

		fornecedorHasProduto2.setEstoque(50);
		fornecedorHasProduto2.setPreco_custo(5000);
		fornecedorHasProduto2.setFornecedor(fornecedor1);
		fornecedorHasProduto2.setProduto(produto2);
		daoFornecedorHasProduto2.salvar(fornecedorHasProduto2);
		System.out.println(fornecedorHasProduto2);

		// fornecedor 3 - produto3 x fornecedor 2
		FornecedorHasProduto fornecedorHasProduto3 = new FornecedorHasProduto();
		GenericDAO<FornecedorHasProduto> daoFornecedorHasProduto3 = new GenericDAO<FornecedorHasProduto>();

		fornecedorHasProduto3.setEstoque(500);
		fornecedorHasProduto3.setPreco_custo(1500);
		fornecedorHasProduto3.setFornecedor(fornecedor2);
		fornecedorHasProduto3.setProduto(produto3);
		daoFornecedorHasProduto3.salvar(fornecedorHasProduto3);
		System.out.println(fornecedorHasProduto3);

		// item da venda

		VendaItens vendaItens1 = new VendaItens();
		GenericDAO<VendaItens> daoVendaItens1 = new GenericDAO<VendaItens>();

		vendaItens1.setQuantidade(5);
		vendaItens1.setVenda(venda1);
		vendaItens1.setProduto(produto1);
		vendaItens1.setPrecoUnitario(3000);
		vendaItens1.setPrecoCusto(fornecedorHasProduto1.getPreco_custo());
		estoqueAtual = fornecedorHasProduto1.getEstoque();

		try {

			if (estoqueAtual < vendaItens1.getQuantidade()) {
				
				System.out.println("Item não inserido na venda, Selecione uma quantidade menor\n"
						+ "Saldo do Produto é " + fornecedorHasProduto1.getEstoque());
				throw new Exception("Saldo insuficiente para Este produto");
				
			} else {
				daoVendaItens1.salvar(vendaItens1);
				fornecedorHasProduto1.setEstoque(estoqueAtual - vendaItens1.getQuantidade());
				daoFornecedorHasProduto1.salvar(fornecedorHasProduto1);
				estoqueAtual = 0;
				System.out.println(vendaItens1);
				System.out.println(fornecedorHasProduto1);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		//fim item 1
		VendaItens vendaItens2 = new VendaItens();
		GenericDAO<VendaItens> daoVendaItens2 = new GenericDAO<VendaItens>();

		vendaItens2.setQuantidade(50);
		vendaItens2.setVenda(venda1);
		vendaItens2.setProduto(produto2);
		vendaItens2.setPrecoUnitario(7000);
		vendaItens2.setPrecoCusto(fornecedorHasProduto2.getPreco_custo());
		estoqueAtual = fornecedorHasProduto2.getEstoque();

		try {

			if (estoqueAtual < vendaItens2.getQuantidade()) {
				
				System.out.println("Item não inserido na venda, Selecione uma quantidade menor\n"
						+ "Saldo do Produto é " + fornecedorHasProduto2.getEstoque());
				throw new Exception("Saldo insuficiente para Este produto");
				
			} else {
				daoVendaItens2.salvar(vendaItens2);
				fornecedorHasProduto2.setEstoque(estoqueAtual - vendaItens2.getQuantidade());
				daoFornecedorHasProduto2.salvar(fornecedorHasProduto2);
				estoqueAtual = 0;
				System.out.println(vendaItens2);
				System.out.println(fornecedorHasProduto2);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		//fim item 2
		
		VendaItens vendaItens3 = new VendaItens();
		GenericDAO<VendaItens> daoVendaItens3 = new GenericDAO<VendaItens>();

		vendaItens3.setQuantidade(25);
		vendaItens3.setVenda(venda1);
		vendaItens3.setProduto(produto3);
		vendaItens3.setPrecoUnitario(3500);
		vendaItens3.setPrecoCusto(fornecedorHasProduto3.getPreco_custo());
		estoqueAtual = fornecedorHasProduto3.getEstoque();

		try {

			if (estoqueAtual < vendaItens3.getQuantidade()) {
				
				System.out.println("Item não inserido na venda, Selecione uma quantidade menor\n"
						+ "Saldo do Produto é " + fornecedorHasProduto3.getEstoque());
				throw new Exception("Saldo insuficiente para Este produto");
				
			} else {
				daoVendaItens3.salvar(vendaItens3);
				fornecedorHasProduto3.setEstoque(estoqueAtual - vendaItens3.getQuantidade());
				daoFornecedorHasProduto3.salvar(fornecedorHasProduto3);
				estoqueAtual = 0;
				System.out.println(vendaItens3);
				System.out.println(fornecedorHasProduto3);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		// mostra a venda
			
		System.out.println(venda1);


	}

	

	
}
