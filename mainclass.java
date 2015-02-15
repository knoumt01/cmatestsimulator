/* --------------------------------------------- */
/* @title - CMA TEST SIMULATOR (temporary name) */
/* @author - Matt Knouff @ MK Design Software  */
/* @version - 0.0.1			      */
/* ------------------------------------------*/

import java.math.*;
import java.io.*;
import java.nio.*;
import java.util.*;
import java.lang.*;
import java.awt.*;

public class mainclass
{
	public static void main(String[] args) throws IOException 
	{
		/* Create new test, obtain an array of random test questions and process question file */		
		ExamQuestions myExamQuestions = new ExamQuestions();
		int[] examQuestions = myExamQuestions.randNum4Qs(10);
		myExamQuestions.getQFromFile();
		int correct = 0;
		int incorrect = 0;
		int user;
		int answer;

		/* main loop for program */
		for (int i = 0; i < 10; i++)
		{
			int q = examQuestions[i];
			System.out.println("Question " + (i + 1) + ": " + myExamQuestions.getQuestion(q));
			System.out.println("(1) " + myExamQuestions.getA(q));
			System.out.println("(2) " + myExamQuestions.getB(q));
			System.out.println("(3) " + myExamQuestions.getC(q));
			System.out.println("(4) " + myExamQuestions.getD(q));
			System.out.println("(5) " + myExamQuestions.getE(q));
			System.out.print(">> ");
			user = Integer.parseInt(System.console().readLine()); // needs error handling
			answer = Integer.parseInt(myExamQuestions.getCorrect(q));
			System.out.println("");
			
			if (user == answer)
			{
				correct = correct + 1;
			}		
			else
			{
				incorrect = incorrect + 1;
			}
		}
		System.out.println("CORRECT: " + correct + " | INCORRECT: " + incorrect);
	}
}


/* class for processing exam questions from plain txt files */
class ExamQuestions
{
	ExamQuestions() {	}
	
	/* Number of questions in question file */
	final static int nOfLines = 11;

	/* Class-wide variables */
	String[] questionNumber = new String[nOfLines];
	String[] question = new String[nOfLines];
	String[] answerA = new String[nOfLines];
	String[] answerB = new String[nOfLines];
	String[] answerC = new String[nOfLines];
	String[] answerD = new String[nOfLines];
	String[] answerE = new String[nOfLines];
	String[] correctAnswer = new String[nOfLines];

	/* Random number generator for building test bank array */
	int[] randNum4Qs(int numberOfQuestions)
	{
		int qBank[] = new int[numberOfQuestions];
		for(int i = 0; i < numberOfQuestions; i++)
		{
			double randomNumber = (Math.random() * nOfLines);
			int randNumber = (int) randomNumber;
			qBank[i] = randNumber;
		}
		return qBank;
	}

	/* Function for processing test questions from file */
	void getQFromFile() throws IOException
	{
		FileReader fr = new FileReader("questions.txt");
		BufferedReader textReader = new BufferedReader(fr);
		String textData = textReader.readLine();

		StringTokenizer st = new StringTokenizer(textData, "|", false);

		for(int a = 0; a < nOfLines; a++) 
		{
			questionNumber[a] = st.nextToken();
			question[a] = st.nextToken();
			answerA[a] = st.nextToken();
			answerB[a] = st.nextToken();
			answerC[a] = st.nextToken();
			answerD[a] = st.nextToken();
			answerE[a] = st.nextToken();
			correctAnswer[a] = st.nextToken();
		}
	}

	/* Get question #1 and return the question as a string */
	String getQuestion(int a)
	{
		String nextQuestion = question[a];
		return nextQuestion;
	}

	String getA(int a)
	{
		String nextA = answerA[a];
		return nextA;
	}

	String getB(int a)
	{
		String nextB = answerB[a];
		return nextB;
	}

	String getC(int a)
	{
		String nextC = answerC[a];
		return nextC;
	}

	String getD(int a)
	{
		String nextD = answerD[a];
		return nextD;
	}

	String getE(int a)
	{
		String nextE = answerE[a];
		return nextE;
	}

	String getCorrect(int a)
	{
		String nextCorrect = correctAnswer[a];
		return nextCorrect;
	}

}
