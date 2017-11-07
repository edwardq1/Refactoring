import java.util.Random;
public class Attacker
{
	private int SUM;
	private int defaultHighAttack;
	private int defaultLowAttack;
	private int defaultMediumAttack;
	private String typeAttack;
	// default values for SUM and typeAttack
	public Attacker()
	{
		SUM=0;
		typeAttack="";
		defaultHighAttack = 33;
		defaultLowAttack = 33;
		defaultMediumAttack = 30;
	}
		
	//This method generates a random move depending on what the user inputs as the 
	// percentages. 
	public void generateAttack(int highAttackProbability, int lowAttackProbability, int mediumAttackProbability)
	{
		Random generator = new Random();
		int determineAttack = generator.nextInt(99) + 1;
		int sum = highAttackProbability + lowAttackProbability + mediumAttackProbability;
		if (determineAttack > 0 && determineAttack < highAttackProbability)
		{
			typeAttack= "High";
		}
		if (determineAttack > (highAttackProbability) && determineAttack < (highAttackProbability + lowAttackProbability))
		{
			typeAttack= "Low";
		}
		if (determineAttack > (highAttackProbability+lowAttackProbability) && determineAttack < (sum))
		{
			typeAttack= "Medium";
		}
	}

	//This method is the check and see if the user entered invalid information
	// and will set it to default percentages if the user did enter a value>100 or less than
	// 100.
	public void validateUserInput(int highAttackPercentage, int lowAttackPercentage, int mediumAttackPercentage)
	{
		SUM = highAttackPercentage + lowAttackPercentage + mediumAttackPercentage;
		if (SUM != 100)
		{
			System.out.println("The percentage of attacks you've entered do not equal 100%.");
			System.out.println("By default, your attacks will now have a equal probability of each attack(33% each).");
			System.out.println("You have " + defaultHighAttack + "% high attacks.");
			System.out.println("You have " + defaultLowAttack + "% low attacks.");
			System.out.println("You have " + defaultMediumAttack + "% medium attacks.");
		}
	}
	
	
	//Returns the type of attack
	public String getAttack()
	{
		return(typeAttack);
	}
	
	//Returns the default value of low
	public int getDefaultLowAttack()
	{
		return(defaultLowAttack);
	}
	//Returns the default value of high
	public int getDefaultHighAttack()
	{
		return(defaultHighAttack);
	}
	//Returns the default value of medium
	public int getDefaultMediumAttack()
	{
		return(defaultMediumAttack);
	}
}
