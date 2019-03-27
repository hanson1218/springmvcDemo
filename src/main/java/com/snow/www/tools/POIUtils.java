package com.snow.www.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.snow.www.entity.User;

public class POIUtils {
	public static void readExcel(String fileName) throws Exception {

		InputStream is = new FileInputStream(new File(fileName));
		Workbook hssfWorkbook = null;
		if (fileName.endsWith("xlsx")) {
			hssfWorkbook = new XSSFWorkbook(is);// Excel 2007
		} else if (fileName.endsWith("xls")) {
			hssfWorkbook = new HSSFWorkbook(is);// Excel 2003

		}
		// HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		// XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
		User student = null;
		List<User> list = new ArrayList<User>();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			// HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				// HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				Row hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					student = new User();
					// HSSFCell name = hssfRow.getCell(0);
					// HSSFCell pwd = hssfRow.getCell(1);
					Cell name = hssfRow.getCell(0);
					Cell pwd = hssfRow.getCell(1);
					// 这里是自己的逻辑
					student.setName(name.toString());
					student.setPhone(pwd.toString());

					list.add(student);
				}
			}
		}
		list.forEach(e -> System.out.println(e.toString()));

	}

	public static HSSFWorkbook createExcel() throws IOException {

		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("成绩表");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("学员考试成绩一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("机试成绩");
		// 在sheet里创建第三行
		HSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("李明");
		row3.createCell(1).setCellValue("As178");
		row3.createCell(2).setCellValue(87);
		row3.createCell(3).setCellValue(78);
		
		return wb;
		
	}

	public static void main(String[] args) throws Exception {
//		POIUtils.readExcel("F://TEST.xlsx");
		long start = System.currentTimeMillis();
		Thread.sleep(200);
		long finidh = System.currentTimeMillis();
	}

}
