import java.util.Scanner;
class Calc{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num1 = sc.nextInt();
		System.out.println("Enter another number: ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.println("Would you like to add or multiply these numbers?");
		String oper = sc.nextLine();
		if(oper.charAt(1) == 'd'){
			int sum = num1 + num2;
			System.out.println("Your sum is " + sum);
		}
		else if(oper.charAt(1) == 'u'){
			int prod = num1 * num2;
			System.out.println("Your product is " + prod);
		}
		else{
			System.out.println("Why would you enter something that you knew wouldn't work?");
		}
	}
}