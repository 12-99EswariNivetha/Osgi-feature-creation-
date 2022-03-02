package com.launchclub;

import java.util.Scanner;

public class Addition {
	
	public static void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1st Number:");
        int m=scanner.nextInt();
        System.out.println("Enter 2nd Number:");
        int n= scanner.nextInt();
        int sum =m+n;
        System.out.println("Addition of 2 Numbers:"+sum);
        
    }
}
