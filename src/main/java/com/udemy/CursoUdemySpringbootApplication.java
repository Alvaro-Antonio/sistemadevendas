package com.udemy;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.models.Categoria;
import com.udemy.models.Cidade;
import com.udemy.models.Cliente;
import com.udemy.models.Endereco;
import com.udemy.models.Estado;
import com.udemy.models.Pagamento;
import com.udemy.models.PagamentoComBoleto;
import com.udemy.models.PagamentoComCartao;
import com.udemy.models.Pedido;
import com.udemy.models.Produto;
import com.udemy.models.enums.EstadoPagamento;
import com.udemy.models.enums.TipoCliente;
import com.udemy.repositories.CategoriaRepository;
import com.udemy.repositories.CidadeRepository;
import com.udemy.repositories.ClienteRepository;
import com.udemy.repositories.EnderecoRepository;
import com.udemy.repositories.EstadoRepository;
import com.udemy.repositories.PagamentoRepository;
import com.udemy.repositories.PedidoRepository;
import com.udemy.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUdemySpringbootApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository catRepo;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoUdemySpringbootApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Categoria c1 =  new Categoria(null,"Informática");
		Categoria c2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"mouse",80.00);
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().add(p2);
		
		p1.getCategorias().add(c1);
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().add(c1);
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		catRepo.saveAll(Arrays.asList(c1,c2));
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"Pernambuco");
		Cidade city1 = new Cidade(null,"Uberlândia",est1);
		Cidade city2 =  new Cidade (null,"Belo Jardim",est2);
		Cidade city3 = new Cidade(null,"Tacaimbó",est2);
		
		est1.getCidades().add(city1);
		est2.getCidades().addAll(Arrays.asList(city2,city3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(city1,city2,city3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@mail.com","2342353466",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("81993005001","83991400408"));
		
		Endereco end1 =  new Endereco(null, "Una do simão","77","","Zona Rural", "55370-000",cli1,city2);
		Endereco end2 =  new Endereco(null, "Residência Universitária","s/n","","Zona Rural", "5344-543",cli1,city1);
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32"), cli1,end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2019 19:35"), cli1, end2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO.getCod(),ped1,6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PEDENTE.getCod(), ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	}
}
