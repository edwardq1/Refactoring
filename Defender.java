import java.util.Random;
public class Defender
{
	private String printDefense;
	private int d;
	private int numberOfAttacksHit;
	private int numberOfAttacksBlocked;
	private int roundTracking;
	private int trackEnemyHighAttack;
	private int trackEnemyLowAttack;
	private int trackEnemyMediumAttack;
	private int percentageOfHighAttack;
	private int percentageOfLowAttack;
	private int percentageOfMediumAttack;
	private int percentOfHighDefense;
	private int percentOfLowDefense;
	private int percentOfMediumDefense;
	//Setting the default values for the variables
	public Defender()
	{
		printDefense ="";
		d= 0;
		numberOfAttacksHit= 0;
		numberOfAttacksBlocked= 0;
		roundTracking= 0;
		trackEnemyHighAttack=0;
		trackEnemyMediumAttack=0;
		trackEnemyLowAttack=0;
		percentageOfHighAttack=0;
		percentageOfLowAttack=0;
		percentageOfMediumAttack=0;
		percentOfHighDefense=0;
		percentOfLowDefense=0;
		percentOfMediumDefense=0;
	}
	
	
	
	//this method will generate a value between 1-3 and determine whether its a high
	//low or medium defense. It will only random generate a defense move 20 times 
	//then it will start recognizing the attacks and be smart about the defense moves.
	public void getDefense(int rounds, String attack)
	{
		if (roundTracking < 20)
		{
			Random generator = new Random();
			int defense = generator.nextInt(4-1) + 1;
			if (defense == 1)
			{
				printDefense = "High";
				percentOfHighDefense++;

			}
		
			if (defense == 2)
			{
				printDefense = "Low";
				percentOfLowDefense++;

			}
		
			if (defense == 3)
			{
				printDefense = "Medium";
				percentOfMediumDefense++;
			}
			determineHitorBlock(attack);
			trackEnemyAttacks(rounds,attack);
		}
		else
		{
			trackEnemyAttacks(rounds, attack);
			determineHitorBlock(attack);
			if (attack == "High")
			{
				percentOfHighDefense++;
			}
			if (attack == "Low")
			{
				percentOfLowDefense++;
			}
			if (attack == "Medium")
			{
				percentOfMediumDefense++;
			}
		}
		
	}
	
	
	
	//This counts the number of hits/blocks and prints out what round, attack and defence
	//move is made.
	public void determineHitorBlock(String att)
	{
		if (printDefense != att)
		{	
			numberOfAttacksHit= numberOfAttacksHit + 1;
			roundTracking=roundTracking + 1;
			if ("High" == att)
			{
				percentageOfHighAttack++;
			}
			if ("Low" == att)
			{
				percentageOfLowAttack++;
			}
			if ("Medium" == att)
			{
				percentageOfMediumAttack++;
			}
		}
		else
		{
			numberOfAttacksBlocked= numberOfAttacksBlocked + 1;
			roundTracking=roundTracking + 1;
			if ("High" == att)
			{
				percentageOfHighAttack++;
			}
			if ("Low" == att)
			{
				percentageOfLowAttack++;
			}
			if ("Medium" == att)
			{
				percentageOfMediumAttack++;
			}
		}
		
		System.out.printf("Round:%-5d Attacker: %-7s Defender: %s\n", roundTracking,att, printDefense);

	}
	
	
	
	//This method is to print the number of hits/blocks after the # of rounds.
	//Will also print the proportions of the defender and attacker
	public void printResults()
	{
	//This will calculate the percentage of attacks and defences(High, medium and low percentages)
		String percent= "%";
		percentOfHighDefense= (percentOfHighDefense*100)/roundTracking;
		percentOfMediumDefense= (percentOfMediumDefense*100)/roundTracking;
		percentOfLowDefense= (percentOfLowDefense*100)/roundTracking;
		percentageOfHighAttack= (percentageOfHighAttack*100)/roundTracking;
		percentageOfMediumAttack= (percentageOfMediumAttack*100)/roundTracking;
		percentageOfLowAttack= (percentageOfLowAttack*100)/roundTracking;

		
		System.out.printf("Number of hits: %-5d Number of hits blocked: %d\n", numberOfAttacksHit, numberOfAttacksBlocked);
		System.out.printf("Attacker proportions: Low: %d%-5s High: %d%-5s Medium: %d%-5s\n", percentageOfLowAttack, percent, percentageOfHighAttack,percent,percentageOfMediumAttack,percent);
		System.out.printf("Defender proportions: Low: %d%-5s High: %d%-5s Medium: %d%-5s\n", percentOfLowDefense,percent, percentOfHighDefense,percent, percentOfMediumDefense, percent);

	}
	
	//This method is to track the attack. It will take the number of values from low, medium
	// and high and do the math to get a percentage. Then it will do the range between them
	// and determine the highest possibility for the defensive move. 
	public void trackEnemyAttacks(int round, String attack)
	{
		
		if ((round%20) == 0)
		{
			trackEnemyLowAttack=(trackEnemyLowAttack*100)/20;
			trackEnemyMediumAttack=(trackEnemyMediumAttack*100)/20;
			trackEnemyHighAttack=(trackEnemyHighAttack*100)/20;
			Random generator = new Random();
			int defense = generator.nextInt(99) + 1;
			if (defense>0 && defense<trackEnemyHighAttack)
			{
				printDefense= "High";
			}
			else if (defense>trackEnemyHighAttack && defense<(trackEnemyHighAttack+trackEnemyLowAttack))
			{
				printDefense= "Low";

			}
			else if (defense>(trackEnemyHighAttack+trackEnemyLowAttack) && defense<(trackEnemyHighAttack+trackEnemyLowAttack+trackEnemyMediumAttack))
			{
				printDefense = "Medium";
			}
		}

		else if (attack == "High")
		{
			trackEnemyHighAttack++;
		}
		else if (attack == "Low")
		{
			trackEnemyLowAttack++;
		}
		else if (attack == "Medium")
		{
			trackEnemyMediumAttack++;
		}
			
	
	
	}

	
	

	
	
	
}
