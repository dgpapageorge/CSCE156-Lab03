package unl.cse;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class BaseballTests {

	private static final List<Team> EXPECTED = new ArrayList<Team>();
	static {
		EXPECTED.add(new Team("Phillies", 102, 60));
		EXPECTED.add(new Team("Braves", 89, 73));
		EXPECTED.add(new Team("Nationals", 80, 81));
		EXPECTED.add(new Team("Mets", 77, 85));
		EXPECTED.add(new Team("Marlins", 72, 90));
		EXPECTED.add(new Team("Brewers", 96, 66));
		EXPECTED.add(new Team("Cardinals", 90, 72));
		EXPECTED.add(new Team("Reds", 79, 83));
		EXPECTED.add(new Team("Pirates", 72, 90));
		EXPECTED.add(new Team("Cubs", 71, 91));
		EXPECTED.add(new Team("Astros", 56, 106));
		EXPECTED.add(new Team("DBacks", 94, 68));
		EXPECTED.add(new Team("Giants", 86, 76));
		EXPECTED.add(new Team("Dodgers", 82, 79));
		EXPECTED.add(new Team("Rockies", 73, 89));
		EXPECTED.add(new Team("Padres", 71, 91));
	}

	/**
	 * Tests that the {@link Baseball#loadData()} method correctly 
	 * loads and creates instances of the {@link Team} class.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void teamFixedTest01() throws FileNotFoundException {
		List<Team> result = Baseball.loadData();
		Assertions.assertEquals(EXPECTED, result);
	}

}
