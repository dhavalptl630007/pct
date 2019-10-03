package com.practice.test.pct;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab12 {

	public static void main(String[] args) {

		int count = 0;

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();

		int sum = Integer.parseInt(sc.nextLine());

		int size = Integer.parseInt(sc.nextLine());

		String[] arr = sc.nextLine().split("\\s+");

		for (int i = 0; i < size; i++) {
			list.add(Integer.parseInt(arr[i]));

		}

		// generate all possible combination

		for (int i = 0; i < list.size(); i++) {
			int t_sum = 0;
			int p_count = 0;

			
			
			if (sum == list.get(i))

			{
				System.out.println(list.get(i));
				count++;
			}

			for (int j = i+1; j < list.size(); j++) {

				t_sum = t_sum + list.get(i);
				
				while(t_sum < sum && j < list.size()) {
					
					t_sum = t_sum + list.get(j);
					
					if(t_sum == sum) {
						count++;
					}
					j++;
				}
				
				if(t_sum == sum) {
					t_sum = 0;
					break;
				}
				
				t_sum = 0;
				
				
				/*
				if (t_sum <= sum) {
				
					if (p_count == 0) {
						t_sum = t_sum + list.get(i) + list.get(j);
						p_count++;
					}
					else if (p_count> 0)
					{
						t_sum = t_sum + list.get(j);
						p_count++;
					}

				} else {
					t_sum = list.get(i) + list.get(j);
				}

				if (t_sum == sum) {
					System.out.println(list.get(i) + " " + list.get(j));

					count++;
				}
				*/

			}
		}

		System.out.println(count);

	}

}
