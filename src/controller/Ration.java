package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import model.AllDetails;
import service.RationCalculation;

public class Ration {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int quantity_in_kgs;
		
		double sizes[]= {0.5,1,2,5};
		
		int[] logistics_constraints=new int[4];
		
		int topups[]=new int[4];
		
		int[] available_capacity =new int[4];
		
		System.out.println(" enter the quantity_in_kgs");
		
		quantity_in_kgs=Integer.parseInt(br.readLine());
		
		System.out.println("enter logistics_constraints");
		
		for(int i=0;i<4;i++)
		{
			logistics_constraints[i]=Integer.parseInt(br.readLine());
			
		}
		
		System.out.println("enter topups");
		
		for(int i=0;i<4;i++) {
			
			topups[i]=Integer.parseInt(br.readLine());
		}
		
		
		System.out.println("enter available_capacity");
		
		for(int i=0;i<4;i++) {
			
			available_capacity[i]=Integer.parseInt(br.readLine());
			
		}
		//creating object 
		
		//calling allocation formula
		HashMap<Integer, AllDetails> map=RationCalculation.allocate(quantity_in_kgs,sizes,logistics_constraints,topups,available_capacity);
		
		//calling printing method to print.
		RationCalculation.print(map);
		
		
	}
	
	

}
