import java.util.Scanner;
class Jackpot{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an upper bound");
		double max = sc.nextInt();
		System.out.println("Enter a lower bound");
		double min = sc.nextInt();
		double foo = Math.random();
		int bar = (int)(min + foo * (max - min + 1));
		System.out.println("Your random number is: " + bar);
	}
}