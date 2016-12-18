package genericDeser.fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessor {
	private BufferedReader buffer = null;
	
	public FileProcessor(File fileIn) throws FileNotFoundException {
		this.buffer = new BufferedReader(new FileReader(fileIn));			
	}
	

	/**
	 * Read one line from the file and return a string. 
	 */
	public synchronized String readOneLineAsString() throws IOException {
		return this.buffer.readLine();
	}
	
	public synchronized String[] stringToArray(String line) {
		Pattern p = Pattern.compile(",");
		Matcher m = p.matcher(line);
		line = m.replaceAll(" ");
		line = line.trim();
		String[] sp = line.split("\\s+");
		return sp;
	}
}
