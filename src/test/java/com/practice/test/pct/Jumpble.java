package com.practice.test.pct;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Jumpble {

	static LinkedList<Integer> list = new LinkedList<Integer>();
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	//int n = Integer.parseInt(sc.nextLine());
	
	 list.add(1);
	 list.add(2);
	 list.add(3);
	
	System.out.println(list);
	//1->3
	//0->2
	
	int temp = list.get(0);
	
	list.set(0,list.get(2));
	list.set(2,temp);

	System.out.println(list);
	
	
	
	
	}
}

class Panel extends JPanel {

    public Panel() {
        setLayout(new java.awt.GridLayout(4, 4));
        for (int i = 0; i < 16; ++i) {
            JButton b = new JButton(String.valueOf(i));
            b.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    //...
                }
            });
            add(b);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(300, 300));
                frame.add(new Panel());
                frame.setVisible(true);
            }
        });
    }
}
