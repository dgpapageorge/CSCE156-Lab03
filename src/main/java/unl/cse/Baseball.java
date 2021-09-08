package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Processes a comma-separated value (CSV) file of win/loss data from the 2011
 * National League MLB season. It sorts the teams (best record to worst) and
 * prints a report to the standard output.
 * 
 * @author cbourke
 *
 */
public class Baseball {

	private static final String FILE_NAME = "data/mlb_nl_2011.csv";

	/**
	 * This method loads MLB team data from the CSV file
	 * specified by {@link #FILE_NAME} and instantiates 
	 * and returns a list of {@link Team}s.
	 * 
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static List<Team> loadData() throws FileNotFoundException {

		List<Team> teams = new ArrayList<>();

		Scanner scan = new Scanner(new File("data/mlb_nl_2011.csv"));
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] info = line.split(",");
			String name = info[0];
			Integer wins = Integer.parseInt(info[1]);
			Integer losses = Integer.parseInt(info[2]);
			
			teams.add(new Team(name,wins,losses));
		}
		scan.close();
		
		// TODO: write code to open the file, process it line-by-line
		// to create team instances and add them to the list.
		//
		// Be sure to close the scanner
		return teams;
	}
	
	//TODO: implement the file output method
	
	public static void main(String args[]) throws FileNotFoundException {

		List<Team> teams = loadData();

		System.out.println("Teams: ");
		for (Team t : teams) {
			System.out.println(t);
		}

		Collections.sort(teams, Team.teamByWinPercentage);

		System.out.println("\n\nSorted Teams: ");
		for (Team t : teams) {
			System.out.println(t);
			
		try {
			  PrintWriter pw = new PrintWriter("data/output.csv");
			  pw.write(t.getName()+","+t.getWins()+","+t.getLoss());
			  pw.close();
			} catch (FileNotFoundException fnfe) {
			  throw new RuntimeException(fnfe);
			}
		}

	}

}
