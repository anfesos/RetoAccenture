package com.accenture.ejemploSerenityCucumber.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.java.sl.Ce;

public class Excel {

	private Iterator<Cell> celdas;
	private XSSFWorkbook workbook;
	private XSSFSheet hoja;
	private Iterator<Row> lineas;
	private String nombreArchivo;
	
	public Excel(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Map<Integer, List<String>> Lectura() {
		// System.out.println("Inicio lectura");
		String ruta = "./DataDrive/" + this.nombreArchivo;
		Map<Integer, List<String>> data = new HashMap();

		try {
			// abrir el archivo excel
			FileInputStream file = new FileInputStream(new File(ruta));
			// Se crea el objeto que va a contener el libro de trabajo
			workbook = new XSSFWorkbook(file);
			// leer hoja
			hoja = workbook.getSheetAt(0);
			
			
			int i = 0;
			
			for (Row row : hoja) {
			    data.put(i, new ArrayList<String>());
			    for (Cell cell : row) {
			        switch (cell.getCellType()) {
			            case 1: //String
			            	data.get(new Integer(i)).add(cell.getRichStringCellValue().getString());
			            	break;
			            case 0: //Numeric 
			            	
			            	if (DateUtil.isCellDateFormatted(cell)) {
			            		data.get(i).add(cell.getDateCellValue() + "");
			            	} else {
			            		data.get(i).add(cell.getNumericCellValue() + "");
			            	}
			            	
			            	break;
			            case 2:  //Formula
			            	data.get(i).add(cell.getCellFormula() + "");
			            	break;
			            
			            case 3: //Celda Vacia
			            	data.get(i).add("NA");
			            	break;
			            case 4:
			            	data.get(i).add(cell.getBooleanCellValue() + "");
			            	break;
			            case 5:
			            	data.get(i).add("NA");
			            	break;
			            
			            default: data.get(i).add("NA");
			     
			            
			        }
			    }
			    i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

}
