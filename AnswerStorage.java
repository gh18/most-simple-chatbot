package simpleChatBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnswerStorage {

	ArrayList<String> responses;

	public AnswerStorage(String fileName) {
		getResponsesArray(fileName);
	}

	/*
	 * private int getNumberOfLines(String fileName) // исп-ть лист вместо массива {
	 * 
	 * int numOfLines = 0;
	 * 
	 * try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	 * while (br.readLine() != null) numOfLines++; } catch (IOException error) {
	 * System.out.println("Error occured: " + error); System.exit(1); // что-то тут
	 * исправить }
	 * 
	 * return numOfLines; // this.numOfLines = numOfLines; }
	 */

	private void getResponsesArray(String fileName) {
		ArrayList<String> arrayList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = br.readLine();

			while (line != null) {
				line = br.readLine();
				arrayList.add(line);
				// responsesArray[lineCount] = line;
				// lineCount++;
			}

		} catch (FileNotFoundException missingFile) {
			System.out.println("File not found " + missingFile);
			System.exit(1);
		} catch (IOException error) {
			System.out.println("Error ocurred: " + error);
			System.exit(1);
		}
		responses = arrayList;
		// responses.
	}

	// gets simpleChatBot response to user input
	public String getResponse(String userInput) {
		String tag;
		String response;
		String[] array;

		if (userInput == null) {
			return "";
		}

		for (String responseLine : this.responses) {
			if (responseLine != null) {
				array = responseLine.split(" - ");
				tag = array[0];
				response = array[1];

				if (tag.compareToIgnoreCase(userInput) == 0) {
					return response;
				}
			}
		}

		return "I am sorry, I am not able to respond to this";
	}
}