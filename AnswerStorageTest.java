package simpleChatBot;

import org.junit.Assert;
import org.junit.Test;

public class AnswerStorageTest {

	@Test
	public void testLoadFile() {
		AnswerStorage testFile = new AnswerStorage("tests/simpleChatBot/testFile5Lines.txt");
		Assert.assertEquals(testFile.responses.size(), 5);
	}

	@Test
	public void testExistingResponses() {
		AnswerStorage testInput = new AnswerStorage("tests/simpleChatBot/testFile5Lines.txt");
		Assert.assertEquals(testInput.getResponse("help"), "this is a simple local chat bot");
	}

	@Test
	public void testResponsesWithNoInput() {
		AnswerStorage testInput = new AnswerStorage("tests/simpleChatBot/testFile5Lines.txt");
		Assert.assertEquals(testInput.getResponse(null), "");
	}

	@Test
	public void testResponsesUnknownInput() {
		AnswerStorage testInput = new AnswerStorage("tests/simpleChatBot/testFile5Lines.txt");
		Assert.assertEquals(testInput.getResponse("sfhvadhvpihsv3453"), "I am sorry, I am not able to respond to this");
	}

}
