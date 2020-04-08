package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		if(model.controllaParola("ciao"))
			System.out.println("true");
		
		else
			System.out.println("false");

	}

}
