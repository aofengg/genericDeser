package genericDeser.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import genericDeser.fileOperations.FileProcessor;

public class PopulateObjects {
	private Map<First, Integer> firstMap;
	private Map<Second, Integer> secondMap;
	private Map<String, Class<?>> typeMap;

	public PopulateObjects() {
		firstMap = new HashMap<First, Integer>();
		secondMap = new HashMap<Second, Integer>();
		typeMap = new HashMap<String, Class<?>>();
		typeMap.put("int", int.class);
		typeMap.put("float", float.class);
		typeMap.put("short", short.class);
		typeMap.put("String", String.class);
		typeMap.put("double", double.class);
		typeMap.put("boolean", boolean.class);
	}

	public void deserObjects(File fileIn)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		FileProcessor fp = new FileProcessor(fileIn);
		String line;
		Class<?> cls = null;
		Object obj = null;
		String lastType = null;

		while ((line = fp.readOneLineAsString()) != null) {
			line = line.trim();
			if (line.length() == 0) {
				continue;
			}
			if (line.charAt(0) == 'f') {
				if ("genericDeser.util.First".equals(lastType)) {
					Integer freq = firstMap.get(obj);
					firstMap.put((First) obj, freq == null ? 1 : freq + 1);
				}
				if ("genericDeser.util.Second".equals(lastType)) {
					Integer freq = secondMap.get(obj);
					secondMap.put((Second) obj, freq == null ? 1 : freq + 1);
				}
				line = line.substring(4);
				cls = Class.forName(line);
				obj = cls.newInstance();
				lastType = line;
			} else {
				String[] dataMember = fp.stringToArray(line);
				if (line.endsWith(",")) {
					dataMember[2] += ",";
				}
				setValue(cls, obj, dataMember);
			}
		}
		if ("genericDeser.util.First".equals(lastType)) {
			Integer freq = firstMap.get(obj);
			firstMap.put((First) obj, freq == null ? 1 : freq + 1);
		}
		if ("genericDeser.util.Second".equals(lastType)) {
			Integer freq = secondMap.get(obj);
			secondMap.put((Second) obj, freq == null ? 1 : freq + 1);
		}
	}

	private void setValue(Class<?> cls, Object obj, String[] dataMember) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		String type = dataMember[0].substring(5);
		String var = dataMember[1].substring(4);
		String value = dataMember[2].substring(6);
		String methodName = "set" + var;
		Class<?>[] signature = new Class[1];
		signature[0] = typeMap.get(type);
		Method meth = cls.getMethod(methodName, signature);
		Object[] params = new Object[1];
		if (type.equals("int")) {
			params[0] = Integer.parseInt(value);
		} else if (type.equals("double")) {
			params[0] = Double.parseDouble(value);
		} else if (type.equals("short")) {
			params[0] = Short.parseShort(value);
		} else if (type.equals("float")) {
			params[0] = Float.parseFloat(value);
		} else if (type.equals("boolean")) {
			params[0] = Boolean.parseBoolean(value);
		} else {
			params[0] = value;
		}
		meth.invoke(obj, params);
	}

	/**
	 * @return     Total number of First objects
	 */
	public int numberOfFirst() {
		int number = 0;
		for (Integer value : firstMap.values()) {
			number += value;
		}
		return number;
	}

	/**
	 * @return     Total number of Second objects
	 */
	public int numberOfSecond() {
		int number = 0;
		for (Integer value : secondMap.values()) {
			number += value;
		}
		return number;
	}

	/**
	 * @return     Number of unique First objects
	 */
	public int numberOfDistinctFirst() {
		return firstMap.size();
	}

	/**
	 * @return     Number of unique Second objects
	 */
	public int numberOfDistinctSecond() {
		return secondMap.size();
	}
}
