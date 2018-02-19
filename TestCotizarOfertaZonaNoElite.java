/* 
* @autor Mariana Alzate
* @since 2017/11/23
* Caso de prueba que valida la cotizacion de una oferta ONE_TV NAV,
* tipo paquete trio, tipo transaccion nuevo  en departamento diferente a zona elite.
 */ 


package SuiteCotizador.SuiteCotizador;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TestCotizarOfertaZonaNoElite<Departamento> extends ClassBase {
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		
		try {
			
			System.err.println("estoy en Test beforeclass");
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			driver.get(baseUrl);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			
		} catch (Exception e) {
			System.err.println("catch TEst");
			e.printStackTrace();
			}
	}



	@Test(dataProvider = "TestData")	//@Parameters({ "username", "password" })

	public void cotizaroferta(String Estrato) throws Exception {
		
		System.err.println("estoy en Testcotizaroferta test");

		

		CotizarOfertaZonaNoElite TestCotizaroferta = new CotizarOfertaZonaNoElite(driver);
		TestCotizaroferta.CotizarTrio(Departamento, Cuidad, Estrato, Oferta, TO, TV, BA);
		
		DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("log4j.properties");

		
		String Actualtext;
		Actualtext = driver.findElement(By.xpath(".//*[@id='mensajePagoAnticipo']/li[1]")).getText();
		
		AssertJUnit.assertEquals(Actualtext,"No aplica Pago Anticipo Cargo Fijo porque la ciudad consultada no pertenece a Elite."
					);
		  System.out.print("\n assertion_method_2() -> Par t executed");
		  
		  System.out.println("Im in testCaseOne - And in Regression Group");
	}
	
		  @DataProvider(name = "TestData")
			public Object[][] pasarDatos() {
			  
			 
			  TestData Excel = new TestData("C:\\Users\\lalzates\\workspace\\SuiteCotizador\\TestData.xls");
			  System.err.println("entro al archivo");
			  int fila = Excel.obtenerCantFilas();
			  
				Object[][] datos = new Object[fila-1][1];
				System.out.println("Numero de filas: " + fila);
				for (int i = 1; i < fila; i++) {
					for (int j = 0; j < 1; j++) {
						datos[i-1][j] = Excel.obtenerDatos(i, j);
						System.err.println (i);
						System.err.println (j);
					}
				}
				

				return datos;
			}
		  
		  				
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		
		System.err.println("estoy en TestAgendarCita after");
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
}
