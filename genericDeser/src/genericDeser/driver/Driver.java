package genericDeser.driver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import genericDeser.util.PopulateObjects;
import genericDeser.util.Logger;

public class Driver {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, IOException {
		if (args.length != 2) {
			System.out.println("Please enter two command line arguments.");
			System.out.println("<input.txt>  <debug_value>.");
		} else {
			Logger.setDebugValue(Integer.parseInt(args[1]));
			
			File file = new File(args[0]);
			PopulateObjects po = new PopulateObjects();
			po.deserObjects(file);
			
			Logger.writeMessage("Number of unique First objects: " + po.numberOfDistinctFirst() + "\n" +
					"Total Number of First objects: " + po.numberOfFirst() + "\n" +
					"Number of unique Second objects: " + po.numberOfDistinctSecond() + "\n" +
					"Total Number of Second objects: " + po.numberOfSecond(), Logger.DebugLevel.NUMBERS);
		}
	}

}
