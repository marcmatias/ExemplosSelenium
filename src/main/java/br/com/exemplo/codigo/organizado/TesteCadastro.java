package br.com.exemplo.codigo.organizado;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TesteCadastro {
	
	private WebDriver driver;
	private CampoTreinamentoPage page;

    @BeforeClass
    public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
    }
   
    @Before
    public void setupTest() {
    	driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
    }
    
    @After
    public void teardown() {
            driver.quit();
    }

	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Marcel");
		page.setSobrenome("Marques");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Marcel"));
		Assert.assertEquals("Sobrenome: Marques", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());
	}
}
