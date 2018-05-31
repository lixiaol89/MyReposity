package invocation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.InvocationHandler;

public class Proxytest implements InvocationHandler{

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String check(String sql ,String code){
		if(code.contains("USD")||code.contains("JPY")||code.contains("CHF")||code.contains("HKD")||code.contains("KRW")||code.contains("CNY")||code.contains("CNH")){
			String s1 = code;
			String s2 = code.substring(code.length()-3, code.length());
			String s3 = code;
			sql = sql.replace("{1}", "FX");
			sql = sql.replace("{2}", s2);
			sql = sql.replace("{3}", s3);
		}else{
			
			String s3 = code+".MORN";
			sql = sql.replace("{1}", "MORN");
			String s2 = "";
			if(code.contains(".")){
				s2 = "USD";
			}
			sql = sql.replace("{2}", s2);
			sql = sql.replace("{3}", s3);
		}
		
			return sql+";";
	}
	
	public static void main(String[] args) throws IOException {
		FileInputStream f = new FileInputStream(new File("D:\\Users\\K0180060\\Desktop\\temp\\行情测试数据2.txt"));
		InputStreamReader r = new InputStreamReader(f);
		BufferedReader re = new BufferedReader(r);
		
		FileOutputStream out = new FileOutputStream(new File("D:\\Users\\K0180060\\Desktop\\temp\\行情测试数据3.txt"));
		StringBuilder ss = new StringBuilder();
		String sql = "";
		int k =0;
		while(( sql = re.readLine())!=null){
			if(!sql.startsWith("=====") && k==0){
				ss.append(sql);
			} else{
				if(sql.startsWith("=====")){
					k=1;
					continue;
				}
				String ssl = new Proxytest().check(ss.toString(), sql);
				System.out.println(ssl);
				out.write(ssl.getBytes());
				out.write("\n".getBytes());
			}
		}
		out.close();
		r.close();
	}

}
