package operations;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/*
 * class to allocate branch to students
 * write to excel sheet
 */
public class AllocationMain {

	private static Workbook wb;
	private static FileInputStream fis;
	private static Sheet sheet;
	private static Row row;
	private static Cell cell;
	private static FileOutputStream fos;

	public static void main(String[] args) throws Exception {

		// initialize programs and read the file
		Programs programs = new Programs();
		programs.readPrograms();

		// initialize students and read the file
		Students students = new Students();
		students.readStudents();

		// adding students to queue
		QueueInterface queue = new QueueInterface(students.studentList.size());
		for (int i = 0; i < students.studentList.size(); i++) {
			queue.enqueue(students.studentList.get(i));
		}

		// processing each student by dequeuing from queue
		for (int i = 0; i < students.studentList.size(); i++) {
			Student studentObj = (Student) queue.dequeue();
			boolean courseAllocated = false;
			String courseName = null;
			for (int j = 0; j < studentObj.preference.length; j++) {
				if (courseAllocated) {
					break;
				} else {
					if (programs.programList.get(studentObj.preference[j]) != null
							&& programs.programList
									.get(studentObj.preference[j]) > 0) {
						courseName = studentObj.preference[j];
						courseAllocated = true;
						programs.decSeat(courseName);
					}
				}
			}
			if (courseName != null) {
				studentObj.allocateCourse(courseName);
			}
		}
		// displaying the list of students after allocation
		students.displayStudents();

		// writing the updated allocated list to new excel sheet
		fis = new FileInputStream("src/files/allocated.xlsx");
		wb = WorkbookFactory.create(fis);
		sheet = wb.getSheet("Sheet1");
		
		// clearing previous data of excel sheet
		int noOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= noOfRows; i++) {
			row = sheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue("");
			cell = row.createCell(1);
			cell.setCellValue("");
			fos = new FileOutputStream("src/files/allocated.xlsx");
			wb.write(fos);
			fos.flush();
			fos.close();
		}
		
		// writing to excel sheet
		for (int i = 1; i <= students.studentList.size(); i++) {
			row = sheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(students.studentList.get(i - 1).name);
			cell = row.createCell(1);
			cell.setCellValue(students.studentList.get(i - 1).allocation);
			fos = new FileOutputStream("src/files/allocated.xlsx");
			wb.write(fos);
			fos.flush();
			fos.close();
		}

	}

}