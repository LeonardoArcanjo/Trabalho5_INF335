package br.unicamp.ic.inf335.app.myProject;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.app.myProject.AnuncianteBean;
import br.unicamp.ic.inf335.app.myProject.AnuncioBean;
import br.unicamp.ic.inf335.app.myProject.ProdutoBean;

class AnuncianteBeanTest {
	
	private static ArrayList<ProdutoBean> listaProdutos = new ArrayList<ProdutoBean>();
	private static ArrayList<AnuncioBean> listaAnuncios = new ArrayList<AnuncioBean>();
	private static AnuncianteBean anunciante = new AnuncianteBean();
	
	@BeforeAll
	static void setupClassBeforeTest() {
		setupListaProdutos();
		setupListaAnuncios();
		
		anunciante.setNome("Giovana Oliveira de Lucca");
		anunciante.setCPF("123.456.789-00");
		anunciante.setAnuncios(listaAnuncios);
	}
	
	private static void setupListaAnuncios() {
		for (int i = 0; i < listaProdutos.size(); i++) {
			AnuncioBean anuncio = new AnuncioBean(listaProdutos.get(i),
					new ArrayList<URL>(), 0.0);
			listaAnuncios.add(anuncio);
		}
	}

	private static void setupListaProdutos() {
		ProdutoBean product = new ProdutoBean("COD-1", "Televisao", "Tv Samsung 43 pol",
				3000.0, "Novo");
		listaProdutos.add(product);
		
		product = new ProdutoBean("COD-2", "Notebook", "Notebook Dell 14 pol",
				7500.0, "Novo");
		listaProdutos.add(product);
		
		product = new ProdutoBean("COD-3", "Smartphone", "iPhone 14 Pro Max",
				7500.0, "Novo");
		listaProdutos.add(product);
	}
	
	@Test
	void ConstructorDefaulttest() {
		AnuncianteBean anunciante = new AnuncianteBean();
		anunciante.setNome("Giovana Oliveira de Lucca");
		anunciante.setCPF("123.456.789-00");
		anunciante.setAnuncios(new ArrayList<AnuncioBean>());
		
		assertAll("anunciante", 
				() -> assertEquals("Giovana Oliveira de Lucca", anunciante.getNome()),
				() -> assertEquals("123.456.789-00", anunciante.getCPF()),
				() -> assertEquals(new ArrayList<AnuncioBean>(), anunciante.getAnuncios())
				);
	}
	
	@Test
	void ConstructorWithParameterstest() {
		AnuncianteBean anunciante = new AnuncianteBean("Manoel Arcanjo",
				"123.456.789-00", new ArrayList<AnuncioBean>());
		
		assertAll("anunciante", 
				() -> assertEquals("Manoel Arcanjo", anunciante.getNome()),
				() -> assertEquals("123.456.789-00", anunciante.getCPF()),
				() -> assertEquals(new ArrayList<AnuncioBean>(), anunciante.getAnuncios())
				);
	}

	@Test
	void AddAnuncioTest() {
		AnuncioBean anuncio = new AnuncioBean(new ProdutoBean(),
				new ArrayList<URL>(), 0.5);
		
		anunciante.addAnuncio(anuncio);
		
		assertEquals(4, anunciante.getAnuncios().size());
	}
	
	@Test
	void RemoveAnuncioTest() {	
		anunciante.removeAnuncio(0);
		
		assertEquals(3, anunciante.getAnuncios().size());
	}
	
	@Test
	void ValorMedioAnuncioMethodTest() {
		assertEquals(4500.0, anunciante.valorMedioAnuncios());
	}
}
