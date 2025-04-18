package banking;
import java.io.*;

//Creating a class hierarchy.
public class ATM extends Menu
{
	public static void main(String[] args) throws IOException
	{
		//Creating the object used to call the Login page of the ATM from the current main method.
		Menu OptionMenu = new Menu();
		OptionMenu.getLogin();
	}

}
