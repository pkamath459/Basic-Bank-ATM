package banking;
import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

//Extending to account class as we need to access the methods from that class.
//Also used to establish the class hierarchy.
public class Menu extends Account
{
	Scanner input = new Scanner(System.in);
	
	//Setting format for the money to be displayed.
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	//Creating a hashmap for the account ID and the corresponding account PIN.
	HashMap<String, Integer> data = new HashMap<String, Integer>();
	
	//Login Page that is diplayed first.
	public void getLogin() throws IOException
	{
		do
		{
			try
			{
				//Setting the account ID and the corresponding account PIN in the hashmap.
				data.put("Bnk01A2546", 3542);
				data.put("Bnk05X5698", 6845);
				
				System.out.println("Welcome to VBank ATM");
				System.out.print("Enter your Customer ID: ");
				setCustomerID(input.next());
				
				System.out.print("Enter your pin: ");
				setCustomerPIN(input.nextInt());
				
				//In the above code the Account ID and the PIN is stored in the setCustomerID & PIN methods.
			}
			
			//Catching exceptions when the user enters the PIN - integer.
			catch (Exception e)
			{
				System.out.println("\nPlease enter valid characters.\n\n");
				
				//Clear the internal buffer of the input so that the old value doesn't affect the execution when the loop re-iterates. 
				input.nextLine();
				continue;
			}
			
			String custID = getCustomerID();
			int custPIN = getCustomerPIN();
			
			//Checking if the entered ID and the PIN match the corresponding values present in the hashmap.
			if(data.containsKey(custID) && data.get(custID) == custPIN)
			{
				getAccountType();
			}
			else
			{
				System.out.println("\nWrong CustomerID or PIN entered!\n\n");
			}
		}
		while(true);
	}
	
	//Selecting the account type.
	public void getAccountType()
	{
		int type = 0;
		try
		{
			System.out.println("\n\nAccount type");
			System.out.println("Press 1 - Checking Account");
			System.out.println("Press 2 - Savings Account");
			System.out.println("Press 3 - Exit");
			System.out.print("Select the type of account that you want to access: ");
			type = input.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nPlease enter a valid input.");
			input.next();
			getAccountType();
		}
		
		switch(type)
		{
		case 1:
			getChecking();
			break;
		case 2:
			getSavings();
			break;
		case 3:
			System.out.println("Thank you for banking with us!\n\n");
			break;
		default:
			System.out.println("Invalid Input.\n\n");
			getAccountType();
		}
	}
	
	//Logging in into checking account.
	public void getChecking()
	{
		int option = 0;
		try
		{
			System.out.println("\n\nChecking Account");
			System.out.println("Press 1 - View Balance");
			System.out.println("Press 2 - Withdraw Funds");
			System.out.println("Press 3 - Deposit Funds");
			System.out.println("Press 4 - Exit");
			System.out.print("Select option: ");
			option = input.nextInt();
			}
		catch(Exception e)
		{
			System.out.println("\nPlease enter a valid input.");
			input.next();
			getChecking();
		}
		
		switch(option)
		{
		case 1:
			System.out.println("Your current checking account balance is: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for banking with us!\n\n");
			break;
		default:
			System.out.println("Invalid input.\n\n");
			getChecking();
		}
	}
	
	//Logging in into savings account.
	public void getSavings()
	{
		int option = 0;
		try
		{
		System.out.println("\n\nSavings Account");
		System.out.println("Press 1 - View Balance");
		System.out.println("Press 2 - Withdraw Funds");
		System.out.println("Press 3 - Deposit Funds");
		System.out.println("Press 4 - Exit");
		System.out.print("Select option: ");
		option = input.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nPlease enter a valid input.");
			input.next();
			getSavings();
		}
		
		switch(option)
		{
		case 1:
			System.out.println("Your current savings account balance is: " + moneyFormat.format(getSavingsBalance()));
			getAccountType();
			break;
		case 2:
			getSavingsWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingsDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for banking with us!\n\n");
			break;
		default:
			System.out.println("Invalid input.\n\n");
			getSavings();
		}
	}
}
