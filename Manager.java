import java.util.Scanner;
public class Manager
{
	public static void main(String[] args)
	{	
		int rounds=0;
		//asks the user for input rounds and stores that number into rounds
		Scanner moves= new Scanner(System.in);
		System.out.print("How many rounds do you want(1-100)? ");
		rounds= moves.nextInt();
		
		Scanner Hattacks = new Scanner(System.in);
		//asks the user for probability of high attacks
		System.out.print("What probability of high attacks do you want? ");
		int H= Hattacks.nextInt();
		
		
		//asks the user for probability of low attacks
		Scanner Lattacks = new Scanner(System.in);
		System.out.print("What probability of low attacks do you want? ");
		int L= Lattacks.nextInt();
		
		
		//asks the user for probability of medium attacks
		Scanner Mattacks = new Scanner(System.in);
		System.out.print("What probability of medium attacks do you want? ");
		int M= Mattacks.nextInt();
		
		
		//this if statement is to ensure that the rounds are in range of 1-100. 
		if ((rounds<1) || (rounds>100))
		{
			rounds=10;
			System.out.print("The rounds you have entered is not in range, by default the rounds is set to 10.");
		}
		//instantiates the Attacker class and Defender class
		Attacker attack = new Attacker();
		attack.check(H,L,M);
		Defender defend = new Defender();
		//If the probability the user inputs doesnt equal 100, it will set a default value
		if ((H+L+M) != 100)
		{
			H=attack.highchance();
			L=attack.lowchance();
			M=attack.mediumchance();
		}
		//
		while (rounds > 0)
		{
			attack.probability(H,L,M);
			defend.getdefence(rounds, attack.getAttack());
			rounds= rounds -1;
		}
		
		
		defend.printResults();
			
	
		
	}
	
}