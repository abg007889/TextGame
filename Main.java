import java.util.Scanner;

public class Main {
	public static Method method = new Method();

	public static void main(String[] args) {
		int playerHP = 1000;
		int coins = 0;
		int damage;
		int dice = 0;
		int legend = 0;
		int armor = 0;
		int fireball = 0;
		int potion = 0;
		int antidote = 0;
		int insecticide = 0;
		int poisoning = 0;
		int babySpider = 0;
		int sPcount = 0;
		int batbite = 0;
		int stock[] = { 1, 1, 1, 1 }; // Fireball, Dice, Legend Dice, Armor
		Scanner in = new Scanner(System.in);
		String monster[] = { "Skeleton", "Bat", "Spider", "Zombies", "Boss Zombie" };
		method.MysteriousGrave();
		String start = in.next();
		if (!start.equals("ujhwgrh846b")) {

			int map[][] = { { 0, 1, 3, 9, 4 }, { 1, 0, 7, 5, 6 }, { 1, 0, 2, 4, 6 }, { 0, 3, 2, 9, 7 },
					{ 2, 3, 1, 4, 8 } };
			// 0 = Skeleton, 1 = Bat, 2 = Spider, 3 = Zombies, 4 = Shop,
			// 5 = Pit, 6 = Land, 7 = Q&A, 8 = Treasure, 9 = Poison Swamp
			for (int r = 0; r <= 30; r++) {
				int n = (int) (Math.random() * 5);
				int d = (int) (Math.random() * 5);
				int o = (int) (Math.random() * 5);
				int m = (int) (Math.random() * 5);
				int temp = map[n][d];
				map[n][d] = map[o][m];
				map[o][m] = temp;
			}

			int y = 0;
			int x = 0;
			System.out.println("You decided to go into the grave.");
			while (x < map.length && y < map.length) {
				if (playerHP <= 0) { // die
					System.out.println("You die, GAME OVER.");
					break;
				}
				method.direction();
				String a = in.next();
				if (a.equals("z")) {
					System.out.printf("HP: %d	Coins: %d\n", playerHP, coins);
					System.out.println("Item:");
					method.PrintItem(potion, antidote, insecticide); // Item
					System.out.println("?. your pocket?	-- ???");
					continue;
				}
				if (a.equals("a"))
					if (y != 0)
						y -= 1;
					else {
						method.PrintBlock();
						continue;
					}
				else if (a.equals("d"))
					if (y < 4)
						y += 1;
					else {
						method.PrintBlock();
						continue;
					}
				else if (a.equals("w"))
					if (x != 0)
						x -= 1;
					else {
						method.PrintBlock();
						continue;
					}
				else if (a.equals("s"))
					if (x < 4)
						x += 1;
					else {
						method.PrintBlock();
						continue;
					}
				else if (!a.equals("z") && !a.equals("a") && !a.equals("d") && !a.equals("w") && !a.equals("s")) {
					System.out.println("You decide to go on a random direction.");
					double random = (Math.random() * 4);
					if (random < 1)
						if (y != 0)
							y -= 1;
						else {
							method.PrintBlock();
							continue;
						}
					else if (random < 2)
						if (y < 4)
							y += 1;
						else {
							method.PrintBlock();
							continue;
						}
					else if (random < 3)
						if (x != 0)
							x -= 1;
						else {
							method.PrintBlock();
							continue;
						}
					else {
						if (x < 4)
							x += 1;
						else {
							method.PrintBlock();
							continue;
						}
					}
				}
				if (map[x][y] == 5) {
					System.out.println("You fall in the pit!!\n" + "You die!!!"); // Pit
					System.out.println();
					System.out.println("GAME OVER");
					break;
				}
				if (batbite > 0) {
					int batATK = 35 + (int) (Math.random() * 10) - armor;
					System.out.println("Bat is following you, you get " + batATK + " damage!");
					playerHP = playerHP - batATK;
					batbite--;
				}
				if (poisoning > 0) {
					playerHP = method.inPoisoning(playerHP, poisoning);
				}
				System.out.println("*Press any key to Search*");
				String s = in.next();
				if (!s.equals("gq4yf632g7ujy5h")) {
					if (map[x][y] == 0) { // Skeleton
						method.PrintSeeMonster(monster[0]);
						for (int skeletonHP = 50; skeletonHP > 1; skeletonHP--) {
							if (poisoning > 0) {
								playerHP = method.inPoisoning(playerHP, poisoning);
							}
							method.PrintChoose();
							int skATK = 7 + (int) (Math.random() * 8) - armor;
							int fire = 0;
							while (!in.hasNextInt()) { // put string
								in.next();
								System.out.println("Please enter a number.");
							}
							int choose = in.nextInt();
							if (choose == 2) { // Flee
								double lucky = (Math.random() * 2);
								if (lucky <= 0.8) {
									method.PrintFlee();
									break;
								} else {
									method.PrintFail();
								}
							}
							if (choose != 1 && choose != 2 && choose != 3) { // wrongNumInput
								double nervous = (Math.random() * 2);
								System.out.println("You are too nervous for this battle.");
								if (nervous < 1) {
									System.out.println("You stiff like a stone, then you have do nothing.");
								} else {
									double run = (Math.random() * 2);
									System.out.println("You run in a random way, ");
									if (run < 1) {
										System.out.println("then you get away the battle.");
										break;
									} else {
										System.out.println("then you get lost.");
										x = (int) (Math.random() * 5);
										y = (int) (Math.random() * 5);
										break;
									}
								}
							}
							if (choose == 3) { // Item
								System.out.println("Choose the item:");
								method.PrintItem(potion, antidote, insecticide);
								while (!in.hasNextInt()) {
									in.next();
									System.out.println("Please enter a number.");
								}
								int use = in.nextInt();
								switch (use) {
								case 1:
									if (potion > 0) {
										method.PrintUse(use);
										potion--;
										playerHP = playerHP + 200;
									} else {
										method.PrintUseZero(use);
									}
									break;
								case 2:
									if (antidote > 0) {
										method.PrintUse(use);
										antidote--;
										poisoning = 0;
									} else {
										method.PrintUseZero(use);
									}
									break;
								case 3:
									if (insecticide > 0) {
										insecticide--;
										method.PrintUse(use);
									} else {
										method.PrintUseZero(use);
									}
									break;
								default:
									method.PrintUse(use);
									double wrong = (Math.random() * 2);
									if (wrong < 1.7) {
										playerHP = method.useWrongNum(wrong, playerHP);
									} else {
										playerHP = method.useWrongNum(wrong, playerHP);
										poisoning = 0;
									}
								}
							}
							if (choose == 1) { // Attack
								double random = Math.random() * 6;
								if (random < 3) {
									playerHP = method.receive(random, playerHP, legend);
								} else {
									skeletonHP = method.attack(skeletonHP, dice, legend, monster[0]);
								}
								if (fireball == 1) { // fireball
									double burn = (Math.random() * 2);
									if (burn > 0.2)
										fire += 2;
									else
										fire += 0;
								}
								if (skeletonHP < 1 && playerHP > 1) { // Moster
																		// Dead
									int drop = 7 + (int) (Math.random() * 11);
									coins = coins + drop;
									method.monsterDead(monster[0], drop);
									break;
								}
							}
							if (skeletonHP >= 1) // Monster Attack
								playerHP = method.monsterAttack(playerHP, skATK, monster[0]);
							if (fire > 0) { // fireball damage
								skeletonHP = skeletonHP - 20;
								System.out.println(monster[0] + " burning by fireball. It get 10 damage!");
								fire--;
							}
							if (playerHP <= 0)
								break;
						}
					} else if (map[x][y] == 1) { // bat
						method.PrintSeeMonster(monster[1]);
						for (int batHP = 60; batHP > 1; batHP--) {
							if (poisoning > 0) {
								playerHP = method.inPoisoning(playerHP, poisoning);
							}
							method.PrintChoose();
							int batATK = 35 + (int) (Math.random() * 11) - armor;
							int fire = 0;
							while (!in.hasNextInt()) { // put String
								in.next();
								System.out.println("Please enter a number.");
							}
							int choose = in.nextInt();
							if (choose == 2) { // Flee
								double lucky = (Math.random() * 2);
								if (lucky < 0.5) {
									method.PrintFlee();
									System.out.println("Bat is following you, you get " + batATK + " damage!");
									playerHP = playerHP - batATK;
									batbite++;
									break;
								} else {
									method.PrintFail();
								}
							}
							if (choose != 1 && choose != 2 && choose != 3) { // wrongNumInput
								double nervous = (Math.random() * 2);
								System.out.println("You are too nervous for this battle.");
								if (nervous < 1) {
									System.out.println("You stiff like a stone, then you have do nothing.");
								} else {
									double run = (Math.random() * 2);
									System.out.println("You run in a random way, ");
									if (run < 1) {
										System.out.println("then you get away the battle.");
										break;
									} else {
										System.out.println("then you get lost.");
										x = (int) (Math.random() * 5);
										y = (int) (Math.random() * 5);
										break;
									}
								}
							}
							if (choose == 3) { // Item
								System.out.println("Choose the item:");
								method.PrintItem(potion, antidote, insecticide);
								while (!in.hasNextInt()) {
									in.next();
									System.out.println("Please enter a number.");
								}
								int use = in.nextInt();
								switch (use) {
								case 1:
									if (potion > 0) {
										method.PrintUse(use);
										potion--;
										playerHP = playerHP + 200;
									} else {
										method.PrintUseZero(use);
									}
									break;
								case 2:
									if (antidote > 0) {
										method.PrintUse(use);
										antidote--;
										poisoning = 0;
									} else {
										method.PrintUseZero(use);
									}
									break;
								case 3:
									if (insecticide > 0) {
										insecticide--;
										method.PrintUse(use);
									} else {
										method.PrintUseZero(use);
									}
									break;
								default:
									method.PrintUse(use);
									double wrong = (Math.random() * 2);
									if (wrong < 1.7) {
										playerHP = method.useWrongNum(wrong, playerHP);
									} else {
										playerHP = method.useWrongNum(wrong, playerHP);
										poisoning = 0;
									}
								}
							}
							if (choose == 1) { // Attack
								double miss = (Math.random() * 2);
								if (miss < 0.8) {
									double random = Math.random() * 6;
									if (random < 3) {
										playerHP = method.receive(random, playerHP, legend);
									} else {
										batHP = method.attack(batHP, dice, legend, monster[1]);
									}
									if (fireball == 1) { // fireball
										double burn = (Math.random() * 2);
										if (burn > 0.2)
											fire += 2;
										else
											fire += 0;
									}
								} else {
									batHP = batHP - 0;
									System.out.println("Bat dodge your attack. Bat get 0 demage!");
								}
								if (batHP < 1 && playerHP > 1) {
									int drop = 25 + (int) (Math.random() * 26);
									coins = coins + drop;
									method.monsterDead(monster[1], drop);
									break;
								}
							}
							if (batHP >= 1)
								playerHP = method.monsterAttack(playerHP, batATK, monster[1]);
							if (fire > 0) { // fireball damage
								batHP = batHP - 20;
								System.out.println(monster[1] + " burning by fireball. It get 10 damage!");
								fire--;
							}
							if (playerHP <= 0)
								break;
						}
					} else if (map[x][y] == 2) { // Spider
						method.PrintSeeMonster(monster[2]);
						for (int spiderHP = 100; spiderHP > 1; spiderHP--) {
							int fire = 0;
							if (poisoning > 0) {
								playerHP = method.inPoisoning(playerHP, poisoning);
							}
							if (sPcount == 1 && babySpider != 0) {
								System.out.println("Baby Spider bite you 20 demage!");
								System.out.println();
								playerHP = playerHP - 20;
							}
							if (sPcount == 2 && babySpider != 0) {
								System.out.println("Baby Spider bite you 20 demage!");
								System.out.println();
								playerHP = playerHP - 20;
							}
							if (sPcount > 2 && babySpider != 0) {
								if (sPcount == 3) {
									System.out.println("More Baby Spider are biting you.");
								}
								System.out.println("Baby Spider bite you 50 demage!");
								System.out.println();
								playerHP = playerHP - 50;
								babySpider--;
							}
							double stopAction = (Math.random() * 2);
							if (stopAction > 1.3) { // stop Action
								System.out.println("Spider spew silk on you!\nYou can't move at this round.");
								if (poisoning > 0) {
									playerHP = method.inPoisoning(playerHP, poisoning);
								}
								if (playerHP <= 0)
									break;
								if (fireball == 1) {
									double burn = (Math.random() * 2);
									if (burn > 0.2)
										fire += 2;
									else
										fire += 0;
								}
							} else {
								method.PrintChoose();
								while (!in.hasNextInt()) { // put String
									in.next();
									System.out.println("Please enter a number.");
								}
								int choose = in.nextInt();
								if (choose == 2) { // Flee
									double lucky = (Math.random() * 2);
									if (lucky < 0.8) {
										method.PrintFlee();
										sPcount = 0;
										babySpider = 0;
										break;
									} else {
										method.PrintFail();
									}
								}
								if (choose != 1 && choose != 2 && choose != 3) { // wrongNumInput
									double nervous = (Math.random() * 2);
									System.out.println("You are too nervous for this battle.");
									if (nervous < 1) {
										System.out.println("You stiff like a stone, then you have do nothing.");
									} else {
										double run = (Math.random() * 2);
										System.out.println("You run in a random way, ");
										sPcount = 0;
										babySpider = 0;
										if (run < 1) {
											System.out.println("then you get away the battle.");
											break;
										} else {
											System.out.println("then you get lost.");
											x = (int) (Math.random() * 5);
											y = (int) (Math.random() * 5);
											break;
										}
									}
								}
								if (choose == 3) { // Item
									System.out.println("Choose the item:");
									method.PrintItem(potion, antidote, insecticide);
									while (!in.hasNextInt()) {
										in.next();
										System.out.println("Please enter a number.");
									}
									int use = in.nextInt();
									switch (use) {
									case 1:
										if (potion > 0) {
											method.PrintUse(use);
											potion--;
											playerHP = playerHP + 200;
										} else {
											method.PrintUseZero(use);
										}
										break;
									case 2:
										if (antidote > 0) {
											method.PrintUse(use);
											antidote--;
											poisoning = 0;
										} else {
											method.PrintUseZero(use);
										}
										break;
									case 3:
										if (insecticide > 0) {
											insecticide--;
											if (sPcount > 0) {
												System.out.println("You use Insecticide, all Baby Spider have gone.");
												babySpider = 0;
												sPcount = 0;
											} else {
												method.PrintUse(use);
											}
										} else {
											method.PrintUseZero(use);
										}
										break;
									default:
										method.PrintUse(use);
										double wrong = (Math.random() * 2);
										if (wrong < 1.7) {
											playerHP = method.useWrongNum(wrong, playerHP);
										} else {
											playerHP = method.useWrongNum(wrong, playerHP);
											poisoning = 0;
										}
									}
								}
								if (playerHP <= 0)
									break;
								if (choose == 1) { // Attack
									double random = Math.random() * 6;
									if (random < 3) {
										playerHP = method.receive(random, playerHP, legend);
										if (playerHP <= 0)
											break;
									} else {
										spiderHP = method.attack(spiderHP, dice, legend, monster[2]);
									}
									if (fireball == 1) { // fireball
										double burn = (Math.random() * 2);
										if (burn > 0.2)
											fire += 2;
										else
											fire += 0;
									}
								}
							}
							if (spiderHP < 1 && playerHP > 1) {
								int drop = 30 + (int) (Math.random() * 51);
								coins = coins + drop;
								method.monsterDead(monster[2], drop);
								System.out.println("All Baby Spider gone.");
								babySpider = 0;
								sPcount = 0;
								break;
							}
							if (spiderHP >= 1) {
								System.out.println("Spider let out the Baby Spider bite you.");
								babySpider += 2;
								sPcount++;
							}
							if (fire > 0) { // fireball damage
								spiderHP = spiderHP - 20;
								System.out.println(monster[2] + " burning by fireball. It get 10 damage!");
								fire--;
							}
						}
					} else if (map[x][y] == 3) { // Zombies
						method.PrintSeeMonster(monster[3]);
						for (int zombiesHP = 240; zombiesHP > 1; zombiesHP--) {
							method.PrintChoose();
							int zbATK = 120 + (int) (Math.random() * 41) - armor;
							int fire = 0;
							while (!in.hasNextInt()) { // put String
								in.next();
								System.out.println("Please enter a number.");
							}
							int choose = in.nextInt();
							if (choose == 2) {
								double lucky = (Math.random() * 2);
								if (lucky < 1.5) {
									method.PrintFlee();
									break;
								} else {
									method.PrintFail();
								}
							}
							if (choose != 1 && choose != 2 && choose != 3) { // wrongNumInput
								double nervous = (Math.random() * 2);
								System.out.println("You are too nervous for this battle.");
								if (nervous < 1) {
									System.out.println("You stiff like a stone, then you have do nothing.");
								} else {
									double run = (Math.random() * 2);
									System.out.println("You run in a random way, ");
									if (run < 1) {
										System.out.println("then you get away the battle.");
										break;
									} else {
										System.out.println("then you get lost.");
										x = (int) (Math.random() * 5);
										y = (int) (Math.random() * 5);
										break;
									}
								}
							}
							if (choose == 3) {
								System.out.println("Choose the item:");
								method.PrintItem(potion, antidote, insecticide); // Item
								while (!in.hasNextInt()) {
									in.next();
									System.out.println("Please enter a number.");
								}
								int use = in.nextInt();
								switch (use) {
								case 1:
									if (potion > 0) {
										method.PrintUse(use);
										potion--;
										playerHP = playerHP + 200;
									} else {
										method.PrintUseZero(use);
									}
									break;
								case 2:
									if (antidote > 0) {
										method.PrintUse(use);
										antidote--;
										poisoning = 0;
									} else {
										method.PrintUseZero(use);
									}
									break;
								case 3:
									if (insecticide > 0) {
										insecticide--;
										method.PrintUse(use);
									} else {
										method.PrintUseZero(use);
									}
									break;
								default:
									method.PrintUse(use);
									double wrong = (Math.random() * 2);
									if (wrong < 1.7) {
										playerHP = method.useWrongNum(wrong, playerHP);
									} else {
										playerHP = method.useWrongNum(wrong, playerHP);
										poisoning = 0;
									}
								}
							}
							if (zombiesHP >= 1) {
								double dodge = (Math.random() * 4);
								if (dodge < 2.8) {
									playerHP = method.monsterAttack(playerHP, zbATK, monster[3]);
									double toxin = (Math.random() * 2);
									if (toxin < 1.4)
										poisoning += 4;
								} else {
									System.out.println("You had dodged Zombies attack!!");
								}
							}
							if (poisoning > 0) {
								playerHP = method.inPoisoning(playerHP, poisoning);
							}
							if (playerHP <= 0)
								break;
							if (choose == 1) {
								double random = Math.random() * 6;
								if (random < 3) {
									playerHP = method.receive(random, playerHP, legend);
									if (playerHP <= 0)
										break;
								} else {
									zombiesHP = method.attack(zombiesHP, dice, legend, monster[3]);
								}
								if (fireball == 1) {
									double burn = (Math.random() * 2);
									if (burn > 0.2)
										fire += 2;
									else
										fire += 0;
								}
								if (zombiesHP < 1 && playerHP > 1) {
									int drop = 40 + (int) (Math.random() * 81);
									coins = coins + drop;
									method.monsterDead(monster[3], drop);
									break;
								}
							}
							if (fire > 0) {
								zombiesHP = zombiesHP - 20;
								System.out.println(monster[3] + " burning by fireball. It get 10 damage!");
								fire--;
							}
						}
					} else if (map[x][y] == 4) { // Shop
						method.rainbow();
						String item[] = { "Potion", "Fireball", "Magic Dice", "Antidote", "Insecticide", "Legend Dice",
								"Armor" };

						System.out.println("What color would you like to buy? ");
						String color = in.next();
						int price = 10 + (int) (Math.random() * 31);
						if (price > coins) {
							System.out.println("Sorry, you have not enought coins.");
						} else {
							switch (color) {
							case "red":
							case "Red":
							case "RED":
								System.out.println("You use "+price+" coins.\nYou get " + item[0]);
								potion++;
								break;
							case "orange":
							case "Orange":
							case "ORANGE":
								if (stock[0] == 0) {
									System.out.println("You use "+price+" coins.\n"+item[2] + " has no inventory, but you can have a " + item[0]);
									potion++;
									break;
								} else {
									System.out.println("You use "+price+" coins.\nYou get " + item[1]);
									fireball++;
									stock[0]--;
									break;
								}
							case "yellow":
							case "Yellow":
							case "YELLOW":
								if (stock[1] == 0) {
									System.out.println("You use "+price+" coins.\n"+item[2] + " has no inventory, but you can have a " + item[0]);
									potion++;
									break;
								} else {
									System.out.println("You use "+price+" coins.\nYou get " + item[2]);
									dice += 40;
									stock[1]--;
									break;
								}
							case "green":
							case "Green":
							case "GREEN":
								System.out.println("You use "+price+" coins.\nYou get " + item[3]);
								antidote++;
								break;
							case "blue":
							case "Blue":
							case "BLUE":
								System.out.println("You use "+price+" coins.\nYou get " + item[4]);
								insecticide++;
								break;
							case "indigo":
							case "Indigo":
							case "INDIGO":
								double ramdom = (Math.random() * 2);
								if (ramdom < 1.2) {
									System.out.println("You use "+price+" coins.\nYou get " + item[0]);
									potion++;
									break;
								} else {
									if (stock[2] == 0) {
										System.out
												.println("You use "+price+" coins.\n"+item[5] + " has no inventory, but you can have a " + item[3]);
										antidote++;
										break;
									} else {
										System.out.println("You use "+price+" coins.\nYou get " + item[5]);
										legend += 200;
										stock[2]--;
										break;
									}
								}
							case "violet":
							case "Violet":
							case "VIOLET":
								if (stock[3] == 0) {
									System.out.println("You use "+price+" coins.\n"+item[6] + " has no inventory, but you can have a " + item[0]);
									potion++;
									break;
								} else {
									System.out.println("You use "+price+" coins.\nYou get " + item[6]);
									armor += 40;
									stock[3]--;
									break;
								}
							default:
								System.out.println("Sorry, it's not a color of rainbow.");
							}
						}
					} else if (map[x][y] == 6) {
						double land = (Math.random() * 2); // Land
						if (land > 1.4) {
							System.out.println("You get Potion.");
							potion++;
						} else if (land > 1.1) {
							System.out.println("You get Antidote.");
							antidote++;
						} else if (land > 0.9) {
							if (armor == 0) {
								System.out.println("You get Armor.");
								armor += 40;
							} else {
								System.out.println("You get Insecticide.");
								insecticide++;
							}
						} else
							System.out.println("There have nothing.");
					} else if (map[x][y] == 7) {
						int question = (int) (Math.random() * 9);
						String answer;
						switch (question) {
						case 0:
							System.out.println("What is the Capital of Peru?");
							answer = in.next();
							if (answer.equals("Lima") || answer.equals("lima") || answer.equals("LIMA")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 1:
							System.out.println("What is the Capital of Japan?");
							answer = in.next();
							if (answer.equals("Tokyo") || answer.equals("tokyo") || answer.equals("TOKYO")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 2:
							System.out.println("What is the Capital of Sweden?");
							answer = in.next();
							if (answer.equals("Stockholm") || answer.equals("stockholm")
									|| answer.equals("STOCKHOLM")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 3:
							System.out.println("What is the Capital of United States?");
							answer = in.next();
							if (answer.equals("Washington") || answer.equals("washington")
									|| answer.equals("WASHINGTON")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 4:
							System.out.println("What is the degree of absolute zero on the Celsius scale?");
							answer = in.next();
							if (answer.equals("-273.15") || answer.equals("-273") || answer.equals("-273C")
									|| answer.equals("-273.15C") || answer.equals("-273.15 C")
									|| answer.equals("-273 C")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 5:
							System.out.println("What color of the flame when you burn the Sodium(Na)?");
							answer = in.next();
							if (answer.equals("Golden") || answer.equals("golden") || answer.equals("GOLDEN")
									|| answer.equals("Golden Yellow") || answer.equals("golden yellow")
									|| answer.equals("GOLDEN YELLOW")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 6:
							System.out.println("What is the symbol of Lead?");
							answer = in.next();
							if (answer.equals("Pb")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 7:
							System.out.println("What is the symbol of Potassium?");
							answer = in.next();
							if (answer.equals("K")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						case 8:
							System.out.println("How many letters in the word \"sup___li___rag___cexpi___ocious\"?");
							System.out.println("A. 34\n" + "B. 28\n" + "C. 31\n" + "D. 22");
							answer = in.next();
							if (answer.equals("A") || answer.equals("a") || answer.equals("34")
									|| answer.equals("A. 34")) {
								potion = method.correct(potion);
								break;
							} else {
								playerHP = method.wrong(playerHP);
								break;
							}
						}
					} else if (map[x][y] == 9) { // Poison Swamp
						System.out.println(
								"You fall in the Poison Swamp, you are in poisoning!\n" + "You get 20 damage!");
						playerHP = playerHP - 20;
						poisoning += 4;
					} else if (map[x][y] == 8) { // Treasure
						double wakeUp = (Math.random() * 2);
						if (wakeUp < 1) {
							method.treasure();
							System.out.println("Hurray! You find the treasure!!");
							break;
						} else { // Boss Zombies
							System.out.println(
									"Oh no!! You find the treasure but your footsteps woke up the Zombies Boss!");
							for (int bossHP = 840; bossHP > 1; bossHP--) {
								int bossATK = 180 + (int) (Math.random() * 61) - armor;
								int fire = 0;
								if (sPcount == 1 && babySpider != 0) {
									System.out.println("Baby Spider bite you 20 demage!");
									System.out.println();
									playerHP = playerHP - 20;
								}
								if (sPcount == 2 && babySpider != 0) {
									System.out.println("Baby Spider bite you 20 demage!");
									System.out.println();
									playerHP = playerHP - 20;
								}
								if (sPcount > 2 && babySpider != 0) {
									if (sPcount == 3) {
										System.out.println("More Baby Spider are biting you.");
									}
									System.out.println("Baby Spider bite you 50 demage!");
									System.out.println();
									playerHP = playerHP - 50;
									babySpider--;
								}
								System.out.println("PlayerHP: " + playerHP);
								method.PrintChoose();
								while (!in.hasNextInt()) {
									in.next();
									System.out.println("Please enter a number.");
								}
								int choose = in.nextInt();
								if (choose == 2) {
									double lucky = (Math.random() * 2);
									if (lucky < 1.6) {
										method.PrintFlee();
										babySpider = 0;
										sPcount = 0;
										break;
									} else {
										method.PrintFail();
									}
								}
								if (choose != 1 && choose != 2 && choose != 3) { // wrong
																					// number
																					// input
									double nervous = (Math.random() * 2);
									System.out.println("You are too nervous for this battle.");
									if (nervous < 1) {
										System.out.println("You stiff like a stone, then you have do nothing.");
									} else {
										double run = (Math.random() * 2);
										babySpider = 0;
										sPcount = 0;
										System.out.println("You run in a random way, ");
										if (run < 1) {
											System.out.println("then you get away the battle.");
											break;
										} else {
											System.out.println("then you get lost.");
											x = (int) (Math.random() * 5);
											y = (int) (Math.random() * 5);
											break;
										}
									}
								}
								if (choose == 3) {
									System.out.println("Choose the item:");
									method.PrintItem(potion, antidote, insecticide); // Item
									while (!in.hasNextInt()) {
										in.next();
										System.out.println("Please enter a number.");
									}
									int use = in.nextInt();
									switch (use) {
									case 1:
										if (potion > 0) {
											method.PrintUse(use);
											potion--;
											playerHP = playerHP + 200;
										} else {
											method.PrintUseZero(use);
										}
										break;
									case 2:
										if (antidote > 0) {
											method.PrintUse(use);
											antidote--;
											poisoning = 0;
										} else {
											method.PrintUseZero(use);
										}
										break;
									case 3:
										if (insecticide > 0) {
											insecticide--;
											if (sPcount > 0) {
												System.out.println("You use Insecticide, all baby Spider have gone.");
												babySpider = 0;
												sPcount = 0;
											} else {
												method.PrintUse(use);
											}
										} else {
											method.PrintUseZero(use);
										}
										break;
									default:
										method.PrintUse(use);
										double wrong = (Math.random() * 2);
										if (wrong < 1.7) {
											playerHP = method.useWrongNum(wrong, playerHP);
										} else {
											playerHP = method.useWrongNum(wrong, playerHP);
											poisoning = 0;
										}
									}
								}
								if (bossHP >= 1) {
									double dodge = (Math.random() * 4);
									if (dodge < 2.6) {
										playerHP = method.monsterAttack(playerHP, bossATK, monster[4]);
										double toxin = (Math.random() * 2);
										if (toxin < 1.6)
											poisoning += 4;
									} else {
										System.out.println("You had dodged Boss Zombies attack!!");
									}
								}
								if (poisoning > 0) {
									playerHP = method.inPoisoning(playerHP, poisoning);
								}
								if (playerHP <= 0)
									break;
								if (choose == 1) {
									double miss = (Math.random() * 2);
									if (miss < 1.6) {
										double random = Math.random() * 6;
										if (random < 3) {
											playerHP = method.receive(random, playerHP, legend);
										} else {
											bossHP = method.attack(bossHP, dice, legend, monster[4]);
										}
										if (fireball == 1) {
											double burn = (Math.random() * 2);
											if (burn > 0.2)
												fire += 2;
											else
												fire += 0;
										}
									} else {
										bossHP = bossHP - 0;
										System.out
												.println("Boss Zombies dodge your attack.\nBoss Zombies get 0 demage!");
									}
									if (bossHP < 1 && playerHP > 1) {
										int drop = 500 + (int) (Math.random() * 501);
										coins = coins + drop;
										method.monsterDead(monster[4], drop);
										method.treasure();
										System.out.println("You win!! You get the treasure!");
										System.exit(0);
									}
								}
								if (bossHP >= 1) {
									double callSpider = Math.random() * 2;
									if (callSpider < 1) {
										System.out.println(
												"Boss Zombies call the Baby Spider bite you.");
										sPcount++;
										babySpider += 2;
									}
								}
								if (fire > 0) {
									bossHP = bossHP - 20;
									System.out.println(monster[4] + " burning by fireball. It get 10 damage!");
									fire--;
								}
							}
						}
					}
				}
			}
		}
	}
}
