package model;

public class Token {
	
	private int value;
	private Case position;

	public Token(Case position){
		this.position = position;
		this.value = 1;
	}
	
	public Case Position(){
		return this.position;
	}
	
	public void Position(Case c){
		this.position = c;
	}
	
	public int Value(){
		return this.value;
	}
	
	public void Value(int v){
		this.value = v;
	}
}
