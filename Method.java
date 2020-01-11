public class Method {
	
	public static void direction() {
		System.out.println();
		System.out.println("        w. North");
		System.out.println("a. West           d. East");
		System.out.println("        s. South");
		System.out.println();
		System.out.println("-Press \"z\" to show your State-");
	}

	public static void PrintBlock() {
		System.out.println("There is a wall that is block your way.");
	}

	public static void PrintSeeMonster(String monster) {
		System.out.println("You see a " + monster + "!!");
	}

	public static void monsterDead(String monster, int drop) {
		System.out.println(monster + " dead! You win!");
		System.out.println("You get " + drop + " coins");
	}

	public static void PrintChoose() {
		System.out.println();
		System.out.println("1. Attack\n" + "2. Flee\n" + "3. Item");
	}

	public static void PrintItem(int p, int a, int i) {
		System.out.println("1. Potion -------- " + p);
		System.out.println("2. Antidote ------ " + a);
		System.out.println("3. Insecticide --- " + i);
	}

	public static void PrintUseZero(int use) {
		if (use == 1)
			System.out.println("You have 0 Potion.");
		else if (use == 2)
			System.out.println("You have 0 Antidote.");
		else if (use == 3)
			System.out.println("You have 0 Insecticide.");
	}

	public static void PrintUse(int use) {
		if (use == 1)
			System.out.println("You use Potion, your HP has increase 200!");
		else if (use == 2)
			System.out.println("You use Antidote, you feel you are healthy!");
		else if (use == 3)
			System.out
					.println("You use Insecticide...\n" + "Nothing happened.");
		else
			System.out.print("You enter a wrong number, ");
	}

	public static int useWrongNum(double wrong, int playerHP) {
		if (wrong < 1.3) {
			System.out
					.println("then you stabbed by some thorns that you don't know why these things in your bag.\n"
							+ "You get 20 damage!");
			return playerHP - 20;
		} else if (wrong < 1.7) {
			System.out
					.println("then you find a bottle for a quarter of Potion in your pocket.\n"
							+ "Cool! Your HP has increase 50!");
			return playerHP + 50;
		} else {
			System.out
					.println("and you find an Antidote in your backpack.\n"
							+ "After you drink the Antidote, you feel you are full of power!");
			return playerHP;
		}
	}

	public static int receive(double random, int playerHP, int legend) {
		if (legend == 0) {
			System.out.println("You throw your Magic Dices...");
			if (random < 1) {
				System.out.println("You get \"1\"! You have increase 100HP!");
				return playerHP + 100;
			} else if (random < 2) {
				System.out
						.println("Oh my! You get \"2\", You have receive 50 damage with your Magic!");
				return playerHP - 50;
			} else {
				System.out
						.println("It hurt! You get \"3\" and You have receive 100 damage with your Magic!");
				return playerHP - 100;
			}
		} else {
			System.out.println("You throw your Legend Dice...");
			if (random < 1) {
				System.out.println("You get \"1\"! You have increase 200HP!");
				return playerHP + 200;
			} else if (random < 2) {
				System.out
						.println("Oh my! You get \"2\", You have receive 25 damage with your Magic!");
				return playerHP - 25;
			} else {
				System.out
						.println("It hurt! You get \"3\" and You have receive 50 damage with your Magic!");
				return playerHP - 50;
			}
		}
	}

	public static int attack(int monsterHP, int dice, int legend, String monster) {
		if (legend == 0) {
			System.out.println("You throw your Magic Dices...");
			int fourtosix = (int) (Math.random() * 3) + 4;
			int damage = (fourtosix * 10) + dice;
			System.out.println("You get \"" + fourtosix + "\"! " + monster
					+ " get " + damage + " damage!");
			return monsterHP - damage;
		} else {
			int damage = legend;
			System.out.println("You throw your Legend Dice...");
			System.out.println(monster + " get " + damage + " damage!");
			return monsterHP - damage;
		}

	}

	public static int monsterAttack(int playerHP, int ATK, String monster) {
		if (ATK <= 0) {
			System.out.println("Your Armor makes you immune to " + monster
					+ " damage.");
			return playerHP;
		} else {
			System.out.println(monster + " inflicted " + ATK
					+ " damage for you!");
			return playerHP - ATK;
		}
	}

	public static int inPoisoning(int playerHP, int poisoning) {
		System.out.println("You are in poisoning!! You get 5 damage!");
		poisoning--;
		return playerHP - 5;
	}

	public static void PrintFlee() {
		System.out.println("You flee!!!");
	}

	public static void PrintFail() {
		System.out.println("You fail to escape!");
	}

	public static int correct(int potion) {
		System.out.println("Great! The answer is correct!\n"
				+ "You get a Potion");
		return potion++;
	}

	public static int wrong(int playerHP) {
		System.out.println("Sorry, wrong answer!\n"
				+ "You get hurt by the trap.\n" + "You get 100 damage!");
		return playerHP - 100;
	}

	public static void rainbow() {
		System.out.println("            $$$$$$$$$$$$$$$             ");
		System.out.println("         $$$$$$$IIIIIII$$$$$$           ");
		System.out.println("       $$$$$III========IIII$$$$         ");
		System.out.println("      $$$$II==============III$$$$       ");
		System.out.println("     $$$II=======$$$$$======II$$$$      ");
		System.out.println("    $$$II====$$$$$$$$$$$$=====II$$$     ");
		System.out.println("   $$$II====$$$$$$777$$$$$$====I$$$$    ");
		System.out.println("   $$II====$$$$777777777$$$$====I$$$    ");
		System.out.println("  $$$$====$$$$777    7777$$$$===II$$    ");
		System.out.println(" $$   $   $$$777       777$$$$$$$$$$$   ");
		System.out.println("$.         $$$$$     $$$$$      $    $  ");
		System.out.println("$~            ~$    $~               $  ");
		System.out.println("$~~~    ~~~~~~~$   $$~~~~~~~          $ ");
		System.out.println(" $$~~~~~~$$$$$$     $$~~~~~~~~      ~~$ ");
		System.out.println("    $$$$$             $$$$$~~~~~~~~~~$$ ");
		System.out.println("                           $$$~~~~$$$$  ");
		System.out.println("                               $$       ");
		System.out.println("========================================");
		System.out.println("|  _______           _______  _______  |");
		System.out.println("| (  ____ \\|\\     /|(  ___  )(  ____ ) |");
		System.out.println("| | (    \\/| )   ( || (   ) || (    )| |");
		System.out.println("| | (_____ | (___) || |   | || (____)| |");
		System.out.println("| (_____  )|  ___  || |   | ||  _____) |");
		System.out.println("|       ) || (   ) || |   | || (       |");
		System.out.println("| /\\____) || )   ( || (___) || )       |");
		System.out.println("| \\_______)|/     \\|(_______)|/        |");
		System.out.println("========================================");
		System.out.println("Welcome to Raindow Shop, enter the color of rainbow to buy your want.");
	}
	
	public static void MysteriousGrave(){
		System.out.println("##\\      ##\\                       ##\\                         ##\\                               ");
		System.out.println("###\\    ### |                      ## |                        \\__|                              ");
		System.out.println("####\\  #### |##\\   ##\\  #######\\ ######\\    ######\\   ######\\  ##\\  ######\\  ##\\   ##\\  #######\\ ");
		System.out.println("##\\##\\## ## |## |  ## |##  _____|\\_##  _|  ##  __##\\ ##  __##\\ ## |##  __##\\ ## |  ## |##  _____|");
		System.out.println("## \\###  ## |## |  ## |\\######\\    ## |    ######## |## |  \\__|## |## /  ## |## |  ## |\\######\\  ");
		System.out.println("## |\\#  /## |## |  ## | \\____##\\   ## |##\\ ##   ____|## |      ## |## |  ## |## |  ## | \\____##\\ ");
		System.out.println("## | \\_/ ## |\\####### |#######  |  \\####  |\\#######\\ ## |      ## |\\######  |\\######  |#######  |");
		System.out.println("\\__|     \\__| \\____## |\\_______/    \\____/  \\_______|\\__|      \\__| \\______/  \\______/ \\_______/ ");
		System.out.println("             ##\\   ## |                                                                          ");
		System.out.println("             \\######  |                                                                          ");
		System.out.println("              \\______/                                                                           ");
		System.out.println("                       ######\\                                                                   ");
		System.out.println("                      ##  __##\\                                                                  ");
		System.out.println("                      ## /  \\__| ######\\  ######\\ ##\\    ##\\  ######\\                            ");
		System.out.println("                      ## |####\\ ##  __##\\ \\____##\\\\##\\  ##  |##  __##\\                           ");
		System.out.println("                      ## |\\_## |## |  \\__|####### |\\##\\##  / ######## |                          ");
		System.out.println("                      ## |  ## |## |     ##  __## | \\###  /  ##   ____|                          ");
		System.out.println("                      \\######  |## |     \\####### |  \\#  /   \\#######\\                           ");
		System.out.println("                       \\______/ \\__|      \\_______|   \\_/     \\_______|                          ");
		System.out.println();
		System.out.println("¡¯¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡¯");
		System.out.println("| You have discovered a grave and it looks like full of danger.|");
		System.out.println("|      But, it also look like have a big treasure inside.      |");
		System.out.println("|           Are you ready to explore the treasure?             |");
		System.out.println("|                                                              |");
		System.out.println("|                 (*Press any key to Start*)                   |");
		System.out.println("¡¯¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡C¡Ð¡¯");
	}
	
	public static void treasure(){
		System.out.println("*******************************************************************************");
		System.out.println("          |                   |                  |                     |       ");
		System.out.println(" _________|________________.=\"\"_;=.______________|_____________________|_______");
		System.out.println("|                   |  ,-\"_,=\"\"     `\"=.|                  |                   ");
		System.out.println("|___________________|__\"=._o`\"-._        `\"=.______________|___________________");
		System.out.println("          |                `\"=._o`\"=._      _`\"=._                     |       ");
		System.out.println(" _________|_____________________:=._o \"=._.\"_.-=\"'\"=.__________________|_______");
		System.out.println("|                   |    __.--\" , ; `\"=._o.\" ,-\"\"\"-._ \".   |                   ");
		System.out.println("|___________________|_._\"  ,. .` ` `` ,  `\"-._\"-._   \". '__|___________________");
		System.out.println("          |           |o`\"=._` , \"` `; .\". ,  \"-._\"-._; ;              |       ");
		System.out.println(" _________|___________| ;`-.o`\"=._; .\" ` '`.\"\\` . \"-._ /_______________|_______");
		System.out.println("|                   | |o;    `\"-.o`\"=._``  '` \" ,__.--o;   |                   ");
		System.out.println("|___________________|_| ;     (#) `-.o `\"=.`_.--\"_o.-; ;___|___________________");
		System.out.println("____/______/______/___|o;._    \"      `\".o|o_.--\"    ;o;____/______/______/____");
		System.out.println("/______/______/______/_\"=._o--._        ; | ;        ; ;/______/______/______/_");
		System.out.println("____/______/______/______/__\"=._o--._   ;o|o;     _._;o;____/______/______/____");
		System.out.println("/______/______/______/______/____\"=._o._; | ;_.--\"o.--\"_/______/______/______/_");
		System.out.println("____/______/______/______/______/_____\"=.o|o_.--\"\"___/______/______/______/____");
		System.out.println("/______/______/______/______/______/______/______/______/______/______/        ");
		System.out.println("*******************************************************************************");
		System.out.println();
	}

}
