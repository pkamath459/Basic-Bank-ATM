package banking;
import java.text.DecimalFormat;
import java.util.*;

public class Account
{
	private String customerID;
	private int customerPIN;
	private double checkingBalance = 0, savingsBalance = 0;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	public String setCustomerID(String custID)
	{
		customerID = custID;
		return custID;
	}
	
	public int setCustomerPIN(int custPIN)
	{
		customerPIN = custPIN;
		return custPIN;
	}
	
	public String getCustomerID()
	{
		return customerID;
	}
	
	public int getCustomerPIN()
	{
		return customerPIN;
	}
	
	public double getCheckingBalance()
	{
		return checkingBalance;
	}
	
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
	
	public double setCheckingWithdraw(double Amount)
	{
		checkingBalance = checkingBalance - Amount;
		return checkingBalance;
	}
	
	public double setSavingsWithdraw(double Amount)
	{
		savingsBalance = savingsBalance - Amount;
		return savingsBalance;
	}
	
	public double setCheckingDeposit(double Amount)
	{
		checkingBalance = checkingBalance + Amount;
		return checkingBalance;
	}
	
	public double setSavingsDeposit(double Amount)
	{
		savingsBalance = savingsBalance + Amount;
		return savingsBalance;
	}
	
	public void getCheckingWithdrawInput()
	{
		System.out.println("Your current Checking Account balance is: " + moneyFormat.format(checkingBalance));
		System.out.print("Enter the amount you want to withdraw: ");
		double amount = Math.abs(input.nextDouble());
		
		if(checkingBalance > amount)
		{
			setCheckingWithdraw(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(checkingBalance));
		}
		else
			System.out.println("Insufficent funds!");
	}
	
	public void getSavingsWithdrawInput()
	{
		System.out.println("Your current Checking Account balance is: " + moneyFormat.format(savingsBalance));
		System.out.print("Enter the amount you want to withdraw: ");
		double amount = Math.abs(input.nextDouble());
		
		if(savingsBalance > amount)
		{
			setSavingsWithdraw(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(savingsBalance));
		}
		else
			System.out.println("Insufficent funds!");
	}
	
	public void getCheckingDepositInput()
	{
		System.out.println("Your current Checking Account balance is: " + moneyFormat.format(checkingBalance));
		System.out.print("Enter the amount you want to deposit: ");
		double amount = Math.abs(input.nextDouble());
		
		if(amount > 0)
		{
			setCheckingDeposit(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(checkingBalance));
		}
		else
			System.out.println("Incorrect input!");
	}
	
	public void getSavingsDepositInput()
	{
		System.out.println("Your current Checking Account balance is: " + moneyFormat.format(savingsBalance));
		System.out.print("Enter the amount you want to deposit: ");
		double amount = Math.abs(input.nextDouble());
		
		if(amount > 0)
		{
			setSavingsDeposit(amount);
			System.out.println("Your new Checking Account balance is: " + moneyFormat.format(savingsBalance));
		}
		else
			System.out.println("Incorrect input!");
	}
}
