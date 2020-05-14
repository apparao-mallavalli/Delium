package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import model.AllDetails;

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
		
		//calling allocation formula
		HashMap<Integer, AllDetails> map=allocate(quantity_in_kgs,sizes,logistics_constraints,topups,available_capacity);
		
		//calling printing method to print.
		print(map);
		
		
	}
	
	public static HashMap<Integer, AllDetails> allocate(int quantity_in_kgs, double []sizes,int[] logistics_constraints,int topups[],int available_capacity[] ) {
		
		int allocations[]=new int[4];
		
		int post_allocations[]=new int[4];
		
		int available_capacity_in_kgs[]=new int[4];
		
		int reminder=quantity_in_kgs;
		System.out.println(reminder);
		int temp_kgs=quantity_in_kgs;
		
		// counts no of possible topups
		int half,full,doubl,fifth;
       
		 half =  available_capacity[0]/topups[0];
         full =  available_capacity[1]/topups[1];
         doubl=  available_capacity[2]/topups[2];
         fifth=  available_capacity[3]/topups[3];
      
		
		//creating array for storing posiible topup values
		int first[]=new int[half+1];
		int second[]=new int[full+1];
		int third[]=new int[doubl+1];
		int fourth[]=new int[fifth+1];
		
		//initializing first element with zero,used for not selecting the topup.
		first[0]=0;
		second[0]=0;
		third[0]=0;
		fourth[0]=0;
		
		//initialzing topup values in kgs
		for(int i=1;i<=half;i++)
			
		    first[i]=  (int) (first[i-1]+ (int)topups[0]*(sizes[0]));
			
		
		for(int i=1;i<=full;i++)
			second[i]=(int) (second[i-1]+topups[1]*(sizes[1]));
		
		for(int i=1;i<=doubl;i++)
			third[i]=(int) (third[i-1]+topups[2]*(sizes[2]));
		
		for(int i=1;i<=fifth;i++)
			fourth[i]=(int) (fourth[i-1]+topups[3]*(sizes[3]));
		
		//
		
		
		// retrieving  all the elements to get best possibility
		
		for(int i=0;i<first.length;i++)
			for(int j=0;j<second.length;j++)
				for(int k=0;k<third.length;k++)
					for(int l=0;l<fourth.length;l++)
					{
						int total=first[i]+second[j]+third[k]+fourth[l];
						
						
						if(total<=(quantity_in_kgs+1))
						{
							
							//System.out.println(total);
							
							if(reminder>=(quantity_in_kgs-total)) {
								reminder=quantity_in_kgs-total;
								//System.out.println(reminder);
								
								//storing the units into allocation array
								allocations[0]=(int) (first[i]/sizes[0]);
								allocations[1]=(int) (second[j]/sizes[1]);
								allocations[2]=(int) (third[k]/sizes[2]);
								allocations[3]=(int) (fourth[l]/sizes[3]);
								
								
								//storing remaining units in post allocation memory
								for(int m=0;m<4;m++)
								post_allocations[m]= available_capacity[m]-allocations[m];
							
							}
								
						}
						else
							break;
						
					}
		
		AllDetails allDetails=new AllDetails(reminder,sizes,logistics_constraints,allocations,post_allocations);
		
		HashMap<Integer, AllDetails> map = new HashMap<>(); 
		
		map.put(1,allDetails);
		
		return map;
		
	}
	
	//printing method
	
	public static void print(HashMap<Integer, AllDetails> map) {
		
		AllDetails details= map.get(1);
		
		System.out.println(details.toString());
				
	}


}
