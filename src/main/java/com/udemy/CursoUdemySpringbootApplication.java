package com.udemy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.models.Categoria;
import com.udemy.models.Cidade;
import com.udemy.models.Estado;
import com.udemy.models.Produto;
import com.udemy.repositories.CategoriaRepository;
import com.udemy.repositories.CidadeRepository;
import com.udemy.repositories.EstadoRepository;
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
		
	}
}
