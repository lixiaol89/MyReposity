package request;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

public class CreateRequest {
	
	public void con(){
		try {
			FileInputStream is = new FileInputStream(new File("D:\\Users\\K0180060\\Desktop\\240901.xlsx"));
			XSSFWorkbook work = new XSSFWorkbook(is);
			XSSFSheet sheet = work.getSheetAt(0);
			int last = sheet.getLastRowNum();
			JSONObject json = new JSONObject();
			for (int i=0;i<last;i++){
				XSSFRow row = sheet.getRow(i);
				try {
					short la = row.getLastCellNum();
					XSSFCell cell1 = row.getCell(1);
					int val = (int) cell1.getNumericCellValue();
					XSSFCell cell9 = row.getCell(9);
					String value = cell9.getStringCellValue();
					json.put(val+"", value);
				} catch (Exception e) {
					continue;
				}
				
			}
			;
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public static void main(String[] args) {
		new CreateRequest().con();
	}
}
