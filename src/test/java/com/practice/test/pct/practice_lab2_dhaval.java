package com.practice.test.pct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class practice_lab2_dhaval {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int line = Integer.parseInt(sc.nextLine());
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < line; i++) {
			String str = sc.nextLine();
			list.add(str);
		}

		Map<String, Integer> map = new HashMap<String, Integer>();

		int ngram = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < list.size(); i++) {

			if (ngram == 1) {

				String str = list.get(i);
				for (int j = 0; j < str.length(); j++) {

					String c = Character.toString(str.charAt(j));

					if (map.containsKey(c)) {
						int a = map.get(c);
						map.put(c, a + 1);
					} else {

						map.put(c, 1);

					}

				}

			}

			else if (ngram == 2) {
				String str = list.get(i);
				for (int j = 0; j < str.length() - 1; j++) {

					String c = Character.toString(str.charAt(j)) + Character.toString(str.charAt(j + 1));

					if (map.containsKey(c)) {
						int a = map.get(c);
						map.put(c, a + 1);
					} else {

						map.put(c, 1);

					}

				}

			} else if (ngram == 3) {

				String str = list.get(i);
				for (int j = 0; j < str.length() - 2; j++) {

					String c = Character.toString(str.charAt(j)) + Character.toString(str.charAt(j + 1))
							+ Character.toString(str.charAt(j + 2));

					if (map.containsKey(c)) {
						int a = map.get(c);
						map.put(c, a + 1);
					} else {

						map.put(c, 1);

					}

				}

			}

		}

		Map.Entry<String, Integer> maxentry = null;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (maxentry == null) {

				maxentry = entry;

			} else if (entry.getValue().compareTo(maxentry.getValue()) > 0) {

				maxentry = entry;

			}
		}

		String key = maxentry.getKey();
		if (ngram == 1) {
			System.out.println("Unigram" + " " + key);

		}
		if (ngram == 2) {
			System.out.println("Bigram" + " " + key);

		}
		if (ngram == 3) {
			System.out.println("Trigram" + " " + key);

		}

	}

}
