package simpleChatBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AnswerStorage {

    String fileName;
    String[] responses = new String[0];
    int lines;

    public AnswerStorage(String fileName)
    {
        this.fileName = fileName;
        getNumberOfLines();
        getResponsesArray();
    }

    private void getNumberOfLines()
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
            System.exit(1);
        }

        this.lines = lines;
    }

    private void getResponsesArray()
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
            System.exit(1);
        }
        catch (IOException error)
        {
            System.out.println("Error ocurred: " + error);
            System.exit(1);
        }
        responses = responsesArray;
    }

    // gets simpleChatBot response to user command
    public String getResponse(String userInput)
    {
        String tag;
        String response;
        String[] array;

        for (String responseLine: this.responses)
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
}
