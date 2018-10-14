package simpleChatBot;

public class SimpleChatBot {
	// private String userInput;
	// private String response;
	// private String fileName = "src/simpleChatBot/answers.txt";
	private AnswerStorage answer;
	private UserInputHandler handler; // проверить переменные
	// оставить хэндлер и ансер

	public SimpleChatBot(String fileName) {
		answer = new AnswerStorage(fileName);

		// displays menu at startup
		handler = new UserInputHandler();
	}

	public void startBot() {
		String userInput; // вне цикла чтобы не выделялась лишняя память => быстрее (хоть и будет
							// удаляться)
		String response;
		// loop
		do {
			userInput = handler.getUserInput();
			response = answer.getResponse(userInput);
			handler.sendMessage(response);
			// System.out.println("Robot: " + response);

			if (userInput.equals("bye")) {
				System.exit(0);
			}
		} while (!userInput.equals("bye"));
	}

	// simpleChatBot itself
	public static void main(String[] args) {
		String fileName = "src/simpleChatBot/answers.txt";
		SimpleChatBot bot = new SimpleChatBot(fileName);
		bot.startBot();
	}
}
