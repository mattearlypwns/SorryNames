package com.mattearlypwns.SorryNames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class IO implements Runnable {

	private static File baseFile = new File("Names.txt");

	private static ArrayList<String> p1 = new ArrayList<String>();
	private static ArrayList<String> p2 = new ArrayList<String>();
	private static ArrayList<String> p3 = new ArrayList<String>();
	private static ArrayList<String> p4 = new ArrayList<String>();
	private static ArrayList<String> p5 = new ArrayList<String>();
	private static ArrayList<String> p6 = new ArrayList<String>();

	public void checkFile() throws Exception {
		if (!baseFile.exists()) {
			makeNamesFile();
			JOptionPane.showMessageDialog(null, "Names.txt was created");

		} else {
			loadNamesFile();
		}

	}

	private static void makeNamesFile() throws Exception {
		baseFile.createNewFile();
		BufferedWriter file = new BufferedWriter(new FileWriter(baseFile));
		file.write("#Period 1 Names");
		file.newLine();
		file.newLine();
		file.write("#Period 2 Names");
		file.newLine();
		file.newLine();
		file.write("#Period 3 Names");
		file.newLine();
		file.newLine();
		file.write("#Period 4 Names");
		file.newLine();
		file.newLine();
		file.write("#Period 5 Names");
		file.newLine();
		file.newLine();
		file.write("#Period 6 Names");
		file.newLine();
		file.flush();
		file.close();
	}

	static int lines = 0;

	private static void loadNamesFile() throws Exception {
		BufferedReader file = new BufferedReader(new FileReader(baseFile));
		int currentPeriod = 0;
		String input = null;

		while ((input = file.readLine()) != null) {
			input = input.trim();

			if (input.contains("#"))
				currentPeriod++;
			else if (input.equals(" ") || input.equals("")) {
			} else
				addToArray(input, currentPeriod);
		}
		file.close();
	}

	private static void addToArray(String input, int arrayNumber) {
		ArrayList<String> array = getArray(arrayNumber);
		array.add(input);
	}

	public static ArrayList<String> getArray(int period) {
		switch (period) {
		case 1:
			return p1;
		case 2:
			return p2;
		case 3:
			return p3;
		case 4:
			return p4;
		case 5:
			return p5;
		case 6:
			return p6;
		default:
			return null;
		}
	}

	static Random rand = new Random();
	static int random;

	public static String generateNewName(int period) {
		try {
			random = rand.nextInt(getArray(MainFrame.selectedCheckbox).size());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No names were found for Period "
							+ MainFrame.selectedCheckbox);
			return null;
		}
		return getArray(MainFrame.selectedCheckbox).get(random);
	}

	@Override
	public void run() {
		try {
			checkFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}