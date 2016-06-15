package game;

import java.util.HashMap;
import java.util.Hashtable;

public class GoodCharacter extends Character{

	private Hashtable <String, String> questionsDisplayedAnswersList;
	private HashMap <String, String> questionCorrectAnswerList;

	public GoodCharacter (String path, String name){
	super(path, name);
	
	}

	private void questionAnswerHashTable()
	{
		questionsDisplayedAnswersList.put("question1", "hint1");
		questionsDisplayedAnswersList.put("question1", "answer11");
		questionsDisplayedAnswersList.put("question1", "answer12");
		questionsDisplayedAnswersList.put("question1", "answer13");
		questionsDisplayedAnswersList.put("question1", "answer14");

		questionsDisplayedAnswersList.put("question2", "hint2");
		questionsDisplayedAnswersList.put("question2", "answer21");
		questionsDisplayedAnswersList.put("question2", "answer22");
		questionsDisplayedAnswersList.put("question2", "answer23");
		questionsDisplayedAnswersList.put("question2", "answer24");

		questionsDisplayedAnswersList.put("question3", "hint3");
		questionsDisplayedAnswersList.put("question3", "answer31");
		questionsDisplayedAnswersList.put("question3", "answer32");
		questionsDisplayedAnswersList.put("question3", "answer33");
		questionsDisplayedAnswersList.put("question3", "answer34");
	}

	private void questionsCorrectAnswersMap()
	{
		questionCorrectAnswerList.put("question1", "answer1");

		questionCorrectAnswerList.put("question2", "answer2");

		questionCorrectAnswerList.put("question3", "answer3");
	}
	
	
}

