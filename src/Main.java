import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Main class containing the main method
 * that starts the program.
 * @author Travis Austin Pavelka
 */
public class Main {
	
	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// array to store node's letters
		ArrayList<String> letters = new ArrayList<String>();
		
		
		// get letters out of the letters.txt file
		try {
			File f_letters = new File("letters.txt");
			BufferedReader reader = new BufferedReader(
					new FileReader(f_letters));
			String line;
			while((line = reader.readLine()) != null) {
				String[] letter = line.split(". ");
				letters.add(letter[1]);
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// create the lattice
		LatticeDegree6 lattice = new LatticeDegree6(2, 3, 3, letters);
		
		
		// array to store search words
		ArrayList<String> words = new ArrayList<String>();
		
		
		// get the words to search for
		try {
			File f_words = new File("words.txt");
			BufferedReader reader = new BufferedReader(
					new FileReader(f_words));
			String line;
			while((line = reader.readLine()) != null) {
				words.add(line);
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// search the lattice for the words and output to file
		try {
			String found = "- found\n";
			String missing = "- missing\n";
			File f_out = new File("output.txt");
			BufferedWriter writer;
			writer = new BufferedWriter(
					new FileWriter(f_out));
			
			for(String word: words) {
				boolean search = lattice.search(word);
				if(search) {
					writer.write(word+found);
				} else {
					writer.write(word+missing);
				}
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
