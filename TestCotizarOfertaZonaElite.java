/* 
* @autor Mariana Alzate
* @since 2017/11/23
* Caso de prueba para validar la cotizacion de una oferta ONE_TV NAV,
* tipo paquete trio, tipo transaccion nuevo  en departamento de zona Elite
 */ 

package SuiteCotizador.SuiteCotizador;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TestCotizarOfertaZonaElite extends ClassBase {
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();


	@BeforeMethod
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



	@Test(groups="Regression")
	@Parameters({ "username", "password" })

	public void cotizaroferta() throws Exception {
		
		System.err.println("estoy en Testcotizaroferta test");

		
		CotizarOfertaZonaElite TestCotizaroferta = new CotizarOfertaZonaElite(driver);
		TestCotizaroferta.CotizarTrio(Departamento,Cuidad,Estrato,Oferta,Direccion,TO,TV,BA);

		DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("log4j.properties");

		
		String Actualtext;
		Actualtext = driver.findElement(By.xpath(".//*[@id='mensajePagoAnticipo']/li[2]")).getText();
		
		AssertJUnit.assertEquals(Actualtext,"Aplica Pago Parcial Conexión."
					);
		  System.out.print("\n assertion_method_2() -> Par t executed");
		  
		  System.out.println("Im in testCaseOne - And in Regression Group");
	}
	/*
		  @DataProvider(name = "TestData")
			public Object[][] pasarDatos() {
			 
			  TestData Excel = new TestData("C:\\Users\\user\\workspace\\TestData\\TestData.xls");
			  System.err.println("entro al archivo");
			  int fila = Excel.obtenerCantFilas();
			  
				Object[][] datos = new Object[fila-1][3];
				System.out.println("Numero de filas: " + fila);
				for (int i = 1; i < fila; i++) {
					for (int j = 0; j < 3; j++) {
						datos[i-1][j] = Excel.obtenerDatos(i, j);
						System.err.println (i);
						System.err.println (j);
					}
				}
				

				return datos;
			}
		  */
		  				
	@AfterMethod
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		
		System.err.println("estoy en TestAgendarCita after");
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			AssertJUnit.fail(verificationErrorString);
		}
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
}
