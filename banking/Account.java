package banking;
import java.text.DecimalFormat;
import java.util.*;

public class Account
{
	//Initializing the variables.
	private String customerID;
	private int customerPIN;
	private double checkingBalance = 0, savingsBalance = 0;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	//Setting the Customer ID.
	public String setCustomerID(String custID)
	{
		customerID = custID;
		return custID;
	}
	
	//Setting the Customer PIN.
	public int setCustomerPIN(int custPIN)
	{
		customerPIN = custPIN;
		return custPIN;
	}
	
	//Will be used to return the Customer ID.
	public String getCustomerID()
	{
		return customerID;
	}
	
	//Will be used to return the Customer PIN.
	public int getCustomerPIN()
	{
		return customerPIN;
	}
	
	//Returns the current balance in the Checking Account.
	public double getCheckingBalance()
	{
		return checkingBalance;
	}
	
	//Returns the current balance in the Savings Account.
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
	
	//Calculating and returning the balance after a certain amount is withdrawn from the Checking account. 
	public double setCheckingWithdraw(double Amount)
	{
		checkingBalance = checkingBalance - Amount;
		return checkingBalance;
	}
	
	//Calculating and returning the balance after a certain amount is withdrawn from the Savings account.
	public double setSavingsWithdraw(double Amount)
	{
		savingsBalance = savingsBalance - Amount;
		return savingsBalance;
	}
	
	//Calculating and returning the balance after a certain amount is deposited into the Checking account.
	public double setCheckingDeposit(double Amount)
	{
		checkingBalance = checkingBalance + Amount;
		return checkingBalance;
	}
	
	//Calculating and returning the balance after a certain amount is deposited into the Savings account.
	public double setSavingsDeposit(double Amount)
	{
		savingsBalance = savingsBalance + Amount;
		return savingsBalance;
	}
	
	//Taking the user input for withdrawing an amount from the Checking account.
	public void getCheckingWithdrawInput()
	{
		double amount = 0;
		
		//Handling inputs that are of data type other than "Double".
		try
		{
			System.out.println("Your current Checking Account balance is: " + moneyFormat.format(checkingBalance));
			System.out.print("Enter the amount you want to withdraw: ");
			
			//Removing the negative values if entered.
			amount = Math.abs(input.nextDouble());
		}
		catch(Exception e)
		{
			System.out.println("Please enter a valid amount.");
			input.next();
		}
		if(checkingBalance > amount)
		{
			setCheckingWithdraw(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(checkingBalance));
		}
		else
			System.out.println("Insufficent funds!");
	}
	
	//Taking the user input for withdrawing an amount from the Savings account.
	public void getSavingsWithdrawInput()
	{
		double amount = 0;
		try
		{
			System.out.println("Your current Checking Account balance is: " + moneyFormat.format(savingsBalance));
			System.out.print("Enter the amount you want to withdraw: ");
			amount = Math.abs(input.nextDouble());
		}
		catch(Exception e)
		{
			System.out.println("Please enter a valid amount.");
			input.next();
		}
		
		if(savingsBalance > amount)
		{
			setSavingsWithdraw(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(savingsBalance));
		}
		else
			System.out.println("Insufficent funds!");
	}
	
	//Taking the user input for depositing an amount into the Checking account.
	public void getCheckingDepositInput()
	{
		double amount = 0;
		try
		{
			System.out.println("Your current Checking Account balance is: " + moneyFormat.format(checkingBalance));
			System.out.print("Enter the amount you want to deposit: ");
			amount = Math.abs(input.nextDouble());
		}
		catch(Exception e)
		{
			System.out.println("Please enter a valid amount.");
			input.next();
		}
		
		if(amount > 0)
		{
			setCheckingDeposit(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(checkingBalance));
		}
		else
			System.out.println("Incorrect input!");
	}
	
	//Taking the user input for depositing an amount into the Savings account.
	public void getSavingsDepositInput()
	{
		double amount = 0;
		try
		{
			System.out.println("Your current Checking Account balance is: " + moneyFormat.format(savingsBalance));
			System.out.print("Enter the amount you want to deposit: ");
			
			amount = Math.abs(input.nextDouble());
		}
		catch(Exception e)
		{
			System.out.println("Please enter a valid amount.");
			input.next();
		}
		
		if(amount > 0)
		{
			setSavingsDeposit(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(savingsBalance));
		}
		else
			System.out.println("Incorrect input!");
	}
}
