package practice;

import java.util.Random;
import java.util.Scanner;

class Umpire{
	private int number;
	private int guessed_number;
	public void setNumber(int number) {
		this.number = number;
	}
	public void setGuessed_Number(int guessed_number) {
		this.guessed_number = guessed_number;
	}
	public int result() {
		int res = 0;
		if(number == guessed_number) {
			System.out.println("You won");
			System.out.println();
			res = 1;
		}
		else if(number >= guessed_number){
			System.out.println("TIP: You Should increase the number");
			System.out.println();
		}
		else if(number <= guessed_number) {
			System.out.println("TIP: You Should decrease the number");
			System.out.println();
		}
		return res;
	}	
}
class Guesser{
	private int number;
	Random rand = new Random();
	public int input() {
		number = rand.nextInt(10);
		return number;
	}
}
class Player{
	Scanner sc = new Scanner(System.in);
	private String name;
	private int guessed_number;
	public void welcome() {
		System.out.print("Enter your name: ");
		name = sc.next();
		System.out.println("Welcome " + name);
		System.out.println();
	}
	public int input() {
		System.out.print("Enter your number between 0-9 to win the prize money: ");
		guessed_number = sc.nextInt();
		return guessed_number;
	}
	
}
public class GuessingGame {
	public static void main(String[] args) {
		int chances = 3;
		Player p1 = new Player();
		p1.welcome();
		Guesser g1 = new Guesser();
		int number = g1.input();
		int i=0;
		while(i<3) {
			System.out.println(chances + " chances left");
			int guessed_number = p1.input();
			Umpire u1 = new Umpire();
			u1.setNumber(number);
			u1.setGuessed_Number(guessed_number);
			int res = u1.result();
			if(res == 1) {
				System.out.println("Number was: "+ number);
				break;
			}
			else if(i==2 && res ==0) {
				System.out.println("YOU LOST");
				System.out.println("Number was: "+ number);
			}
			chances--;
			i++;
		}
	}
}