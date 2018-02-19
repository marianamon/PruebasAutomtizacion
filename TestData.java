/* 
* @autor Mariana Alzate
* @since 2017/11/20 
* Esta clase se crea para la implementacion de Datadriven o datos dinamicos, atraves de Excel
 */


package SuiteCotizador.SuiteCotizador;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TestData {

	HSSFWorkbook libroExcel;
	HSSFSheet hoja1;
	HSSFCell cell;
	
	
	//Constructor
	public  TestData(String excelRuta){
		
		try {
			File ruta = new  File(excelRuta);
			FileInputStream fis = new FileInputStream(ruta);
			libroExcel = new HSSFWorkbook(fis);
			hoja1 = libroExcel.getSheetAt(0);
		} catch (Exception  e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public String obtenerDatos(int fila, int column){
		
	    DataFormatter formatter = new DataFormatter();
		cell = hoja1.getRow(fila).getCell(column);
		String dato = formatter.formatCellValue(cell);	    
		return dato;
	}
	
	public int obtenerCantFilas()
	{
		int filas = libroExcel.getSheetAt(0).getLastRowNum();
		filas=filas+1;
		return filas;		
	}
	
}