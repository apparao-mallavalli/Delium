package service;

import java.util.HashMap;

import model.AllDetails;

public class RationCalculation {
	
//allocation function 
public static HashMap<Integer, AllDetails> allocate(int quantity_in_kgs, double []sizes,int[] logistics_constraints,int topups[],int available_capacity[] ) {
		
		int allocations[]=new int[4];
		
		int post_allocations[]=new int[4];
		
		int available_capacity_in_kgs[]=new int[4];
		
		//used to store remaining after minimum logistics_constraints
		int temp_available[] =new int[4];
		
		//used for to store minimum capacity present or not
		int a[]=new int[4];
		
		//checking available capacity is greater than minimum capacity or not
		for(int i=0;i<4;i++)
		{
			if(available_capacity[i]-logistics_constraints[i]>=0)
			{
			   	
				a[i]=logistics_constraints[i];
				temp_available[i]=available_capacity[i]-logistics_constraints[i];
			}
			else
			{
				a[i]=0;
				temp_available[i]=0;
				
			}
		}
		
		int reminder=quantity_in_kgs;
		
		int temp_kgs=quantity_in_kgs;
		
		// counts no of possible topups
		int half,full,doubl,fifth;
       
		 half =  temp_available[0]/topups[0];
         full =  temp_available[1]/topups[1];
         doubl=  temp_available[2]/topups[2];
         fifth=  temp_available[3]/topups[3];
      
		
		//creating array for storing posiible topup values
		int first[]=new int[half+2];
		int second[]=new int[full+2];
		int third[]=new int[doubl+2];
		int fourth[]=new int[fifth+2];
		
		//initializing first element with zero,used for not selecting the topup.
		first[0]=0; first[1]=(int) (a[0]*sizes[0]);
		second[0]=0;second[1]=(int) (a[1]*sizes[1]);
		third[0]=0;third[1]=(int) (a[2]*sizes[2]);
		fourth[0]=0;fourth[1]=(int) (a[3]*sizes[3]);
		
		//initialzing topup values in kgs
		for(int i=2;i<first.length;i++)
			
		    first[i]=  (int) (first[i-1]+ (int)topups[0]*(sizes[0]));
			
		
		for(int i=2;i<second.length;i++)
			second[i]=(int) (second[i-1]+topups[1]*(sizes[1]));
		
		for(int i=2;i<third.length;i++)
			third[i]=(int) (third[i-1]+topups[2]*(sizes[2]));
		
		for(int i=2;i<fourth.length;i++)
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
