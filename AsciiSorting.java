package sorting1;

import java.io.*;
import java.util.*;

        /**
	 * Implement a way to sort a file filled with ASCII values.
	 * @author Ngoufo Stanie
	 */

public class AsciiSorting {

	/**
	 * List of values
	 * @author Ngoufo Stanie
	 */
	public List<Integer> container;
	
	private BufferedReader reader;

	/**
	 * Read line by line  all ASCII values in a given file and save their  numerical value in a
	 * list call container. 
	 * Each line can contain more than just one ASCII value.
	 * @throws IOException
	 */

	public void readFile() throws IOException {
		
		try {
			File AsciiFile = new File("asciiUnsorted.txt");
			 reader = new BufferedReader(new FileReader(AsciiFile));
			String line;
			container = new ArrayList<Integer>();

			while ((line = reader.readLine()) != null) {

				for (int i = 0; i < line.length(); i++) {
					container.add((int) line.charAt(i));
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("file Not found");
			e.printStackTrace();
		}
	}

	/**
	 * Sort the numeric values save in the list container with bubbleSort Algorithm
	 * The complexity is O(n²)
	 * @return a sorted list
	 * @throws IOException
	 */
	public List<Integer> bubbleSort() throws IOException {
		readFile();
		int temp;

		for (int i = 0; i < container.size() - 1; i++) {
			for (int j = 0; j < container.size() - 1 - i; j++) {
				if (container.get(j) > container.get(j + 1)) {
					temp = container.get(j);
					container.set(j, container.get(j + 1));
					container.set(j + 1, temp);
				}
			}
		}
		return container;
	}

	/**
	 * write the sorted list in a new file called "sortedFile.txt"
	 * @throws IOException
	 */
	public void writeFile() throws IOException {
		int lineLength = 100;
		String line = "";
		BufferedWriter writer = new BufferedWriter(new FileWriter("sortedFile.txt"));
		bubbleSort();
		for (int i = 0; i < container.size(); i++) {
			int num = container.get(i);
			line += (char) num;
			lineLength--;
			if (lineLength == 0) {
				writer.write(line);
				writer.newLine();
				line = "";
				lineLength = 100;
			}
		}
		if (line.length() < 100) { // in case the remaining caracters are less than 100,just print the line
			writer.write(line);
		}
		writer.close();
	}
}
