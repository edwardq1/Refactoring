import java.util.Scanner;
public class Manager
{
	public static void main(String[] args)
	{	
		//asks the user for input rounds and stores that number into rounds
		Scanner moves= new Scanner(System.in);
		System.out.print("How many rounds do you want(1-100)? ");
		int numberOfRounds = moves.nextInt();
		
		Scanner high = new Scanner(System.in);
		//asks the user for probability of high attacks
		System.out.print("What probability of high attacks do you want? ");
		int highAttacks = high.nextInt();
		
		
		//asks the user for probability of low attacks
		Scanner low = new Scanner(System.in);
		System.out.print("What probability of low attacks do you want? ");
		int lowAttacks = low.nextInt();
		
		
		//asks the user for probability of medium attacks
		Scanner medium = new Scanner(System.in);
		System.out.print("What probability of medium attacks do you want? ");
		int mediumAttacks = medium.nextInt();
		
		
		//this if statement is to ensure that the rounds are in range of 1-100. 
		if ((numberOfRounds<1) || (numberOfRounds>100))
		{
			numberOfRounds=10;
			System.out.print("The rounds you have entered is not in range, by default the rounds is set to 10.");
		}
		//instantiates the Attacker class and Defender class
		Attacker attack = new Attacker();
		attack.validateUserInput(highAttacks,lowAttacks,mediumAttacks);
		Defender defend = new Defender();
		//If the probability the user inputs doesnt equal 100, it will set a default value
		if ((highAttacks+lowAttacks+mediumAttacks) != 100)
		{
			highAttacks=attack.getDefaultHighAttack();
			lowAttacks=attack.getDefaultLowAttack();
			mediumAttacks=attack.getDefaultMediumAttack();
		}
		//
		while (numberOfRounds > 0)
		{
			attack.generateAttack(highAttacks,lowAttacks,mediumAttacks);
			defend.getDefense(numberOfRounds, attack.getAttack());
			numberOfRounds= numberOfRounds -1;
		}
		
		
		defend.printResults();
			
	
		
	}
	
}