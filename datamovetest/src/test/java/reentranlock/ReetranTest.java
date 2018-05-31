package reentranlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReetranTest {
	public ReetranTest() {
		map.put("a", false);
	}
	volatile Map<String,Boolean> map = new HashMap<>();
	String k;
	
	public void setK(String k) {
		this.k = k;
	}

	synchronized void dd(){
		 boolean re = true;
		   if(map.containsKey(k)){
			   re = map.get(k);
			   System.out.println(re);
		   }
		   if(re){
			   map.put(k, false);
			   System.out.println("wait"+k);
			   try {
					   this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   }
	   System.out.println("****************"+map.size());
	   int i = 1/0;
		   System.out.println(k);
	   try {
		Thread.sleep(3000l);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	   this.notify();
   }
	
   ReentrantLock loc = new ReentrantLock();
   void cc(){ 
	   System.out.println("unlock"+k);
	   loc.lock();
	   System.out.println("lock"+k);
	   boolean re = true;
	   if(map.containsKey(k)){
		   re = map.get(k);
		   System.out.println(re);
	   }
	   Condition con = loc.newCondition();
	   
    try {
		   if(re){
			   map.put(k, false);
			   System.out.println("wait"+k);
//			   con.await();
			   con.awaitNanos(4000l);
		   }
		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  
	   try {
		Thread.sleep(3000l);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	   
	   System.out.println(k+"&&&&&&&&&&&&&&&&");
	   con.signal();
	   loc.unlock();
	  
   }
   
   
   synchronized void ff(){
	   System.out.println("************************");
	   
	   try {
		Thread.sleep(3000l);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   int i = 1/0;
   }
   	public static void main(String[] args) {
   		ReetranTest r = new ReetranTest();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				r.setK("a");
//				r.cc();
//				r.dd();
				r.ff();
			}
		}).start();
		
new Thread(new Runnable() {
			
			@Override
			public void run() {
				r.setK("b");
//				r.cc();
//				r.dd();
				r.ff();
			}
		}).start();

new Thread(new Runnable() {
	
	@Override
	public void run() {
		r.setK("c");
//		r.cc();
//		r.dd();
		r.ff();
	}
}).start();
	}
   
   
//	public static void main(String[] args) throws InterruptedException {
//		ReetranTest r = new ReetranTest();
//		for(int i=0;i<3;i++){
//		r.setK(i+"");
//		new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
////					r.dd();
//					r.cc();
//				}
//			}).start();;
//		}
//	}

}
