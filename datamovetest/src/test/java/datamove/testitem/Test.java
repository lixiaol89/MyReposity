package datamove.testitem;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd/hhmmss");
		Date date = new Date(1510997902000l);
		String dd = sd.format(date);
		System.out.println(dd);
		
		
		String s = new String("删除报错".getBytes(),"UTF-8");
		System.out.println(s);
		System.out.println("删除报错");
		
		
		String me = "xE5xB7xB2xE6x9Cx89xE5xADx98xE5x9CxA8xE7x9Ax84xE8xAExB0xE5xBDx95xEFxBCx8CxE4xB8x8DxE5x85x81xE8xAExB8xE9x87x8DxE5xA4x8DxE6x96xB0xE5xA2x9E";
		String[] mes = me.split("x");
		System.out.println(mes);
		String mesage = "";
		for(String d : mes){
			mesage += d;
		}
		System.out.println(mesage);
		String ss = "已有存在的记录，不允许重复新增";
		
	}

}
