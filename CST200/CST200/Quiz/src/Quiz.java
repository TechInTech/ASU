import java.util.ArrayList; 

public class Quiz 
{ 
	private ArrayList< Question > questions; 
	private int correctAnswerCount; 

	public Quiz() 
	{ 
		this(25); 
	} 

	public Quiz(int numberOfQuestions) 
	{ 
		questions = new ArrayList< Question >(numberOfQuestions); 
		correctAnswerCount = 0; 
	} 

	public void addQuestion( Question q ) 
	{ 
		questions.add( q ); 
	} 

	public void giveQuiz() 
	{ 
		correctAnswerCount = 0; 
		if ( questions.isEmpty() ) 
		{ 
			// output there are no questions. 
			return; 
		} 
		for (int i = 0; i <= questions.size(); i++ ) 
		{ 
		// output the question. 
		// get the answer. 
		// if answer is correct 
		// - increment the correctAnswers. 
		// end if 
		} 
	}
}	