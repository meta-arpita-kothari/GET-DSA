package operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * class containing method to take input from students excel sheet
 */

public class Students {

	private static Workbook wb;
	private static FileInputStream fis;
	private static Sheet sheet;

	ArrayList<Student> studentList = new ArrayList<Student>();

	/**
	 * method to read student details and create into student object
	 * then add to studentList
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void readStudents() throws EncryptedDocumentException, IOException  {
		fis = new FileInputStream("src/files/students.xlsx");
		wb = WorkbookFactory.create(fis);
		sheet = wb.getSheet("Sheet1");
		int noOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= noOfRows; i++) {
			Student obj = new Student();
			obj.createStudent(sheet.getRow(i).getCell(0).toString(), sheet
					.getRow(i).getCell(1).toString(), "-");
			studentList.add(obj);
		}
	}

	/*
	 * display students
	 */
	public void displayStudents() {
		System.out.println("Name\t\tAllocation\tPreferences");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.print(studentList.get(i).name + "\t");
			System.out.print(studentList.get(i).allocation + "\t\t");
			System.out.print(String.join(",", studentList.get(i).preference)
					+ "\n");
		}

	}

}