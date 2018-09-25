package simpleChatBot;

public class SimpleChatBot
{
	private String userInput;
	private String response;
	private String fileName = "src/simpleChatBot/answers.txt";
	private AnswerStorage answer;
	private userInputHandler handler;
	
	public SimpleChatBot()
	{
		answer = new AnswerStorage(fileName);
		
		// displays menu at startup
		handler = new userInputHandler();
	}
	
	public void startBot()
	{
		// loop
				do
				{
					userInput = handler.getUserInput();
					response = answer.getResponse(userInput);
					handler.sendMessage(response);
					//System.out.println("Robot: " + response);
					
					if (userInput.equals("bye"))
					{
						System.exit(0);
					}
				}
				while(!userInput.equals("bye"));
	}
	// simpleChatBot itself
	public static void main(String[] args)
	{
		SimpleChatBot bot = new SimpleChatBot();
		bot.startBot();
	}
}
