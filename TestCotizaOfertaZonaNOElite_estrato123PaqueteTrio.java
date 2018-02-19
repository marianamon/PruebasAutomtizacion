/* 
* @autor Mariana Alzate
* @since 2017/11/23
* Caso de prueba que valida la  cotizacion de ofertas
* en zona NO Elite en paquete TRIO y mediante la anotación 
* DataDriven crear juego de pruebas por Departamento,Cuidad, Estrato 1-2-3,Oferta y producto.
 */ 

package SuiteCotizador.SuiteCotizador;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCotizaOfertaZonaNOElite_estrato123PaqueteTrio extends ClassBase {
	
	
	private static StringBuffer verificationErrors = new StringBuffer();




@Test(dataProvider = "TestDatatrio_zonaNOelite_Est123")	//@Parameters({ "username", "password" })

public void cotizaroferta(String Departamento, String Cuidad, String Estrato, String Oferta, String TO, String TV, String BA) throws Exception {
	

	DOMConfigurator.configure("log.xml");
	PropertyConfigurator.configure("log.properties");
	
	Log . info ( "Estoy en Testcotizaroferta" ) ; 
	

	CotizarOfertaZonaNoElite TestCotizaroferta = new CotizarOfertaZonaNoElite(driver);
	TestCotizaroferta.CotizarTrio(Departamento,Cuidad,Estrato,Oferta,TO,TV,BA);
	


	//Aserciones
	String Actualtext;
	Actualtext = driver.findElement(By.xpath(".//*[@id='mensajePagoAnticipo']/li[1]")).getText();
	
	
	AssertJUnit.assertEquals(Actualtext,"No aplica Pago Anticipo Cargo Fijo porque la ciudad consultada no pertenece a Elite."
				);
	  
	Log . info ( "\n assertion_method_2() -> Par t executed" ) ; 
	
	
	// Se invoca metodo takeScreenShot de la clase TestListeners, para la captura de la evidenia
	TestListeners.takeScreenShot(driver, Departamento + "_Estrato"+Estrato, Oferta);
	 
}	
//datos dinamicos en el archivo testdata que llama la anotacion Dataprovider de testNG
	  @DataProvider(name = "TestDatatrio_zonaNOelite_Est123")
		public Object[][] pasarDatos() {
		  
		 
		  TestData Excel = new TestData("C:\\Users\\lalzates\\workspace\\proyectos\\SuiteCotizador\\TestDatatrio_zonaNOelite_Est123.xls");
		  Log . info ( "Ingreso al archivo de excel" ) ; 
		  
		  int fila = Excel.obtenerCantFilas();
		  
			Object[][] datos = new Object[fila-1][7];
			//System.out.println("Numero de filas: " + fila);
			for (int i = 1; i < fila; i++) {
				for (int j = 0; j < 7; j++) {
					datos[i-1][j] = Excel.obtenerDatos(i, j);
					
				}
			}
			

			return datos;
		}
	  

public static WebDriver getDriver() {
	// TODO Auto-generated method stub
	return null;
}
}

