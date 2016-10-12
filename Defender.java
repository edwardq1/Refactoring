import java.util.Random;
public class Defender
{
	private String printDefense;
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
	private Random generator;
	//Setting the default values for the variables
	public Defender()
	{
		printDefense ="";
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
		generator = new Random();
	}
	
	
	
	//this method will generate a value between 1-3 and determine whether its a high
	//low or medium defense. It will only random generate a defense move 20 times 
	//then it will start recognizing the attacks and be smart about the defense moves.
	public void getDefense(int rounds, String attack)
	{
		if (roundTracking < 20)
		{
			int defense = generator.nextInt(4-1) + 1;
			switch(defense){
			case 1: defense = 1;
					printDefense = "High";
					percentOfHighDefense++;
					break;
			case 2: defense = 2;
					printDefense = "Low";
					percentOfLowDefense++;
					break;
			case 3: defense = 3;
					printDefense = "Medium";
					percentOfMediumDefense++;
					break;
			}
			determineHitOrBlock(attack);
			trackEnemyAttacks(rounds,attack);
		} else {
			trackEnemyAttacks(rounds, attack);
			determineHitOrBlock(attack);
			if (attack == "High")
				percentOfHighDefense++;
			else if (attack == "Low")
				percentOfLowDefense++;
			else if (attack == "Medium")
				percentOfMediumDefense++;
		}
		
	}
	
	
	
	//This counts the number of hits/blocks and prints out what round, attack and defence
	//move is made.
	public void determineHitOrBlock(String att)
	{
		if (printDefense != att)
		{	
			numberOfAttacksHit++;
			roundTracking++;
			incrementAttack(att);

		} else {
			numberOfAttacksBlocked++;
			roundTracking++;
			incrementAttack(att);	
			}
		
		System.out.printf("Round:%-5d Attacker: %-7s Defender: %s\n", roundTracking,att, printDefense);

	}
	
	
	
	//This method is to print the number of hits/blocks after the # of rounds.
	//Will also print the proportions of the defender and attacker
	public void printResults()
	{
	//This will calculate the percentage of attacks and defences(High, medium and low percentages)
		String percent= "%";
		percentOfHighDefense= enemyAttackCalculation(percentOfHighDefense, roundTracking);
		percentOfMediumDefense= enemyAttackCalculation(percentOfMediumDefense, roundTracking);
		percentOfLowDefense= enemyAttackCalculation(percentOfLowDefense, roundTracking);
		percentageOfHighAttack= enemyAttackCalculation(percentageOfHighAttack, roundTracking);
		percentageOfMediumAttack= enemyAttackCalculation(percentageOfMediumAttack, roundTracking);
		percentageOfLowAttack= enemyAttackCalculation(percentageOfLowAttack, roundTracking);

		
		System.out.printf("Number of hits: %-5d Number of hits blocked: %d\n", numberOfAttacksHit, numberOfAttacksBlocked);
		System.out.printf("Attacker proportions: Low: %d%-5s High: %d%-5s Medium: %d%-5s\n", percentageOfLowAttack, percent, percentageOfHighAttack,percent,percentageOfMediumAttack,percent);
		System.out.printf("Defender proportions: Low: %d%-5s High: %d%-5s Medium: %d%-5s\n", percentOfLowDefense,percent, percentOfHighDefense,percent, percentOfMediumDefense, percent);

	}
	
	//This method is to track the attack. It will take the number of values from low, medium
	// and high and do the math to get a percentage. Then it will do the range between them
	// and determine the highest possibility for the defensive move. 
	public void trackEnemyAttacks(int round, String attack)
	{
		
		if (round % 20 == 20){
			trackEnemyHighAttack = enemyAttackCalculation(trackEnemyHighAttack, 20);
			trackEnemyLowAttack = enemyAttackCalculation(trackEnemyLowAttack, 20);
			trackEnemyMediumAttack = enemyAttackCalculation(trackEnemyMediumAttack, 20);
			int defense = generator.nextInt(99) + 1;
			if (defense>0 && defense<trackEnemyHighAttack)
				printDefense= "High";
			else if (defense>trackEnemyHighAttack && defense<(trackEnemyHighAttack+trackEnemyLowAttack))
				printDefense= "Low";
			else if (defense>(trackEnemyHighAttack+trackEnemyLowAttack) && defense<(trackEnemyHighAttack+trackEnemyLowAttack+trackEnemyMediumAttack))
				printDefense = "Medium";
		}
	}
	
	public void incrementAttack(String attack){
		switch (attack){
		case "High": attack = "High";
					//trackEnemyHighAttack++;
					percentageOfHighAttack++;
					break;
		case "Low":	attack = "Low";
					//trackEnemyLowAttack++;
					percentageOfLowAttack++;
					break;
		case "Medium":	attack = "Medium";
					//trackEnemyMediumAttack++;
					percentageOfMediumAttack++;
					break;
		}
	}
	
	public int enemyAttackCalculation(int attack, int rounds){
		int temp = (attack*100)/rounds;
		return temp;
	}	
	
}
