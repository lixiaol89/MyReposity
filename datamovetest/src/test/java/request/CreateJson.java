package request;

import java.util.Arrays;

public class CreateJson {
	public static void main(String[] args) {/*
		try {
			JSONObject json = new JSONObject();
			json.put("10002", "${token}");
			json.put("10029", "useryspw");
//			json.put("", "Cube@1234");
			
			while(true){
				InputStream in = System.in;
				BufferedInputStream bs = new BufferedInputStream(in);
				InputStreamReader re = new InputStreamReader(bs);
				BufferedReader read = new BufferedReader(re);
				String r = read.readLine();
				
				if("q".equals(r)){
					json = new JSONObject();
					json.put("10002", "${token}");
					json.put("10029", "useryspw");
					continue;
				}
				String[] rs = r.split(" ");
				if("c".equals(rs[0])){
					json = new JSONObject(rs[1]);
					continue;
					
				}
				
				String key=null;
				String value =null;
				String type = null;
				int f =0;
				for(String s : rs){
					if(f==0 && s.trim().length()>0){
						key = s;
						f++;
					}else if(f==1 && s.trim().length()>0){
						value =s;
						f++;
					}else if(f==2 && s.trim().length()>0){
						type =s;
						break;
					}
				}
				
				if("s".equals(type)){
					json.put(key, value);
				}else if("i".equals(type)){
					int v= Integer.valueOf(value);
					json.put(key, v);
				}
				
				System.out.println(json.toString());
				
			}
//			token10002    clientmsgid10029   msgtype  35
		} catch (Exception e) {
			// TODO: handle exception
		}
//		{"10029":"useryspw","11503":"62000738","554":"168168","19816":"7","10002":"${token}","10112":"0000500111A000000004"}
		
	*/
		
		String templatetype = "equityswAP";
		String[] tvalue = {"equityswap","nlswap","optionportfolio"};
		if(Arrays.asList(tvalue).contains(templatetype.toLowerCase())){
			System.out.println(templatetype);
			String tradeid = "dsfdsfsd_div";
			if(!tradeid.contains("_div")){
				System.out.println(tradeid);
			}else{
				System.out.println(tradeid);
				String tradeidtemp = tradeid.substring(0,tradeid.length()-4);
				System.out.println(tradeidtemp);
			}
		}else{
			System.out.println("wqewqewqe");
		}
	}

}
