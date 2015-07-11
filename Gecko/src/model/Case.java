package model;

import java.awt.Color;

public class Case {

	private int x;
	private int y;
	private Color color;
	private CaseType type;
	private int value;
	private boolean hasPion;
	
	public Case(int posX, int posY, char caseId){
		this.x = posX;
		this.y = posY;
		
		switch(caseId){
			case 'D':
				this.type = CaseType.DEPART;
				this.color = Color.WHITE;
				this.value = 0;
				this.hasPion = true;
			break;
			case 'B':
				this.type = CaseType.REGULAR;
				this.color = Color.BLUE;
				this.value = -1;
				this.hasPion = false;
			break;
			case 'V':
				this.type = CaseType.REGULAR;
				this.color = Color.GREEN;
				this.value = 0;
				this.hasPion = false;
			break;
			case 'R':
				this.type = CaseType.REGULAR;
				this.color = Color.RED;
				this.value = 1;
				this.hasPion = false;
			break;
			case 'A':
				this.type = CaseType.ARRIVEE;
				this.color = Color.BLACK;
				this.value = 0;
				this.hasPion = false;
			break;
		}
	}

	public int X() {
		return x;
	}

	public int Y() {
		return y;
	}
	
	public int Value(){
		return this.value;
	}
	
	public Color Color(){
		return this.color;
	}
	
	public CaseType Type(){
		return this.type;
	}
	
	public boolean HasPion(){
		return this.hasPion;
	}
	
	public void HasPion(boolean b){
		this.hasPion = b;
	}
}
