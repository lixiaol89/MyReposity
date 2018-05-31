package game;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	String anwser;
	
}


class Test{
	public static void main(String[] args) {
		List<Question> list =new ArrayList<>();
		for(int i=0;i<10;i++){
			Question que = new Question();
			list.add(que);
		}
		
		List la = new ArrayList<>();
		la.add(list.get(1));
		la.add(list.get(2));
		la.add(list.get(3));
		la.add(list.get(5));
		List la1 = new ArrayList<>();la1.addAll(la);
				List la2 = new ArrayList<>();la2.addAll(la);
						List la3 = new ArrayList<>();la3.addAll(la);
								List la4 = new ArrayList<>();la4.addAll(la);
		
		
		
	}
}