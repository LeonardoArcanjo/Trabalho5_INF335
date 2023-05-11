package br.unicamp.ic.inf335.app.myProject;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.app.myProject.AnuncioBean;
import br.unicamp.ic.inf335.app.myProject.ProdutoBean;

class AnuncioBeanTest {

	
	
	@Test
	@DisplayName("Testa Construtor Default")
	void DefaultConstructortest() {
		AnuncioBean anuncio = new AnuncioBean();
		ProdutoBean produto = new ProdutoBean();
		
		assertAll("anuncio", 
				() -> assertEquals(produto.getClass(), anuncio.getProduto().getClass()),
				() -> assertEquals(new ArrayList<URL>(), anuncio.getFotosUrl()),
				() -> assertEquals(0.0, anuncio.getDesconto())
				);
	}
	
	
	@Test
	@DisplayName("Testa Construtor Com parametros")
	void WithParametersConstructortest() {
		ProdutoBean produto = new ProdutoBean();
		ArrayList<URL> listaFotos = new ArrayList<URL>();
		
		AnuncioBean anuncio = new AnuncioBean(produto, listaFotos, 0.2);
		
		assertAll("anuncio", 
				() -> assertEquals(produto, anuncio.getProduto()),
				() -> assertEquals(listaFotos, anuncio.getFotosUrl()),
				() -> assertEquals(0.2, anuncio.getDesconto())
				);
	}
	
	@Test
	@DisplayName("Testa os Setters da Classe")
	void AnuncioBeanSetterTest() {
		ProdutoBean produto = new ProdutoBean();
		AnuncioBean anuncio = new AnuncioBean();
		ArrayList<URL> listaFotos = new ArrayList<URL>();
		
		anuncio.setProduto(produto);
		anuncio.setFotosUrl(listaFotos);
		anuncio.setDesconto(0.2);
		
		assertAll("anuncio", 
				() -> assertEquals(produto, anuncio.getProduto()),
				() -> assertEquals(listaFotos, anuncio.getFotosUrl()),
				() -> assertEquals(0.2, anuncio.getDesconto())
				);	
	}

	@Test
	@DisplayName("Testa o Get do Serial Version da Classe")
	void SerialVersionTest() {
		AnuncioBean anuncio = new AnuncioBean();
				
		assertEquals(1, anuncio.getSerialversionuid());
	}
	
	@Test
	@DisplayName("Testa o valor com o desconto aplicado para o produto com valor 0")
	void GetValorTest() {
		ProdutoBean produto = new ProdutoBean();
		ArrayList<URL> listaFotos = new ArrayList<URL>();
		
		AnuncioBean anuncio = new AnuncioBean(produto, listaFotos, 0.2);
		
		assertEquals(0, anuncio.getValor());
	}
	
	@Test
	@DisplayName("Testa o valor com o desconto aplicado para o produto com valor 1000")
	void GetValorProdutoTest() {
		ProdutoBean produto = new ProdutoBean();
		produto.setValor(1000.0);
		ArrayList<URL> listaFotos = new ArrayList<URL>();
		
		AnuncioBean anuncio = new AnuncioBean(produto, listaFotos, 0.2);
		
		assertEquals(800, anuncio.getValor());
	}
}
