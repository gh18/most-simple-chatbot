package simpleChatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class userInputHandler
{
	
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
		
		return "I am sorry, I am not able to respond to this yet";
	}
}
