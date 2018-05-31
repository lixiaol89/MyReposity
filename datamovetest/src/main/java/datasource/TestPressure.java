package datasource;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

public class TestPressure {
	
	private Map<String,Map<String,String>> map = new HashMap<>();
	
	private List<String> list = new ArrayList<>();
	
	private long num=0;
	
	public void checkoutorder(String starttime, String path) throws IOException, ParseException{
		list.add("orderid");
		
		File files = new File(path);
		String[] filenames =  files.list();
		for(String file : filenames){
			System.out.println(path+"\\"+file);
			boolean timeon = false;
			if(file.equalsIgnoreCase("mcube.server.ts.service.log")||file.equalsIgnoreCase("xcube.server.ts.service.log")) timeon = true;
			File ofile = new File(path+"\\"+file);
			if(ofile.exists()){
				this.nextfile(ofile, starttime,"2018-04-19 15:28", timeon);
				System.out.println(ofile.getName() + "mapsize :" + map.size());
			}
		}
		
		this.produceExcel2(map , path);
		System.out.println("done");
	}
	
	
	public void produceExcel(Map<String,Map<String,String>> map) throws IOException{
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet =  work.createSheet();
		
		Set<Entry<String, Map<String,String>>> en = map.entrySet();
		Iterator<Entry<String, Map<String, String>>> it = en.iterator();
		List<String> list = new ArrayList<>();
		list.add("orderid");
		for(int i=0;it.hasNext();i++){
			Entry<String, Map<String, String>> e = it.next();
			String orderid = e.getKey();
			Map<String,String> val = e.getValue();
			int j=0;
			if(i==0){
				XSSFRow row =  sheet.createRow(i);
				row.createCell(j).setCellValue("orderid");
				Set<Entry<String, String>> ee = val.entrySet();
				for(Entry<String, String> ei : ee){
					list.add(ei.getKey());
					row.createCell(++j).setCellValue(ei.getKey());
				}
				list.add("message");
			}else{
				XSSFRow row =  sheet.createRow(i);
				row.createCell(j).setCellValue(orderid);
				for(;j<list.size()-1;){
					row.createCell(++j).setCellValue(val.get(list.get(j)));
				}
			}
		}
		File file = new File("D:\\log\\开始时间 090909.xlsx");
		FileOutputStream excel = new FileOutputStream(file);
		work.write(excel);
		
	}
	
	public void produceExcel2(Map<String,Map<String,String>> map ,String path) throws IOException{
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet =  work.createSheet();
		
		Set<Entry<String, Map<String,String>>> en = map.entrySet();
		Iterator<Entry<String, Map<String, String>>> it = en.iterator();
		
		
		XSSFRow row =  sheet.createRow(0);
		for(int f = 0;f<list.size();f++){
			row.createCell(f).setCellValue(list.get(f));
		}
		for(int i=1;it.hasNext();i++){
			Entry<String, Map<String, String>> e = it.next();
			String orderid = e.getKey();
			Map<String,String> val = e.getValue();
			int j=0;
				
			XSSFRow row1 =  sheet.createRow(i);
			row1.createCell(j).setCellValue(orderid);
			for(;j<list.size()-1;){
				row1.createCell(++j).setCellValue(val.get(list.get(j)));
			}
		}
		
		String[] ls = path.split("\\\\");
		String finame = ls[ls.length-1];
		File file = new File("D:\\log\\"+ finame +".xlsx");
		FileOutputStream excel = new FileOutputStream(file);
		work.write(excel);
		
	}
	
	public void nextfile(File file, String starttime, String endtime) throws IOException, ParseException{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dd = sd.parse(starttime);
		long startlong = dd.getTime();
		long endlong = 0;
		if(!endtime.equals("")){
			Date ee = sd.parse(endtime);
			endlong = ee.getTime();
		}

		FileInputStream fi = new FileInputStream(file);
		InputStreamReader rf= new InputStreamReader(fi);
		BufferedReader rr = new BufferedReader(rf);
		String line = "";
		String lastorder =""; 
		Map<String,String> val = new HashMap<>();
		while((line =rr.readLine())!=null){
			
			if(line.length()<19) continue;
			String ltime = line.substring(0, 19);
			Date li = sd.parse(ltime);
			long lt = li.getTime();
			
			if(lt<startlong){
				continue;
			}
			if(!endtime.equals("") && lt > endlong){
				break;
			}
			
			Pattern p=Pattern.compile(".*Order.*----.*");  
			Matcher m=p.matcher(line);  
			
			Pattern pe = Pattern.compile(".*Exception:.*");
			Matcher me = pe.matcher(line);
			if(me.find()){
				if(map.containsKey(lastorder)){
					val = map.get(lastorder);
					val.put("message", line);
				}
			}
			while(m.find()){ 
				String ordersta = line.split("Order：")[1];
				String order = ordersta.split("----")[0];
				lastorder = order;
				
				String key = ordersta.split("----")[1].split("：")[0];
				String value = ordersta.split("----")[1].split("：")[1];
				
				if(!list.contains(key)){
					list.add(key);
					if("CS调用TS，结束".equals(key)){
						list.add("CS调用TS，总时间");
					}
				}
				if(list.contains("message"))
					list.remove("message");
					list.add("message");
				
				if(map.containsKey(order)){
					val = map.get(order);
					if(val.containsKey("CS调用TS，开始") && "CS调用TS，结束".equals(key)){
						String cstss = val.get("CS调用TS，开始");
						String cst = cstss.substring(0, cstss.length()-2).trim();
						long s = Long.valueOf(cst);
						String ends = value.substring(0, value.length()-2).trim();
						long e = Long.valueOf(ends);
						long totaltime = e - s;
						val.put("CS调用TS，总时间", totaltime+"ms");
					}
					val.put(key, value);
				}else{
					Map<String,String> val1 = new HashMap<>();
					val1.put(key, value);
					map.put(order, val1);
				}
				
				
			}
		}
		rr.close();
		rf.close();
		fi.close();
	}
	
	public void nextfile(File file, String starttime, String endtime, boolean timeon) throws IOException{
		FileInputStream fi = new FileInputStream(file);
		InputStreamReader rf= new InputStreamReader(fi);
		BufferedReader rr = new BufferedReader(rf);
		String line = "";
		boolean start = false;
		String lastorder =""; 
		Map<String,String> val = new HashMap<>();
		while((line =rr.readLine())!=null){
			Pattern pst = Pattern.compile(starttime);
			Matcher mst = pst.matcher(line);
			if(timeon){
				if(!mst.find()&&!start) continue; 
				else start = true;
			}
			Pattern pet = Pattern.compile(endtime);
			Matcher met = pet.matcher(line);
			if(met.find()) break;
			Pattern p=Pattern.compile(".*Order.*----.*");  
			Matcher m=p.matcher(line);  
			
			Pattern pe = Pattern.compile(".*Exception:.*");
			Matcher me = pe.matcher(line);
			if(me.find()){
				if(map.containsKey(lastorder)){
					val = map.get(lastorder);
					val.put("message", line);
				}
			}
			while(m.find()){ System.out.println(num++);
				String ordersta = line.split("Order：")[1];
				String order = ordersta.split("----")[0];
				lastorder = order;
				
				String key = ordersta.split("----")[1].split("：")[0];
				String value = ordersta.split("----")[1].split("：")[1];
				
				if(!list.contains(key)){
					list.add(key);
					if("CS调用TS，结束".equals(key)){
						list.add("CS调用TS，总时间");
					}
				}
				if(list.contains("message"))
					list.remove("message");
					list.add("message");
				
				if(map.containsKey(order)){
					val = map.get(order);
					if(val.containsKey("CS调用TS，开始") && "CS调用TS，结束".equals(key)){
						String cstss = val.get("CS调用TS，开始");
						String cst = cstss.substring(0, cstss.length()-2).trim();
						long s = Long.valueOf(cst);
						String ends = value.substring(0, value.length()-2).trim();
						long e = Long.valueOf(ends);
						long totaltime = e - s;
						val.put("CS调用TS，总时间", totaltime+"ms");
					}
					val.put(key, value);
				}else{
					Map<String,String> val1 = new HashMap<>();
					val1.put(key, value);
					map.put(order, val1);
				}
				
				
			}
		}
		rr.close();
		rf.close();
		fi.close();
	}
	
	public void jsonstring() throws IOException{
		FileOutputStream of = new FileOutputStream(new File("D:\\log\\pressurelog.txt"));
		JSONObject o = new JSONObject();
		Set<Entry<String, Map<String, String>>> set = map.entrySet();
		for(Entry<String, Map<String, String>> entry :set){
			String order = entry.getKey();
			Map<String, String> m = entry.getValue();
			Set<Entry<String,String>> t = m.entrySet();
			JSONObject so = new JSONObject();
			for(Entry<String,String> e : t){
				String key = e.getKey();
				String value = e.getValue();
				so.put(key, value);
			}
			
			o.put(order, so);
			System.out.println(o.toString());
		}
		of.write(o.toString().getBytes());
		of.close();
	}

	public static void main(String[] args) {
		try {System.out.println(new Date());
			new TestPressure().checkoutorder(args[0], args[1]);
//			new TestPressure().checkoutorder("2018-05-13 11:21:07", "D:\\log\\2018-05-13 112107");
			System.out.println(new Date());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
