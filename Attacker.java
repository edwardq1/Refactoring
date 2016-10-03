import java.util.Scanner;
import java.util.Random;
public class Attacker
{
	private int SUM;
	private String typeAttack;
	// default values for SUM and typeAttack
	public Attacker()
	{
		SUM=0;
		typeAttack="";
	}
		
		
	//This method generates a random move depending on what the user inputs as the 
	// percentages. 
	public void probability(int Chance, int Chance1, int Chance2)
	{
		Random generator = new Random();
		int randAttack = generator.nextInt(99) + 1;
		if (randAttack > 0 && randAttack < Chance)
		{
			typeAttack= "High";
		}
		if (randAttack > (Chance) && randAttack < (Chance + Chance1))
		{
			typeAttack= "Low";
		}
		if (randAttack > (Chance+Chance1) && randAttack < (Chance+Chance1+Chance2))
		{
			typeAttack= "Medium";
		}
	}
	


	//This method is the check and see if the user entered invalid information
	// and will set it to default percentages if the user did enter a value>100 or less than
	// 100.
	public void check(int chance, int chance1, int chance2)
	{
		SUM = chance + chance1 + chance2;
		if (SUM != 100)
		{
			System.out.println("The percentage of attacks you've entered do not equal 100%.");
			System.out.println("By default, your attacks will now have a equal probability of each attack(33% each).");
			chance = 33;
			chance1 = 33;
			chance2 = 34;
			System.out.println("You have " + chance + "% high attacks.");
			System.out.println("You have " + chance1 + "% low attacks.");
			System.out.println("You have " + chance2 + "% medium attacks.");
		}
	}
	
	
	//Returns the type of attack
	public String getAttack()
	{
		return(typeAttack);
	}
	
	//Returns the default value of low
	public int lowchance()
	{
		return(33);
	}
	//Returns the default value of high
	public int highchance()
	{
		return(33);
	}
	//Returns the default value of medium
	public int mediumchance()
	{
		return(34);
	}
}
