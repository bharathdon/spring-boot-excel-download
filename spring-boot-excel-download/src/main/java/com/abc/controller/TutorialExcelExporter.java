package com.abc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.abc.model.Tutorial;

public class TutorialExcelExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<Tutorial> listTutorial;

	public List<Tutorial> getListTutorial() {
		return listTutorial;
	}

	public void setListTutorial(List<Tutorial> listTutorial) {
		this.listTutorial = listTutorial;
	}

	public TutorialExcelExporter() {
		// TODO Auto-generated constructor stub
		writerHeaderRow();
		writeDataRows();
	}

	public TutorialExcelExporter(List<Tutorial> listTutorial) {
		super();
		this.listTutorial = listTutorial;

		workbook = new XSSFWorkbook();
		workbook.createSheet("tutorial1");

	}

	public void writerHeaderRow() {
		XSSFRow row = sheet.createRow(0);

		XSSFCell cell = row.createCell(0);
		cell.setCellValue("id");

		cell = row.createCell(1);
		cell.setCellValue("desc");

		cell = row.createCell(2);
		cell.setCellValue("title");

		cell = row.createCell(3);
		cell.setCellValue("published");
	}

	public void writeDataRows() {

		int rowCount = 1;

		for (Tutorial tutorial : listTutorial) {

			XSSFRow row = sheet.createRow(rowCount++);

			XSSFCell cell = row.createCell(0);
			cell.setCellValue(tutorial.getId());
			sheet.autoSizeColumn(0);

			cell = row.createCell(1);
			cell.setCellValue(tutorial.getDescription());
			sheet.autoSizeColumn(1);

			cell = row.createCell(2);
			cell.setCellValue(tutorial.getTitle());
			sheet.autoSizeColumn(2);

			cell = row.createCell(3);
			cell.setCellValue(tutorial.getPublished());
		}

	}

	public void export(HttpServletResponse response) throws IOException {

writerHeaderRow();
writeDataRows();
		System.out.println(response.getContentType());
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

}
