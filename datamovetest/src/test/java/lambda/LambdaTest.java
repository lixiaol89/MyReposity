package lambda;


public class LambdaTest {
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();
		
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
	}

}
