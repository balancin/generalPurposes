package br.com.balancin;

import br.com.balancin.stream.impl.StreamImpl;

public class Testcase {

	public static void main(String args[]){
		
		System.out.println("teste");
		StreamImpl testcase = new StreamImpl("aAbBABac");
		
		while(testcase.hasNext()){
			System.out.println(testcase.getNext());
		}
		
	}
	
}
