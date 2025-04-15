package banking;
import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

public class Menu extends Account
{
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<String, Integer> data = new HashMap<String, Integer>();
	
	public void getLogin() throws IOException
	{
		int num = 1;
		do
		{
			try
			{
				data.put("Bnk01A2546", 3542);
				data.put("Bnk05X5698", 6845);
				
				System.out.println("Welcome to VBank ATM");
				System.out.print("Enter your Customer ID: ");
				setCustomerID(input.next());
				
				System.out.println();
				System.out.print("Enter your pin: ");
				setCustomerPIN(input.nextInt());
			}
			catch (Exception e)
			{
				System.out.println("\nPlease enter valid characters.");
				num = 2;
			}
			
			String custID = getCustomerID();
			int custPIN = getCustomerPIN();
			
			if(data.containsKey(custID) && data.get(custID) == custPIN)
			{
				getAccountType();
			}
			else
				System.out.println("\nWrong CustomerID or PIN entered!\n\n");
		}
		while(num == 1);
	}
	
	public void getAccountType()
	{
		System.out.println("\n\nAccount type");
		System.out.println("Press 1 - Checking Account");
		System.out.println("Press 2 - Savings Account");
		System.out.println("Press 3 - Exit");
		System.out.print("Select the type of account that you want to access: ");
		int type = input.nextInt();
		
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
	
	public void getChecking()
	{
		System.out.println("\n\nChecking Account");
		System.out.println("Press 1 - View Balance");
		System.out.println("Press 2 - Withdraw Funds");
		System.out.println("Press 3 - Deposit Funds");
		System.out.println("Press 4 - Exit");
		System.out.print("Select option: ");
		int option = input.nextInt();
		
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
	
	public void getSavings()
	{
		System.out.println("\n\nSavings Account");
		System.out.println("Press 1 - View Balance");
		System.out.println("Press 2 - Withdraw Funds");
		System.out.println("Press 3 - Deposit Funds");
		System.out.println("Press 4 - Exit");
		System.out.print("Select option: ");
		int option = input.nextInt();
		
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
