package Assignment_7;

import java.util.Scanner;

public class A7Q12 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		String ques = scn.nextLine();
		
		code(ques,"");
	}

	public static void code(String ques, String ans){
		if(ques.length() == 0){
			System.out.println(ans);
			return;
		}
		
		Integer ch0 = Integer.parseInt(ques.substring(0,1));
		String roq0 = ques.substring(1);
		
		code(roq0, ans + (char)('a' - 1 + ch0));
		
		if(ques.length() >= 2){
			Integer ch01 = Integer.parseInt(ques.substring(0,2));
			String roq01 = ques.substring(2);
			
			if(ch01 <= 26)
				code(roq01, ans + (char)('a' - 1 + ch01));
		}
	}
}