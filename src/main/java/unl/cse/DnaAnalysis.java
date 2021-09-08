package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Processes DNA data and counts the number of instances that a particular DNA
 * subsequence appears.
 *
 */
public class DnaAnalysis {

	private static final String DNA_FILE = "data/H1N1nucleotide.txt";
	private static final String DNA;

	static {
		// load the contents of the file statically (when the class
		// is loaded)
		DNA = loadDnaFromFile();
	}

	/**
	 * Loads a DNA string from the {@link #DNA_FILE} and returns it as a string with
	 * all whitespace removed.
	 * 
	 * @return
	 */
	public static String loadDnaFromFile() {

		Scanner s = null;
		try {
			s = new Scanner(new File(DNA_FILE));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		String dna = "";

		while (s.hasNextLine()) {
			dna += s.nextLine();
		}
		// close the scanner
		s.close();
		// strip all whitespace
		dna = dna.replaceAll("\\s+", "");
		return dna;
	}

	/**
	 * Counts the number of times <code>subSequence</code> appears in the
	 * {@link #DNA} string
	 * 
	 * @return
	 */
	public static int countSubsequences(String subSequence) {

		String dna = loadDnaFromFile();
		int count = 0;
		for (int i = 0; i<dna.length()-subSequence.length()+1;i++)
		{
			
			if (dna.substring(i,i+subSequence.length()).equals(subSequence))
			{
				count++;
			}
		}
		return count;
	}

	public static void main(String args[]) {

		String subSequence = null;

		int count = countSubsequences(subSequence);

		System.out.println(subSequence + " appears " + count + " times");

	}

}
