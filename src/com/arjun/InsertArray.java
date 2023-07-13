package com.arjun;

public class InsertArray {

	public static void main(String[] args) {
		int a[] = new int[5];
		a[0] = 7;
		a[1] = 9;
		a[2] = 2;
		a[3] = 8;
		a[4] = 4;
		a[0] = 9;
		a[1+2] = 10;
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
