package TreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CurrentMap {
	final static ConcurrentHashMap<String, Object> cmap = new ConcurrentHashMap<>();
	static int r=0;
	static List<Integer> list = new ArrayList<>();
	static{
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(32);
		list.add(34);
		list.add(12);
		list.add(10);
		list.add(41);
		list.add(31);
		list.add(15);
		list.add(11);
		list.add(12);
		list.add(10);
		list.add(31);
		list.add(14);
	}
	
	public void testmap(String key, Object value){
		int j=0;
		ThreadLocal local = new ThreadLocal<>();
		while(cmap.containsKey(key)){
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("j="+j++);
		}

		if(!cmap.containsKey(key)){
			cmap.put(key, value);
			try {
				Thread.sleep(3000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i am " + key);
			cmap.remove(key);
		}
	
	}

	
	public void produceThread(){
		
		for(int i=0;i<list.size()-1;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					r++;
					new CurrentMap().testmap(list.get(r)+"", list.get(r));
				}
			}).start();
		}
	}
	
	public static void main(String[] args) {
		new CurrentMap().produceThread();
	} 
}
