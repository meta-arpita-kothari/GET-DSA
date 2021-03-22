package operations;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/*
 * class containing method to read programs
 */
public class Programs {

	private static Workbook wb;
	private static FileInputStream fis;
	private static Sheet sheet;

	// Map<String, Integer> programList = new HashMap<String, Integer>();
	Map<String, Integer> programList = new HashMap<String, Integer>();

	/**
	 * method to read program from file
	 * and add to programList
	 * @throws Exception
	 */
	public void readPrograms() throws Exception {
		fis = new FileInputStream("src/files/programs.xlsx");
		wb = WorkbookFactory.create(fis);
		sheet = wb.getSheet("Sheet1");
		int noOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= noOfRows; i++) {
			programList.put(
					sheet.getRow(i).getCell(0).toString(),
					(int) Math.round(Double.parseDouble(sheet.getRow(i)
							.getCell(1).toString())));
		}

	}

	/*
	 * display programs
	 */
	public void displayPrograms() {
		System.out.println("Program and Available Seats:");
		System.out.println(programList + "\n");
	}

	/*
	 * decrease seat quantity after allocating to one student
	 */
	public void decSeat(String course) {
		int newCount = programList.get(course) - 1;
		programList.put(course, newCount);
	}

}