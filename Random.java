import java.util.Scanner;
class Random {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String[]foo = new String[5];
		int[]bar = new int[5];
		for(int i = 0; i < 5; i++){
			System.out.println("Enter a word: ");
			foo[i] = sc.nextLine();
			System.out.println(foo[i]);
			System.out.println("What base (1-36) is your first input value? Please input a numerical representation: ");
			bar[i] = sc.nextInt(); //base of the first number
			System.out.println(bar[i]);
			sc.nextLine();
		}
	}
}