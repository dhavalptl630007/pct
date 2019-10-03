package com.practice.test.pct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

	List<Integer> list = new ArrayList<Integer>();
	list.add(1);
	list.add(2);
	list.add(3);
	
	System.out.print(list);
	//Collections.shuffle(list);
	Collections.rotate(list, -2);
	//Collections.rotate(list, 1);
	//Collections.rotate(list, 1);
	//Collections.shuffle(list);
	//Collections.shuffle(list);
	System.out.print(list);
	}

}
