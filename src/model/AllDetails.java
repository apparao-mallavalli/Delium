package model;

import java.util.Arrays;

public class AllDetails {
	
	
	int remainder;
	
	double variant[]=new double[4];
	
	int[] uoms=new int[4];
	
	int allocations[]=new int[4];
	
	int[] post_alloc_capacity=new int[4];

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	public double[] getVariant() {
		return variant;
	}

	public void setVariant(double[] variant) {
		this.variant = variant;
	}

	public int[] getUoms() {
		return uoms;
	}

	public void setUoms(int[] uoms) {
		this.uoms = uoms;
	}

	public int[] getAllocations() {
		return allocations;
	}

	public void setAllocations(int[] allocations) {
		this.allocations = allocations;
	}

	public int[] getPost_alloc_capacity() {
		return post_alloc_capacity;
	}

	public void setPost_alloc_capacity(int[] post_alloc_capacity) {
		this.post_alloc_capacity = post_alloc_capacity;
	}

	public AllDetails(int remainder, double[] variant, int[] uoms, int[] allocations, int[] post_alloc_capacity) {
		super();
		this.remainder = remainder;
		this.variant = variant;
		this.uoms = uoms;
		this.allocations = allocations;
		this.post_alloc_capacity = post_alloc_capacity;
	}

	@Override
	public String toString() {
		return "AllDetails [remainder=" + remainder + ", variant=" + Arrays.toString(variant) + ", uoms="
				+ Arrays.toString(uoms) + ", allocations=" + Arrays.toString(allocations) + ", post_alloc_capacity="
				+ Arrays.toString(post_alloc_capacity) + "]";
	}


}
