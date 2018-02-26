package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.AccountType;
import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.dao.AccountTypeDaoImpl;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserTypeDaoImpl;

public class Driver {

	public static void main(String[] args) throws OverdraftException, IncorrectPasswordException, UnknownUserException, IncorrectInputException
	{
		AccountTypeDaoImpl accountTypes = new AccountTypeDaoImpl();
		BankAccountDaoImpl bankAccounts = new BankAccountDaoImpl();

		UserDaoImpl users = new UserDaoImpl();
		UserTypeDaoImpl userTypes = new UserTypeDaoImpl();

		//TransactionDaoImpl transactions = new TransactionDaoImpl();
		//TransactionTypeDaoImpl transactionTypes = new TransactionTypeDaoImpl();

		Scanner sc = new Scanner(System.in);
		String input = "";

		User currentUser = null;
		boolean isValid = false;
		boolean exit = false;
		boolean back = false;
		boolean forward = false;

		while(!exit)
		{
			currentUser = null;
			input = "";
			isValid = false;

			while(!isValid)
			{
				System.out.println("\n______________________________________________________________\n"
						+ "\nWelcome! What would you like to do:"
						+ "\n1: Login"
						+ "\n2: Register"
						+ "\nPlease enter the number corresponding to what you would like to do: ");
				input = sc.nextLine();
				if(input.trim().matches("^[1-2]{1}$"))
					isValid = true;
				else
				{
					System.out.println("Please enter a number corresponding to the commands above.");
				}
			}


			if(input.equals("1"))
			{
				isValid = false;
				while(!isValid)
				{
					String username = "";
					String password = "";

					System.out.println("LOGGING IN\n");
					isValid = false;
					while(!isValid)
					{
						System.out.println("Username: ");
						username = sc.nextLine();
						if(username.trim().matches("^(?!.*[-_]{2,})(?=^[^-_].*[^-_]$)[\\w\\s-]{6,15}$"))
							isValid = true;
						else
							System.out.println("Incorrect username");
					}

					isValid = false;
					while(!isValid)
					{
						System.out.println("Password: ");
						password = sc.nextLine();
						if(password.trim().matches("^(?!.*[-_]{2,})(?=^[^-_].*[^-_]$)[\\w\\s-]{8,20}$"))
							isValid = true;
						else
							System.out.println("Incorrect Password Entered");
					}

					List<User> allUsers = users.getUsers();
					System.out.println("size: " + allUsers.size());
					int i = 0;
					isValid = false;
					if(!isValid  || i < allUsers.size())
					{
						if(allUsers.get(i).getUsername().trim().equals(username) && allUsers.get(i).getPassword().trim().equals(password) )
						{
							currentUser = allUsers.get(i);
							isValid = true;
						}
						i++;
					}
					System.out.println("isValid: " +isValid);
					System.out.println("Login Successful!");
				}

				if(currentUser.getUserType().getName().equalsIgnoreCase("General"))
				{
					while(!exit)
					{	
						isValid = false;

						while(!isValid)
						{
							System.out.println("\n______________________________________________________________\n"
									+ "\nWhat would you like to do:"
									+ "\n1: View Accounts"
									+ "\n2: Create an account"
									+ "\n3: Logout"
									+ "\nPlease enter the number corresponding to what you would like to do: ");
							input = sc.nextLine();
							if(input.trim().matches("^[1-3]{1}$"))
								isValid = true;
							else
							{
								System.out.println("Please enter a number corresponding to the commands above.");
							}
						}

						if(input.equals("1"))
						{
							BankAccount currAccount = null;
							while(!isValid)
							{
								isValid = false;
								System.out.println("\n______________________________________________________________\n"
										+ "\nVIEWING ACCOUNTS"
										+ "\nEnter the number of the account you want to select:");

								for(int i = 0; i < ((GeneralUser) currentUser).getAccounts().size(); i++)
								{
									System.out.println((i+1) + " " + ((GeneralUser) currentUser).getAccounts().get(i).getType().getName());
								}
								System.out.println("\nPlease enter the number corresponding to what you would like to do: ");
								input = sc.nextLine();
								if(input.trim().matches("^[1-" + ((GeneralUser) currentUser).getAccounts().size() +"]{1}$"))
								{
									currAccount = ((GeneralUser) currentUser).getAccounts().get(Integer.parseInt(input));
									isValid = true;
								}
								else
								{
									System.out.println("Please enter a number corresponding to the commands above.");
								}
							}

							if(currAccount != null)
							{
								isValid = false;
								while(!isValid)
								{
									System.out.println("\n______________________________________________________________\n"
											+ "\n1: View Balance"
											+ "\n2: Deposit"
											+ "\n3: Withdraw"
											+ "\n4: Delete an account"
											+ "\n5: Logout"
											+ "\nPlease enter the number corresponding to what you would like to do: ");
									input = sc.nextLine();
									if(input.trim().matches("^[1-5]{1}$"))
										isValid = true;
									else
									{
										System.out.println("Please enter a number corresponding to the commands above.");
									}
								}

								if(input.matches("1"))
								{
									System.out.println("Current Balance: " + currAccount.getBalance());
								}
								else if(input.matches("2"))
								{
									isValid = false;
									while(!isValid)
									{
										System.out.println("\n______________________________________________________________\n"
												+ "\n1: How much would you like to deposit?");
										input = sc.nextLine();
										if(input.trim().matches("^\\d+(\\.\\d{2})?$"))
										{
											bankAccounts.updateBankAccount(currAccount, currentUser, currAccount.getBalance()+Float.parseFloat(input), currAccount.getType());
											isValid = true;
										}
										else
										{
											System.out.println("Please enter a format like: 12345.67");
										}
									}
								}
								else if(input.matches("3"))
								{
									isValid = false;
									while(!isValid)
									{
										System.out.println("\n______________________________________________________________\n"
												+ "\n1: How much would you like to withdraw?");
										input = sc.nextLine();
										if(input.trim().matches("^\\d+(\\.\\d{2})?$") && currAccount.getBalance()-Float.parseFloat(input) > 0.0)
										{
											bankAccounts.updateBankAccount(currAccount, currentUser, currAccount.getBalance()-Float.parseFloat(input), currAccount.getType());
											isValid = true;
										}
										else
										{
											System.out.println("Please enter a format like: 12345.67");
											if(currAccount.getBalance()-Float.parseFloat(input) < 0.0)
												System.out.println("You are withdrawing more than the current balance in this account");
										}
									}
								}
								else if (input.matches("4"))
								{
									if(currAccount.getBalance() != 0.0f)
										System.out.println("Your account balance must be empty before you can delete this account");
									else
									{
										bankAccounts.deleteBankAccount(currAccount);
									}
								}
								else if(input.matches("5"))
									exit = true;
							}
						}
						else if(input.equals("2"))
						{
							System.out.println("A new account has been created!");
							bankAccounts.createBankAccount(new BankAccount(currentUser, 0.0f, new AccountType(accountTypes.getAccountTypeById(2).getName()), null));
						}
						else if(input.equals("3"))
							exit = true;
					} // logout
				} //end of General user
				else if(currentUser.getUserType().getName().equalsIgnoreCase("Super"))
				{
					exit = false;
					while(!exit)
					{
						isValid = false;
						while(!isValid)
						{
							System.out.println("\n______________________________________________________________\n"
									+ "\nWhat would you like to do:"
									+ "\n1: View users"
									+ "\n2: Search for a user"
									+ "\n3: Create a user"
									+ "\n4: Update a user"
									+ "\n5: Delete a user"
									+ "\n6: Logout"
									+ "\nPlease enter the number corresponding to what you would like to do: ");
							input = sc.nextLine();
							if(input.trim().matches("^[1-6]{1}$"))
								isValid = true;
							else
							{
								System.out.println("Please enter a number corresponding to the commands above.");
							}
						}

						if(input.equals("1"))
						{
							System.out.println("DISPLAYING ALL USERS");
							for(User u : users.getUsers())
								System.out.println(u);
						}
						else if(input.equals("2"))
						{
							System.out.println("\n______________________________________________________________\n");
							System.out.println("SEARCHING FOR A USER BY THEIR ID");
							isValid = false;
							
							while(!isValid)
							{
								System.out.println("ID: ");
								input = sc.nextLine();
								if(input.trim().matches("^[0-9]{1," + (Integer.MAX_VALUE-2) +"}$"))
									isValid = true;
								else
								{
									System.out.println("The id cannot be greater than " + users.getUsers().size());
								}
							}

							List<User> allUsers = users.getUsers();
							User u = null;
							int i = 0;
							isValid = false;
							while(!isValid || i < allUsers.size())
							{
								if(allUsers.get(i).getId() == Integer.parseInt(input))
								{
									u = users.getUserById(Integer.parseInt(input));
									isValid = true;
								}
								i++;
							}
							if(!isValid)
								System.out.println("The user with the id you entered does not exist");
						}
						else if(input.equals("3"))
						{
							System.out.println("CREATING A USER");
							isValid = false;
							while(!isValid)
							{
								String firstname = "";
								String lastname = "";
								String username = "";
								String password = "";

								isValid = false;
								while(!isValid)
								{
									System.out.println("Firstname: ");
									firstname = sc.nextLine();
									if(firstname.trim().matches("^[A-Z][a-zA-Z].*{1,15}$"))
										isValid = true;
									else
									{
										System.out.println("Firstname must be capitalized");
										System.out.println("Firstname must be no greater than length 15");
									}
								}

								isValid = false;
								while(!isValid)
								{
									System.out.println("Lastname: ");
									lastname = sc.nextLine();
									if(lastname.trim().matches("^[A-Z][a-zA-Z].*{1,15}$"))
										isValid = true;
									else
									{
										System.out.println("Lastname must be capitalized");
										System.out.println("Lastname must be no greater than length 15");
									}
								}

								isValid = false;
								while(!isValid)
								{
									try
									{
										System.out.println("Username: ");
										username = sc.nextLine();
										if(username.trim().matches("^[A-Za-z][a-zA-Z0-9].*{5,20}$"))
											isValid = true;
										else
											throw new IncorrectInputException("Username must be no less than length 5"
													+ "\nUsername must be no greater than length 15"
													+ "\nNo special characters except \'_\' and \'-\'");
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}

									/*
										System.out.println("Username must be no less than length 6");
										System.out.println("Username must be no greater than length 15");
										System.out.println("No special characters except \'_\' and \'-\'");
									 */
								}


								isValid = false;
								while(!isValid)
								{
									try
									{
										System.out.println("Password: ");
										password = sc.nextLine();
										if(password.trim().matches("^[a-zA-Z]\\w{8,20}$"))
											isValid = true;
										else
										{
											throw new IncorrectPasswordException("Password must be no less than length 8"
													+ "\nPassword must be no greater than length 20");
										}
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
								}

								List<User> allUsers = users.getUsers();
								int i = 0;
								isValid = false;
								while(!isValid  || i < allUsers.size())
								{
									if(allUsers.isEmpty() || (!allUsers.get(i).getUsername().equals(username) && allUsers.get(i).getPassword().equals(password)))
									{
										UserType userType = null;
										for(UserType u : userTypes.getUserTypes())
										{
											if(u.getName().equals("General"))
												userType = u;
										}
										users.createUser(new GeneralUser(firstname, lastname, username, password, userType, null));
										isValid = true;
									}
									i++;
								}
								if(!isValid)
									System.out.println("The username \'" + username + "\'already exists");
							}
						}
						else if(input.equals("4"))
						{
							System.out.println("UPDATING A USER'S INFO");
							User u = null;
							String firstname = "";
							String lastname = "";
							String username = "";
							String password = "";

							while(!isValid)
							{
								System.out.println("\n______________________________________________________________\n"
										+ "\n1: Enter the ID of the user you want to update: "
										+ "\n2: Enter 0 if you would like to cancel");
								input = sc.nextLine();
								if(input.trim().matches("^\\d{1,})?$"))
								{
									if(Integer.parseInt(input) < users.getUsers().size() || input.equals("0"))
									{
										u = users.getUserById(Integer.parseInt(input));	
										isValid = true;
									}	
								}
								else
								{
									System.out.println("The id cannot be greater than " + users.getUsers().size());
								}
							}

							if(!input.equals("0") && u != null)
							{

								isValid = false;
								while(!isValid)
								{
									System.out.println("Firstname: ");
									System.out.println("Enter: 0 if you do not want to change this user's firstname");
									firstname = sc.nextLine();
									if(firstname.trim().matches("^[A-Z][a-zA-Z].*{1,15}$") || firstname.equals("0"))
										isValid = true;
									else
									{
										System.out.println("Firstname must be capitalized");
										System.out.println("Firstname must be no greater than length 15");
									}
								}

								isValid = false;
								while(!isValid)
								{
									System.out.println("Lastname: ");
									System.out.println("Enter: 0 if you do not want to change this user's lastname");
									lastname = sc.nextLine();
									if(lastname.trim().matches("^[A-Z][a-zA-Z].*{1,15}$") || lastname.equals("0"))
										isValid = true;
									else
									{
										System.out.println("Lastname must be capitalized");
										System.out.println("Lastname must be no greater than length 15");
									}
								}

								isValid = false;
								while(!isValid)
								{
									try
									{
										System.out.println("Username: ");
										System.out.println("Enter: 0 if you do not want to change this user's username");
										username = sc.nextLine();
										if(username.trim().matches("^(?!.*[-_]{2,})(?=^[^-_].*[^-_]$)[\\w\\s-]{6,15}$") || username.equals("0"))
											isValid = true;
										else
											throw new IncorrectInputException("Username must be no less than length 6"
													+ "\nUsername must be no greater than length 15"
													+ "\nNo special characters except \'_\' and \'-\'");
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}

									/*
								System.out.println("Username must be no less than length 6");
								System.out.println("Username must be no greater than length 15");
								System.out.println("No special characters except \'_\' and \'-\'");
									 */
								}


								isValid = false;
								while(!isValid)
								{
									try
									{
										System.out.println("Password: ");
										System.out.println("Enter: 0 if you do not want to change this user's password");

										password = sc.nextLine();
										if(password.trim().matches("^[a-zA-Z]\\w{8,20}$") || username.equals("0"))
											isValid = true;
										else
										{
											throw new IncorrectPasswordException("Username must be no less than length 8"
													+ "\nUsername must be no greater than length 20");
										}
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
								}

								if(!firstname.equals("0"))
									users.updateUser(u, firstname, u.getLastName(), u.getUsername(), u.getPassword(), u.getUserType());
								if(!lastname.equals("0"))
									users.updateUser(u, u.getFirstName(), lastname, u.getUsername(), u.getPassword(), u.getUserType());
								if(!username.equals("0"))
									users.updateUser(u, u.getFirstName(), u.getLastName(), username, u.getPassword(), u.getUserType());
								if(!password.equals("0"))
									users.updateUser(u, u.getFirstName(), u.getLastName(), u.getUsername(), password, u.getUserType());
							}
						}
						else if(input.equals("5"))
						{
							System.out.println("DELETING A USER");
							User u = null;
							while(!isValid)
							{
								System.out.println("\n______________________________________________________________\n"
										+ "\n1: Enter the ID of the user you want to delete: "
										+ "\n2: Enter 0 if you would like to cancel");
								input = sc.nextLine();
								if(input.trim().matches("^\\d{1,})?$"))
								{
									if(Integer.parseInt(input) < users.getUsers().size() || input.equals("0"))
									{
										u = users.getUserById(Integer.parseInt(input));	
										isValid = true;
									}	
								}
								else
								{
									System.out.println("The id cannot be greater than " + users.getUsers().size());
								}
							}

							if(!input.equals("0"))
							{
								users.deleteUser(u);
							}
						}
						else if(input.equals("6"))
							exit = true;
					}
				} //end of Super user
			} // end of login
			else if(input.equals("2"))
			{
				isValid = false;
				while(!isValid)
				{
					String firstname = "";
					String lastname = "";
					String username = "";
					String password = "";

					System.out.println("REGISTERING\n");

					isValid = false;
					while(!isValid)
					{
						System.out.println("Firstname: ");
						firstname = sc.nextLine();
						if(firstname.trim().matches("^[A-Z][a-zA-Z].*{1,15}$"))
							isValid = true;
						else
						{
							System.out.println("Firstname must be capitalized");
							System.out.println("Firstname must be no greater than length 15");
						}
					}

					isValid = false;
					while(!isValid)
					{
						System.out.println("Lastname: ");
						lastname = sc.nextLine();
						if(lastname.trim().matches("^[A-Z][a-zA-Z].*{1,15}$"))
							isValid = true;
						else
						{
							System.out.println("Lastname must be capitalized");
							System.out.println("Lastname must be no greater than length 15");
						}
					}

					isValid = false;
					while(!isValid)
					{
						try
						{
							System.out.println("Username: ");
							username = sc.nextLine();
							if(username.trim().matches("^[A-Za-z][a-zA-Z0-9].*{5,20}$"))
								isValid = true;
							else
								throw new IncorrectInputException("Username must be no less than length 5"
										+ "\nUsername must be no greater than length 15"
										+ "\nNo special characters except \'_\' and \'-\'");
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}

						/*
							System.out.println("Username must be no less than length 6");
							System.out.println("Username must be no greater than length 15");
							System.out.println("No special characters except \'_\' and \'-\'");
						 */
					}


					isValid = false;
					while(!isValid)
					{
						try
						{
							System.out.println("Password: ");
							password = sc.nextLine();
							if(password.trim().matches("^[a-zA-Z]\\w{8,20}$"))
								isValid = true;
							else
							{
								throw new IncorrectPasswordException("Password must be no less than length 8"
										+ "\nPassword must be no greater than length 20");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}

					List<User> allUsers = users.getUsers();
					int i = 0;
					isValid = false;
					while(!isValid  || i < allUsers.size())
					{
						if(allUsers.isEmpty() || (!allUsers.get(i).getUsername().equals(username) && allUsers.get(i).getPassword().equals(password)))
						{
							UserType userType = null;
							for(UserType u : userTypes.getUserTypes())
							{
								if(u.getName().equals("General"))
									userType = u;
							}
							users.createUser(new GeneralUser(firstname, lastname, username, password, userType, null));
							isValid = true;
						}
						i++;
					}
					if(!isValid)
						System.out.println("The username \'" + username + "\'already exists");
				}

			} // end of register
		} // exit the online banking
		System.out.println("Logging Out");
		sc.close();
	}
}
