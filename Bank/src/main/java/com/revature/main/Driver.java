package com.revature.main;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.*;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int value = 0;
		int currentAccountIndex = 0;
		boolean loggedIn = false;
		System.out.println("Welcome to the Bank");
	mainmenu:
		while(true) {
			value = 0;
			currentAccountIndex = 0;
			UserDao ud = new UserDaoImpl();
			AccountDao ad = new AccountDaoImpl();
			User thisUser = null;
			loggedIn = false;
			while(!loggedIn) {
				int loginMenuOption = getMainMenuOption();
				String username = "";
				String password = "";
				String firstname = "";
				String lastname = "";
				switch(loginMenuOption) {
				/*  LOGIN  */
				case 1:
					System.out.print("Please enter your username: ");
					username = input.nextLine();
					// only use first word
					if (username.contains(" ")) {
						username = username.substring(0, username.indexOf(" "));
					}
					if (username.equals("") || ud.isAvailable(username)) {
						System.out.println("Sorry, that username was not found.");
						break;
					} else {
						while(true) {
							System.out.print("Please enter your password: ");
							password = input.nextLine();
							if (!username.equals("")) {
								thisUser = ud.login(username, password);
							}
							if (username.equals("") || thisUser == null) {
								loggedIn = false;
								System.out.println("Sorry, that password didn't work.");
								// if the want to quit go to mainmenu
								if (tryAgain()) {
									continue;
								} else {
									continue mainmenu;
								}
							} else {
								loggedIn = true;
								break;
							}
						}
						System.out.println("You are now logged in as \"" + username + "\"");
					}
					break;
				/*  REGISTER  */
				case 2:
					while(true) {
						System.out.print("Please enter a username: ");
						username = input.nextLine();
						// only use first word
						if (username.contains(" ")) {
							username = username.substring(0, username.indexOf(" "));
						}
						if (username.equals("") || !ud.isAvailable(username)) {
							System.out.println("Sorry, that username is taken or otherwise invalid.");
							// if the want to quit go to mainmenu
							if (tryAgain()) {
								continue;
							} else {
								loggedIn = false;
								continue mainmenu;
							}
						} else {
							break;
						}
					}
					while(true) {
						System.out.print("Please enter a password: ");
						password = input.nextLine();
						// Do not accept blank passwords
						if (password.equals("")) {
							System.out.println("Sorry, that is not a valid password.");
							if (tryAgain()) {
								continue;
							} else {
								loggedIn = false;
								continue mainmenu;
							}
						} else {
							break;
						}
					}
					
					while(true) {
						System.out.print("Please enter a first name: ");
						firstname = input.nextLine();
						// Do not accept blank names
						if (firstname.equals("")) {
							System.out.println("Sorry, that is not a valid name.");
							if (tryAgain()) {
								continue;
							} else {
								loggedIn = false;
								continue mainmenu;
							}
						} else {
							break;
						}
					}
					
					while(true) {
						System.out.print("Please enter a last name: ");
						lastname = input.nextLine();
						// Do not accept blank passwords
						if (lastname.equals("")) {
							System.out.println("Sorry, that is not a valid name.");
							if (tryAgain()) {
								continue;
							} else {
								loggedIn = false;
								continue mainmenu;
							}
						} else {
							break;
						}
					}
					
					
					thisUser = ud.addUser(username, password, firstname, lastname);
					if (thisUser == null) {
						System.out.println("Sorry, your user could not be created.");
						loggedIn = false;
						continue mainmenu;
					} else {
						System.out.println();
						System.out.println("You now are logged in as \"" + username + "\"");
						loggedIn = true;
					}
					break;
				} // End login menu option switch
			}
		accountlist:
			while(loggedIn) {
				ad.getAccounts(thisUser);
				currentAccountIndex = 0;
				/*  NORMAL USERS  */
				if (thisUser.getUserType().equals("USER")) {
					// Normal user must choose an account to access
					int totalAccounts = thisUser.getAccounts().size();
					// If they do not have an account offer to create one
					if (totalAccounts < 1) {
						System.out.println("No accounts were found.");
						int noAccountOption = getNoAccountOption(thisUser);
						switch(noAccountOption) {
						/*  NEW ACCOUNT  */
						case 1:
							int newAccountOption = getNewAccountOption(thisUser);
							String accountType = "";
							switch (newAccountOption) {
							// Checking option
							case 1:
								accountType = "CHECKING";
								break;
							// Savings option
							case 2:
								accountType = "SAVINGS";
								break;
							// Switch account option
							case 3:
								continue accountlist;
							// Logout option
							case 4:
								loggedIn = false;
								continue mainmenu;
							default:
								continue accountlist;
							}
							String accountName = "";
							while(true) {
								System.out.print("Please enter a name for the account: ");
								accountName = input.nextLine();
								// Do not accept blank passwords
								if (accountName.equals("")) {
									System.out.println("Sorry, that is not a valid name.");
									if (tryAgain()) {
										continue;
									} else {
										continue accountlist;
									}
								} else {
									break;
								}
							}
							if (ad.addAccount(thisUser, accountType, accountName)) {
								// Set the current account to the only account they have now
								totalAccounts = thisUser.getAccounts().size();
								currentAccountIndex = totalAccounts - 1;
							// If the insert fails, return them to the decision to create one
							} else {
								System.out.println("Sorry, the account was not created.");
								continue accountlist;
							}
							break;
						/*  LOGOUT  */
						case 2:
							loggedIn = false;
							continue accountlist;
						}
					}else if (totalAccounts > 0) {
						// currentAccount is index starting at 0
						currentAccountIndex = getAccountList(thisUser);
						// if the index == total it is out of the array bounds until a new account is added
						/*  NEW ACCOUNT  */
						if (currentAccountIndex == totalAccounts) {
							int newAccountOption = getNewAccountOption(thisUser);
							String accountType = "";
							switch (newAccountOption) {
							// Checking option
							case 1:
								accountType = "CHECKING";
								break;
							// Savings option
							case 2:
								accountType = "SAVINGS";
								break;
							// Switch account option
							case 3:
								continue accountlist;
							// Logout option
							case 4:
								loggedIn = false;
								continue mainmenu;
							default:
								continue accountlist;
							}
							String accountName = "";
							while(true) {
								System.out.print("Please enter a name for the account: ");
								accountName = input.nextLine();
								// Do not accept blank passwords
								if (accountName.equals("")) {
									System.out.println("Sorry, that is not a valid name.");
									if (tryAgain()) {
										continue;
									} else {
										continue accountlist;
									}
								} else {
									break;
								}
							}
							if (ad.addAccount(thisUser, accountType, accountName)) {
								// Set the current account to the new account
								totalAccounts = thisUser.getAccounts().size();
								currentAccountIndex = totalAccounts - 1;
							// If the insert fails, return them to the decision to create one
							} else {
								System.out.println("Sorry, the account was not created.");
								continue accountlist;
							}
						// if the index is one over total then they chose the last option to logout
						/*  LOGOUT  */
						} else if (currentAccountIndex == totalAccounts + 1) {
							loggedIn = false;
							continue mainmenu;
						}
					} // End none vs many accounts
					/*  ACCOUNT OPTIONS  */
					while(true) {
						// Normal user must choose what to do with the account
						int accountAction = getAccountAction(currentAccountIndex, thisUser);
						float amount = 0f;
						switch (accountAction) {
						// Withdraw option
						case 1:
							amount = getWithdrawAmount(thisUser.getAccounts().get(currentAccountIndex).getBalance());
							if (!ad.withdrawAmount(amount, currentAccountIndex, thisUser)) {
								System.out.println("Sorry, the withdraw was not successful.");
							}
							break;
						// Deposit option
						case 2:
							amount = getDepositAmount();
							if (!ad.depositAmount(amount, currentAccountIndex, thisUser)) {
								System.out.println("Sorry, the deposit was not successful.");
							}
							break;
						// Close account option
						case 3:
							if (thisUser.getAccounts().get(currentAccountIndex).getBalance() > 0.0) {
								System.out.println("Please withdraw the contents of the account before closing it.");
							} else {
								if(ad.closeAccount(currentAccountIndex, thisUser)) {
									totalAccounts = thisUser.getAccounts().size();
									continue accountlist;
								} else {
									System.out.println("Sorry, the account was not closed successfully.");
								}
							}
							break;
						// Switch account option
						case 4:
							continue accountlist;
						// Logout option
						case 5:
							loggedIn = false;
							continue mainmenu;
						}
					}
				/*  SUPERUSERS  */
				} else if(thisUser.getUserType().equals("SUPERUSER")) {
					int currentUserIndex = 0;
					int totalUsers = 0;
				superuserlist:
					while(true) {
						if (ud.getAllUsers(thisUser)) {
							totalUsers = thisUser.getUsers().size();
							currentUserIndex = getUserList(thisUser);
							// If the index is the total, then they chose the The next option after user list to create new user
							/*  REGISTER  */
							if (currentUserIndex == totalUsers) {
								String username = "";
								String password = "";
								String firstname = "";
								String lastname = "";
								while(true) {
									System.out.print("Please enter a username: ");
									username = input.nextLine();
									// only use first word
									if (username.contains(" ")) {
										username = username.substring(0, username.indexOf(" "));
									}
									if (username.equals("") || !ud.isAvailable(username)) {
										System.out.println("Sorry, that username is taken or otherwise invalid.");
										// if the want to quit go to mainmenu
										if (tryAgain()) {
											continue;
										} else {
											continue superuserlist;
										}
									} else {
										break;
									}
								}
								while(true) {
									System.out.print("Please enter a password: ");
									password = input.nextLine();
									// Do not accept blank passwords
									if (password.equals("")) {
										System.out.println("Sorry, that is not a valid password.");
										if (tryAgain()) {
											continue;
										} else {
											continue superuserlist;
										}
									} else {
										break;
									}
								}
								
								while(true) {
									System.out.print("Please enter a first name: ");
									firstname = input.nextLine();
									// Do not accept blank names
									if (firstname.equals("")) {
										System.out.println("Sorry, that is not a valid name.");
										if (tryAgain()) {
											continue;
										} else {
											loggedIn = false;
											continue superuserlist;
										}
									} else {
										break;
									}
								}
								
								while(true) {
									System.out.print("Please enter a last name: ");
									lastname = input.nextLine();
									// Do not accept blank passwords
									if (lastname.equals("")) {
										System.out.println("Sorry, that is not a valid name.");
										if (tryAgain()) {
											continue;
										} else {
											loggedIn = false;
											continue superuserlist;
										}
									} else {
										break;
									}
								}
								
								
								User tempUser = ud.addUser(username, password, firstname, lastname);
								if (tempUser == null) {
									System.out.println("Sorry, your user could not be created.");
									continue superuserlist;
								} else {
									System.out.println();
									System.out.println(username + " has been created.");
									thisUser.getUsers().add(tempUser);
									totalUsers = thisUser.getUsers().size();
									currentUserIndex = totalUsers - 1;
								}
							// if the index is one over total then they chose the last option to logout of admin
							/*  LOGOUT  */
							} else if (currentUserIndex == totalUsers + 1) {
								loggedIn = false;
								continue mainmenu;
							// If the super user chose a user from the list they can now access the user
							/*  USER OPTIONS  */
							} else {
							superuseroptions:
								while(true) {
									int superMenuOption = getSuperMenuOption(thisUser.getUsers().get(currentUserIndex));
									switch(superMenuOption) {
									// View this users Accounts option provides means to make transactions as a teller
									/*  USER ACCOUNTS  */
									case 1:
										int totalAccounts = 0;
										currentAccountIndex = 0;
									superaccountlist:
										while(true) {
											if (ad.getAccounts(thisUser.getUsers().get(currentUserIndex))) {
												totalAccounts = thisUser.getUsers().get(currentUserIndex).getAccounts().size();
												// If they do not have an account offer to create one
												if (totalAccounts < 1) {
													System.out.println("No accounts were found.");
													// Super user can create accounts
													int noAccountOption = getNoAccountOption(thisUser.getUsers().get(currentUserIndex));
													switch(noAccountOption) {
													// Create account option
													/*  NEW ACCOUNT  */
													case 1:
														int newAccountOption = getNewAccountOption(thisUser.getUsers().get(currentUserIndex));
														String accountType = "";
														switch (newAccountOption) {
														// Checking option
														case 1:
															accountType = "CHECKING";
															break;
														// Savings option
														case 2:
															accountType = "SAVINGS";
															break;
														// Switch account  = return to user account list
														/*  SWITCH ACCOUNT  */
														case 3:
															continue superaccountlist;
														// Logout option = go back to user profile
														/*  LOGOUT  */
														case 4:
															continue superuseroptions;
														default:
															continue mainmenu;
														} // End new accounts options switch
														String accountName = "";
														while(true) {
															System.out.print("Please enter a name for the account: ");
															accountName = input.nextLine();
															// Do not accept blank passwords
															if (accountName.equals("")) {
																System.out.println("Sorry, that is not a valid name.");
																if (tryAgain()) {
																	continue;
																} else {
																	continue superaccountlist;
																}
															} else {
																break;
															}
														}
														if (ad.addAccount(thisUser.getUsers().get(currentUserIndex), accountType, accountName)) {
															// Set the current account to the new account
															totalAccounts = thisUser.getUsers().get(currentUserIndex).getAccounts().size();
															currentAccountIndex = totalAccounts - 1;
														// If the insert fails, return them to the decision to create one
														} else {
															System.out.println("Sorry, the account was not created.");
															continue superaccountlist;
														}
														break;
													// Logout option = go back to user list
													/*  LOGOUT  */
													case 2:
														currentUserIndex = 0;
														continue superuserlist;
													} // End no account option list
												} else if (totalAccounts > 0) {
													// currentAccount is index starting at 0
													currentAccountIndex = getAccountList(thisUser.getUsers().get(currentUserIndex));
													// if the index == total it is out of the array bounds until a new account is added
													/*  NEW ACCOUNT  */
													if (currentAccountIndex == totalAccounts) {
														int newAccountOption = getNewAccountOption(thisUser.getUsers().get(currentUserIndex));
														String accountType = "";
														switch (newAccountOption) {
														// Checking option
														case 1:
															accountType = "CHECKING";
															break;
														// Savings option
														case 2:
															accountType = "SAVINGS";
															break;
														// Switch account option = return to users account list
														case 3:
															continue superaccountlist;
														// Logout option = return to user profile
														case 4:
															continue superuseroptions;
														default:
															continue mainmenu;
														}
														String accountName = "";
														while(true) {
															System.out.print("Please enter a name for the account: ");
															accountName = input.nextLine();
															// Do not accept blank passwords
															if (accountName.equals("")) {
																System.out.println("Sorry, that is not a valid name.");
																if (tryAgain()) {
																	continue;
																} else {
																	continue superaccountlist;
																}
															} else {
																break;
															}
														}
														if (ad.addAccount(thisUser.getUsers().get(currentUserIndex), accountType, accountName)) {
															// Set the current account to the new account
															totalAccounts = thisUser.getUsers().get(currentUserIndex).getAccounts().size();
															currentAccountIndex = totalAccounts - 1;
														// If the insert fails, return to the users account list
														} else {
															System.out.println("Sorry, the account was not created.");
															continue superaccountlist;
														}
													// if the index is one over total then they chose the last option to logout = return to user options
													} else if (currentAccountIndex == totalAccounts + 1) {
														continue superuseroptions;
													}
												} // End none vs many
												
												/*  ACCOUNT OPTIONS  */
												while(true) {
													// Normal user must choose what to do with the account
													int accountAction = getAccountAction(currentAccountIndex, thisUser.getUsers().get(currentUserIndex));
													float amount = 0f;
													switch (accountAction) {
													// Withdraw option
													case 1:
														amount = getWithdrawAmount(thisUser.getUsers().get(currentUserIndex).getAccounts().get(currentAccountIndex).getBalance());
														if (!ad.withdrawAmount(amount, currentAccountIndex, thisUser.getUsers().get(currentUserIndex))) {
															System.out.println("Sorry, the withdraw was not successful.");
														}
														break;
													// Deposit option
													case 2:
														amount = getDepositAmount();
														if (!ad.depositAmount(amount, currentAccountIndex, thisUser.getUsers().get(currentUserIndex))) {
															System.out.println("Sorry, the deposit was not successful.");
														}
														break;
													// Close account option
													case 3:
														if (thisUser.getUsers().get(currentUserIndex).getAccounts().get(currentAccountIndex).getBalance() > 0.0) {
															System.out.println("Please withdraw the contents of the account before closing it.");
														} else {
															if(ad.closeAccount(currentAccountIndex, thisUser.getUsers().get(currentUserIndex))) {
																totalAccounts = thisUser.getUsers().get(currentUserIndex).getAccounts().size();
																currentAccountIndex = 0;
																continue superaccountlist;
															} else {
																System.out.println("Sorry, the account was not closed successfully.");
															}
														}
														break;
													// Switch account option
													case 4:
														continue superaccountlist;
													// Logout option
													case 5:
														continue superuseroptions;
													}
												} // End ACCOUNT OPTIONS
											} else {
												System.out.println("Sorry, accounts for this user could not be retrieved");
												continue superuserlist;
											} // End if the accounts for this user were obtained
										} // End superuseraccounts while
									// Update this user option
									/*  USER PROFILE  */
									case 2:
									userprofile:
										while(true) {
											int userAction = getUserAction(thisUser.getUsers().get(currentUserIndex));
											String username = "";
											String password = "";
											String firstname = "";
											String lastname = "";
											switch (userAction) {
											// Update username
											case 1:
												while(true) {
													System.out.println("Current username is " + thisUser.getUsers().get(currentUserIndex).getUsername() + ".");
													System.out.print("Please enter a new username: ");
													username = input.nextLine();
													// only use first word
													if (username.contains(" ")) {
														username = username.substring(0, username.indexOf(" "));
													}
													if (username.equals("") || !ud.isAvailable(username)) {
														System.out.println("Sorry, that username is taken or otherwise invalid.");
														// if the want to quit go to mainmenu
														if (tryAgain()) {
															continue;
														} else {
															continue superuserlist;
														}
													} else {
														break;
													}
												}
												try {
													ud.updateProfile("USERNAME", username, thisUser.getUsers().get(currentUserIndex)); 
													thisUser.getUsers().get(currentUserIndex).setUsername(username);
													System.out.println("The username is now " + username + ".");
												} catch (SQLProfileUpdateException s) {
													System.out.println("Sorry, the username was not changed.");
												}
												break;
											// Update password
											case 2:
												while(true) {
													System.out.print("Please enter a new password: ");
													password = input.nextLine();
													// Do not accept blank passwords
													if (password.equals("")) {
														System.out.println("Sorry, that is not a valid password.");
														if (tryAgain()) {
															continue;
														} else {
															continue superuserlist;
														}
													} else {
														break;
													}
												}
												try {
													ud.updateProfile("PASSWORD", password, thisUser.getUsers().get(currentUserIndex));
													System.out.println("The password has been updated");
												} catch (SQLProfileUpdateException s)  {
													System.out.println("Sorry, the password was not changed.");
												} 
												break;
											// Update first name
											case 3:
												while(true) {
													System.out.println("Current first name is " + thisUser.getUsers().get(currentUserIndex).getFirstname() + ".");
													System.out.print("Please enter a new first name: ");
													firstname = input.nextLine();
													// Do not accept blank names
													if (firstname.equals("")) {
														System.out.println("Sorry, that is not a valid name.");
														if (tryAgain()) {
															continue;
														} else {
															loggedIn = false;
															continue superuserlist;
														}
													} else {
														break;
													}
												}
												try {
													ud.updateProfile("FIRSTNAME", firstname, thisUser.getUsers().get(currentUserIndex));
													thisUser.getUsers().get(currentUserIndex).setFirstname(firstname);
													System.out.println("The first name is now " + firstname + ".");
												} catch (SQLProfileUpdateException s)  {
													System.out.println("Sorry, the first name was not changed.");
												} 
												break;
											// Update last name
											case 4:
												while(true) {
													System.out.println("Current last name is " + thisUser.getUsers().get(currentUserIndex).getLastname() + ".");
													System.out.print("Please enter a new last name: ");
													lastname = input.nextLine();
													// Do not accept blank passwords
													if (lastname.equals("")) {
														System.out.println("Sorry, that is not a valid name.");
														if (tryAgain()) {
															continue;
														} else {
															loggedIn = false;
															continue superuserlist;
														}
													} else {
														break;
													}
												}
												try {
													ud.updateProfile("LASTNAME", lastname, thisUser.getUsers().get(currentUserIndex));
													thisUser.getUsers().get(currentUserIndex).setLastname(lastname);
													System.out.println("The last name is now " + lastname + ".");
												} catch (SQLProfileUpdateException s)  {
													System.out.println("Sorry, the last name was not changed.");
												} 
												break;
											// Logout = return to user options list
											/*  LOGOUT  */
											case 5:
												continue superuseroptions;
											} // End switch user action
										} // End user profile while
									// Delete this user option
									case 3:
										System.out.print("Are you sure you would like to deny \"" + thisUser.getUsers().get(currentUserIndex).getUsername() + "\" all access? [n]:");
										String response = input.nextLine();
										if (response.toLowerCase().startsWith("y")) {
											if (!ud.disableUser(thisUser.getUsers().get(currentUserIndex))) {
												System.out.println("Sorry, the user could not be disabled.");
											}
											continue superuserlist;
										} else {
											System.out.println("\"" + thisUser.getUsers().get(currentUserIndex).getUsername() + "\" was not deleted.");
										}
										break;
									// Switch user option
									case 4:
										currentUserIndex = 0;
										continue superuserlist;
									// Logout option = logout of admin
									case 5:
										loggedIn = false;
										continue mainmenu;
									}
								}
							} // End user options
						} else {
							System.out.println("Sorry, users could not be retrieved.");
							loggedIn = false;
							continue mainmenu;
						}
					} // End userlist while
				} // End if user else superuser
			} // End accountlist while loggedIn with USER vs SUPERUSER
		} // End mainmenu while
	}
	
	/*  LOGIN, REGISTER  */
	public static int getMainMenuOption() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int menuOption = 0;
		System.out.println();
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.println("1 - Login");
			System.out.println("2 - Register");
			System.out.print("What would you like to to? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				menuOption = input.nextInt();
				input.nextLine();
				if (menuOption > 2 || menuOption < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		System.out.println();
		return menuOption;
	}
	
	/*  VIEW, UPDATE, DELETE, SWITCH, LOGOUT  */
	public static int getSuperMenuOption(User thisUser) {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int menuOption = 0;
		System.out.println();
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.println("User " + thisUser.toString());
			System.out.println("1 - View this users Accounts");
			System.out.println("2 - Update this user");
			System.out.println("3 - Delete this user");
			System.out.println("4 - Switch user");
			System.out.println("5 - Logout of Admin");
			System.out.print("What would you like to to? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				menuOption = input.nextInt();
				input.nextLine();
				if (menuOption > 5 || menuOption < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		System.out.println();
		return menuOption;
	}
	
		/*  NEW ACCOUNT, LOGOUT  */
public static int getNoAccountOption(User thisUser) {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int menuOption = 0;
		System.out.println();
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.println("User " + thisUser.toString());
			System.out.println("1 - Create an account");
			System.out.println("2 - Logout");
			System.out.print("What would you like to to? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				menuOption = input.nextInt();
				input.nextLine();
				if (menuOption > 2 || menuOption < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		System.out.println();
		return menuOption;
	}
	
	/*  CHECKING, SAVINGS, SWITCH ACCOUNT, LOGOUT  */
	public static int getNewAccountOption(User thisUser) {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int accountTypeOption = 0;
		System.out.println();
		while (!validInput) {
			// Ask user for a value
			System.out.println("User " + thisUser.toString());
			System.out.println("1 - Checking");
			System.out.println("2 - Savings");
			System.out.println("3 - Switch account");
			System.out.println("4 - Logout");
			System.out.print("Please choose an option: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				accountTypeOption = input.nextInt();
				input.nextLine();
				if (accountTypeOption > 4 || accountTypeOption < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		return accountTypeOption;
	}

	/*  CHOOSE ACCOUNT, NEW ACCOUNT, LOGOUT  */
	public static int getAccountList(User thisUser) {
		int totalAccounts = thisUser.getAccounts().size();
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int accountMenuOption = 0;
		System.out.println();
		while (!validInput) {
			// Ask user for a value
			System.out.println("User " + thisUser.toString());
			int i = 1;
			for(Account a: thisUser.getAccounts()) {
				System.out.println(i + " - " + a.toString());
				i++;
			}
			System.out.println(i + " - Create new account");
			i++;
			System.out.println(i + " - Logout");
			System.out.println();
			System.out.print("Which account would you like to access? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				accountMenuOption = input.nextInt();
				input.nextLine();
				if (accountMenuOption > totalAccounts + 2 || accountMenuOption < 0) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		return accountMenuOption - 1;
	}
	
	/*  CHOOSE USER, NEW USER, LOGOUT  */
	public static int getUserList(User thisUser) {
		int totalUsers = thisUser.getUsers().size();
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int userMenuOption = 0;
		System.out.println();
		while (!validInput) {
			// Ask user for a value
			int i = 1;
			for(User u: thisUser.getUsers()) {
				System.out.println(i + " - " + u.toString());
				i++;
			}
			System.out.println(i + " - Create new user");
			i++;
			System.out.println(i + " - Logout of Admin");
			System.out.println();
			System.out.print("Which user would you like to access? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				userMenuOption = input.nextInt();
				input.nextLine();
				if (userMenuOption > totalUsers + 2 || userMenuOption < 0) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		return userMenuOption - 1;
	}
	
	/*  WITHDRAW, DEPOSIT, CLOSE ACCOUNT, SWITCH ACCOUNT, LOGOUT  */
	public static int getAccountAction(int currentAccount, User thisUser) {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int accountAction = 0;
		System.out.println();
		while (!validInput) {
			// Ask user for a value
			System.out.println("User " + thisUser.toString());
			System.out.println(thisUser.getAccounts().get(currentAccount).toString());
			System.out.println("1 - Make a withdraw");
			System.out.println("2 - Make a deposit");
			System.out.println("3 - Close account");
			System.out.println("4 - Switch accounts");
			System.out.println("5 - Logout");
			System.out.print("What would you like to do with this account? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				accountAction = input.nextInt();
				input.nextLine();
				if (accountAction > 5 || accountAction < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		System.out.println();
		return accountAction;
	}

	/*  WITHDRAW, DEPOSIT, CLOSE ACCOUNT, SWITCH ACCOUNT, LOGOUT  */
	public static int getUserAction(User thisUser) {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int userAction = 0;
		System.out.println();
		while (!validInput) {
			// Ask user for a value
			System.out.println("User " + thisUser.toString());
			System.out.println("1 - Change Username");
			System.out.println("2 - Change Password");
			System.out.println("3 - Change Firstname");
			System.out.println("4 - Change Lastname");
			System.out.println("5 - Logout");
			System.out.print("What would you like to do with this user? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				userAction = input.nextInt();
				input.nextLine();
				if (userAction > 5 || userAction < 1) {
					System.out.println("Sorry, that wasn't one of the options.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't one of the options.\n");
				validInput = false;
				input.nextLine();
			}
		}
		System.out.println();
		return userAction;
	}

	/*  WITHDRAW  */
	public static float getWithdrawAmount(float balance) {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		float amount = 0f;
		while (!validInput) {
			// Ask user for a value
			System.out.print("How much would you like to withdraw? $");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextFloat()) {
				amount = input.nextFloat();
				input.nextLine();
				if (amount > balance) {
					System.out.println("Sorry, there is not enough money for that.\n");
					if (tryAgain()) {
						validInput = false;
					// If they changed their mind, return zero
					}else {
						amount = 0f;
						validInput = true;
					}
				} else if (amount <= 0.0) {
					System.out.println("Please enter a positive number.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't a number.\n");
				validInput = false;
				input.nextLine();
			}
		}
		return amount;
	}
	
	/*  DEPOSIT  */
	public static float getDepositAmount() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		float amount = 0f;
		while (!validInput) {
			// Ask user for a value
			System.out.print("How much would you like to deposit? $");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextFloat()) {
				amount = input.nextFloat();
				input.nextLine();
				if (amount <= 0f) {
					System.out.println("Please enter a positive number.\n");
					validInput = false;
				} else {
					validInput = true;
				}
			} else {
				System.out.println("Sorry, that wasn't a number.\n");
				validInput = false;
				input.nextLine();
			}
		}
		return amount;
		
	}
	
	/* TRY AGAIN  */
	public static boolean tryAgain() {
		Scanner input = new Scanner(System.in);
		String response = "";
		System.out.println();
		System.out.print("Would you like to try again? [n]: ");
		response = input.nextLine();
		return (response.toLowerCase().startsWith("y"));
	}
}
