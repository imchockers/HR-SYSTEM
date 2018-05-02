package view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Console input output stream
 * 
 * @author Lachlan Clulow s3682356
 * @date 2/4/2018
 *
 */
public class ConsoleView {
	private PrintStream out;
	private Scanner in;
	
	/**
	 * Default constructor
	 * 
	 * @param streamIn Input Stream
	 * @param streamOut Output Stream
	 */
	public ConsoleView (InputStream streamIn, PrintStream streamOut) {
		out = streamOut;
		in = new Scanner(streamIn);
	}
	
	/**
	 * Prints str to the output stream, terminates with a newline
	 * 
	 * @param str
	 */
	public void println(String str) {
		out.println(str);
	}

	/**
	 * Prints prompt to output stream and waits for user input
	 * 
	 * @param prompt prompt to print out
	 * @return the user input string
	 */
	public String getInput(String prompt) {
		out.println(prompt);
		return in.nextLine();
	}
}
