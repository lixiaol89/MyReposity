package game;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RandomNum {
	public static void main(String[] args) {
//		for(int i=0 ;i<10;i++){
//			double dd = Math.random();
//			double s = (dd*10)/10;
//			System.out.println(s);
//		}
		Timer time = new  Timer(false);
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("this time:" + new Date().toString());
				
			}
		};
		
		int d = 0;
		try {
//			time.schedule(task, 10l, 3000l);
			int i = 0;
			do {
//				Thread.sleep(1000l);
				i++;
				if(d/30>0){
					System.out.println(i);
					d = 0;
				}else{
					d++;
				}
				
			} while (i<1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
//		new Thread(() ->{
//			
//		});
		
		System.out.println(1/3);
		System.out.println(10%3);
		
	}

}
