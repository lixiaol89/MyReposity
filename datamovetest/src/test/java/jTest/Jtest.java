package jTest;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class Jtest {
	int i=0 ,j=2;

	String d ="2";

	List list = new ArrayList();
	
	List link = new LinkedList<>();
	
	Map map = new HashMap();
	
	Hashtable ta = new Hashtable<>();
	
	ConcurrentHashMap ap = new ConcurrentHashMap<>();
	
	Object obj = new Object();
	
	Map treemap = new TreeMap();
	
	Thread tread = new Thread();
	
	StringBuilder bu =new StringBuilder();
	
	StringBuffer bf = new StringBuffer();
	
	SpringBeanJobFactory s  = new SpringBeanJobFactory();
	
	ComboPooledDataSource spool = new ComboPooledDataSource();
	
	ConfigurationClassPostProcessor ss = new ConfigurationClassPostProcessor();
	
	public void dd(Function f, String... d ){
		int a = d.length;
		for(String s :d){
			System.out.println(s);
		}
	}
	
	public String check(final String s) throws UnsupportedEncodingException{
		String ss = new String(s.getBytes(),"GBK");
		System.out.println(ss);
		return s;
	}
	
	public void fort(){
		for(int i=0;i<3;i++){
			System.out.println("i="+i);
			for(int j=0;j<3;j++){
				System.out.println("j="+j);
				if(j==1){
					break;
				}
			}
		}
	}
	
	public void notes(String[] s){
		s[2] = "sadasd";
		System.out.println(s[3]);
	}
	
	
	public void vv(Void a){
		System.out.println(a);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		int[] src ={1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(src));
		System.arraycopy(src, 6, src, 3, 4);
		System.out.println(Arrays.toString(src));
		
		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());
		
		System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		Integer ss = new Integer(222222222);
		long sss = ss.intValue();
//		Void a = null;
		try {
			new Jtest().check("\\u62db\\u5546\\u9f99\\u817eVN17111704");
			System.out.println(Jtest.class);
			System.out.println(Jtest.class);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Date date = new Date(1519228800000l);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		System.out.println(sdf.format(date));
		
//		InputStream in = new FileInputStream("");
//		ConcurrentLinkedQueue s = new ConcurrentLinkedQueue<>();
//		
//		BigDecimal coupon  = new BigDecimal(0);
//		int result = coupon.compareTo(new BigDecimal(0));
//		System.out.println(result);
//		//客户信息表里券息为0取券池表里的券息
//		if(result == 0){
//			System.out.println(1);
//		}
//		Calendar d = Calendar.getInstance();
//		System.out.println(d);
//		System.out.println(d.getTime());

//		BigDecimal s = new BigDecimal("4e-8");s.toPlainString();
//		System.out.println(s.toPlainString());
//		s.intValue();
//		(s).intValue();
//		System.out.println(s.intValue());
//		System.out.println((s).intValue());
		
//		int i= 1<<30;
//		int d=1;
//		for(int e=0;e<30;e++){
//			d =d*2;
//		}
//		System.out.println(i);
//		System.out.println(d);
//		System.out.println(12 << 1);
//		System.out.println(12 >> 1);
//		System.out.println(12 >>> 1);
//		String[] s1 = new String[10];
//		new Jtest().notes(s1);
//		
//		Jtest jtest = new Jtest();
//		Jtest jtest1 = new Jtest();
//		Jtest jtest2 = new Jtest();
//		System.out.println(jtest.toString()+","+jtest+","+jtest.hashCode());
//		System.out.println(jtest1.toString()+","+jtest1+","+jtest1.hashCode());
//		System.out.println(jtest2.toString()+","+jtest2+","+jtest2.hashCode());
//		Map map =new HashMap();
//		map.put(jtest, jtest);
//		map.put(jtest1, jtest);
//		map.put(jtest2, jtest);
//		Set keys = map.keySet();
//		for(Object key: keys){
//			System.out.println(key);
//		}
//		
//		int i=3,f=9;
//		int j = f =1;
//		
//		System.out.println(j);
//		System.out.println(f);
//		
//		BigDecimal d = new BigDecimal("9.858482195929108E-7");//0.00002615299982355379
//		String sddd = d.toPlainString();
//		System.out.println(sddd);
//		
//		for(;;){
//			System.out.println(i++);
//			if(i==20)
//				break;
//		}
		
		String tradeid = "dsfdsfdsfsf_div";
			String tradeidtemp = tradeid.substring(0,tradeid.length()-4);
			System.out.println(tradeidtemp);
		
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				long s = df.parse("2017-11-09").getTime();
				
				System.out.println(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BigDecimal a = new BigDecimal("440998.74524080");
			BigDecimal b = new BigDecimal("18.56930000");
			BigDecimal c = a.multiply(b).abs();
			double d = c.doubleValue();
			System.out.println(d);
			
			String ss1= " "; 
			BigDecimal s1 = new BigDecimal(ss1);
			System.out.println("============="+s1);
	}
	
	
	
 }
