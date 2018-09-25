package simpleChatBot;

import java.io.*;

public class SimpleChatBot
{
	// prints a menu to terminal
	private static void displayMenu(Boolean startUp)
	{
		if (startUp)
		{
			System.out.println("Robot: Enter your message please");
		}
		System.out.print(" ");
	}
	
	// gets total number of lines in a file
	private static int getNumberOfLines(String fileName)
	{
		int lines = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			while (br.readLine() != null)
				lines++;
		}
		catch(IOException error)
		{
			System.out.println("Error occured: " + error);
		}
		
		return lines;
	}
	
	// gets user's input from terminal
	private static String getUserInput()
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
	
	// gets responses from a file
	private static String[] getResponsesArray(String fileName, int lines)
	{
		int lineCount = 0;
		String line;
		String[] responsesArray = new String[lines];
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			do
			{
				line = br.readLine();
				if (line != null)
				{
					responsesArray[lineCount] = line;
					lineCount++;
				}
			}
			while (line != null);
		}
		catch (FileNotFoundException missingFile)
		{
			System.out.println("File not found " + missingFile);
		}
		catch (IOException error)
		{
			System.out.println("Error ocurred: " + error);
		}
		return responsesArray;
	}
	
	// gets simpleChatBot response to user command
	private static String getResponse(String[] responses, String userInput)
	{
		String tag;
		String response;
		String[] array;
		
		for (String responseLine: responses)
		{
			if (responseLine != null)
			{
				array = responseLine.split(" - ");
				tag = array[0];
				response = array[1];
				
				if (tag.compareToIgnoreCase(userInput) == 0)
				{
					return response;
				}
			}
		}
		
		return "I am sorry, I am not able to respond to this";
	}
	
	// simpleChatBot itself
	public static void main(String[] args)
	{
		// sets variables
		String userInput;
		String response;
		String fileName = "src/simpleChatBot/answers.txt";
		
		int lines = getNumberOfLines(fileName);
		String[] responsesArray = getResponsesArray(fileName, lines);
		
		// displays menu at startup
		displayMenu(true);
		
		// loop
		do
		{
			userInput = getUserInput();
			response = getResponse(responsesArray, userInput);
			System.out.println("Robot: " + response);
			
			if (!userInput.equals("bye"))
			{
				displayMenu(false);
			}
			
		}
		while(!userInput.equals("bye"));
	}
	

}
