import java.util.Scanner;
public class TicTacToe{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char board[3][3] = '';
		System.out.println("Which row would you like to choose?");
		int row = sc.nextInt();
		System.out.println("Which column would you like to choose?");
		int col = sc.nextInt();
		board[row, col] = 'X';
		System.out.println(board[row, col]);
	}
}