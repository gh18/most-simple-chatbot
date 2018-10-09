package simpleChatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHandler
{
	public UserInputHandler() // constructor
	{
		displayMenu(true);
	}
	
	private void displayMenu(boolean startUp) // не передавать булевые
	{
		if (startUp)
		{
			System.out.println("Robot: Enter your message please");
		}
		System.out.print(" ");
	}
	
	public String getUserInput()
	{
		
		String userInput = null;
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			userInput = br.readLine();
		}
		catch(IOException error)
		{
			System.out.println("Error occured: " + error);
		}
		
		return userInput;
	}
	
	public void sendMessage(String message) // ChatBot doesn't control the message
	{
		// System.out.println();
		System.out.println("Robot: " + message);
		
	}
}
