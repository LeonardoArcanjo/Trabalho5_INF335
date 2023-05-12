package br.unicamp.ic.inf335.app.myProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.app.myProject.ProdutoBean;

class ProdutoBeanTest {
	
	private static ArrayList<ProdutoBean> productList = new ArrayList<ProdutoBean>();
	private static ProdutoBean product = new ProdutoBean();
	
	@BeforeAll
	static void setupBeforeAllTests() {
		ProdutoBean product = new ProdutoBean("COD-1", "Televisao", "Tv Samsung 43 pol",
				3000.0, "Novo");
		productList.add(product);
		
		product = new ProdutoBean("COD-2", "Notebook", "Notebook Dell 14 pol",
				7500.0, "Novo");
		productList.add(product);
		
		product = new ProdutoBean("COD-3", "Smartphone", "iPhone 14 Pro Max",
				7500.0, "Novo");
		productList.add(product);
	}
	
	@Test
	@DisplayName("Testa o construtor que contem metodo super")
	void ProductInstanceTest() {
		ProdutoBean product = new ProdutoBean("COD-1", "Televisao", "Tv Samsung 43 pol",
				3000.0, "Novo");
		
		assertAll("product", 
				() -> assertEquals("COD-1", product.getCodigo()),
				() -> assertEquals("Televisao", product.getNome()),
				() -> assertEquals("Tv Samsung 43 pol", product.getDescricao()),
				() -> assertEquals(3000, product.getValor()),
				() -> assertEquals("Novo", product.getEstado())
				);
	}
	
	@Test
	@DisplayName("Testa o construtor com parametros vazios")
	void ProductInstanceNoAttributesTest() {
		ProdutoBean product = new ProdutoBean();
		
		assertNotNull(product);
		
		assertAll("product", 
				() -> assertEquals("", product.getCodigo()),
				() -> assertEquals("", product.getNome()),
				() -> assertEquals("", product.getDescricao()),
				() -> assertEquals(0.0, product.getValor()),
				() -> assertEquals("", product.getEstado())
				);
	}
	
	@Test
	@DisplayName("Testa o Serial Version UID")
	void SerialVersionGetTest() {
		ProdutoBean product = new ProdutoBean();
		
		long serialVersion = product.getSerialversionuid(); 
		
		assertEquals(1, serialVersion);
	}
	
	@Test
	@DisplayName("Testa o metodo CompareTo")
	void CompareToMethodTest() {
		
		ProdutoBean prod_1 = productList.get(1);
		ProdutoBean prod_0 = productList.get(0);
		
		assertEquals(1, prod_1.compareTo(prod_0));
	}
	
	@Test
	@DisplayName("Testa o metodo CompareTo para um valor menor")
	void CompareToMethodValorMinorTest() {
		
		ProdutoBean prod_1 = productList.get(1);
		ProdutoBean prod_0 = productList.get(0);
		
		assertEquals(-1, prod_0.compareTo(prod_1));
	}
	
	@Test
	@DisplayName("Testa o metodo CompareTo para valores iguais")
	void CompareToMethodValorEqualTest() {
		
		ProdutoBean prod_1 = productList.get(1);
		ProdutoBean prod_2 = productList.get(2);
		
		assertEquals(0, prod_2.compareTo(prod_1));
	}
	
	@Test
	@DisplayName("Testa setter do atributo codigo")
	void CodigoSetterTest() {
		product.setCodigo("COD-123");
		
		assertEquals("COD-123", product.getCodigo());
	}
	
	@Test
	@DisplayName("Testa setter do atributo Nome")
	void NomeSetterTest() {
		product.setNome("Camisa de Futebol");
		
		assertEquals("Camisa de Futebol", product.getNome());
	}
	
	
	@Test
	@DisplayName("Testa o restantes dos setters")
	void AllSetterTest() {
		product.setDescricao("Camisa do SPFC");
		product.setValor(249.99);
		product.setEstado("Bom");
		
		assertAll("product", 
				() -> assertEquals("Camisa do SPFC", product.getDescricao()),
				() -> assertEquals(249.99, product.getValor()),
				() -> assertEquals("Bom", product.getEstado())
				);
	}
	
}
