package SuiteCotizador.SuiteCotizador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.testng.TestNG;

public class MenuAutomatización {


	public class MenuAutomatizacion {

		
		public void main(String[] args) {
			// TODO Auto-generated method stub
			
			//Crear objeto de la clase TestNG
			TestNG runner = new TestNG();
			//Crear una lista de String.
			List<String> suiteFiles = new ArrayList<String>();
			
			String opcionPrueba = JOptionPane.showInputDialog(null, "Escriba el número de la prueba automatizada \n que desea ejecutar \n 1. Loguin Cotizador \n 2. Cotizar Oferta Zona Elite estrato 1-2-3 Paquete Ind"
					+ "\n 3. Cotizar Oferta Zona Elite estrato 4-5-6 Paquete Ind \n 4. Cotizar Oferta Zona NO Elite estrato 1-2-3 Paquete Ind + \n 5. Cotizar Oferta Zona NO Elite estrato 4-5-6 Paquete Ind \n + \n 6.Cotizar Oferta Zona Elite estrato 1-2-3 Paquete Duo"
					+ "\n 7. Cotizar Oferta Zona Elite estrato 4-5-6 Paquete Duo + \n 8. Cotizar Oferta Zona NO Elite estrato 1-2-3 Paquete Duo    ");
			
			switch (opcionPrueba) {
			
			//Ejecuta Pagar Premios
			case "1":
				
				//Agrega el archivo a la lista
				suiteFiles.add("C:\\Users\\aprendiz.qa2\\workspace\\Sigapos\\testngPagarPremios.xml");
				runner.setTestSuites(suiteFiles);
				runner.run();
				break;
				
			//Ejecuta Anular Giros	
			case "2":
				suiteFiles.add("C:\\Users\\aprendiz.qa2\\workspace\\Sigapos\\testngAnularGiros.xml");
				runner.setTestSuites(suiteFiles);
				runner.run();
				break;
				
			//Ejecuta Crear Giros 	
			case "3":
				suiteFiles.add("C:\\Users\\aprendiz.qa2\\workspace\\Sigapos\\testngCrearGiro.xml");
				runner.setTestSuites(suiteFiles);
				runner.run();
				break;	
				
			//Ejecuta Pago de giros
			case "4":
				suiteFiles.add("C:\\Users\\aprendiz.qa2\\workspace\\Sigapos\\testngPagarGiros.xml");
				runner.setTestSuites(suiteFiles);
				runner.run();
				break;	
				
			//Ejecuta Login
			default:
				break;
			}
		}

	}
}
