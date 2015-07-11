package controler;

import java.util.ArrayList;

import View.GameFrame;
import model.Case;
import model.Game;
import model.Token;

public class ActionController {

	private Game game;
	private GameFrame view;
	
	public ActionController(Game game){
		this.game = game;
		this.view = new GameFrame(game);
	}
	
	public void CheckTurn(int x, int y){
		
		Case fromCase = game.Token().Position();
		Case toCase = game.CaseByXY(x, y);
		
		//Teste si la case cliquée est atteignable avec la valeur actuelle du pion
		ArrayList<Case> reachableCells = GetReachableCells();
		
		if(reachableCells.contains(toCase)){
			game.Token().Position(toCase);
			toCase.HasPion(true);
			fromCase.HasPion(false);
			
			//Mise à jour de la valeur de déplacement du pion : test si la nouvelle valeur <= 3
			if((game.Token().Value() + toCase.Value()) <= 3){
				game.Token().Value(game.Token().Value() + toCase.Value());
			}
		}
	
		if(hasWon()){
			//Return view victoire
		}
		else if(hasLost()){
			//return view défaite
		}
		else{
			//update wiew
		}
	}
	
	//Check if the current token position is the end case
	public boolean hasWon(){
		return game.Token().Position() == game.End() ? true : false;
	}
	
	//Check if the player has lost the game. The game is lost if
	public boolean hasLost(){
		//The token has lowered its moving value to 0 (can't move anymore)
		if(game.Token().Value() == 0){
			return true;
		}
		//It can't reach any case with it's current moving value
		if(GetReachableCells().isEmpty()){
			return true;
		}
		//Else, the game continues.
		return false;
	}
	
	private ArrayList<Case> GetReachableCells(){
	
		Token t = game.Token();
	
		ArrayList<Case> reachableCells = new ArrayList<Case>();
		
		try{
			reachableCells.add(game.CaseByXY(t.Position().X() + t.Value(), t.Position().Y())); 
		}
		catch(IllegalArgumentException e){}
		try{
			reachableCells.add(game.CaseByXY(t.Position().X() - t.Value(), t.Position().Y())); 
		}
		catch(IllegalArgumentException e){}
		try{
			reachableCells.add(game.CaseByXY(t.Position().X(), t.Position().Y() + t.Value())); 
		}
		catch(IllegalArgumentException e){}
		try{
			reachableCells.add(game.CaseByXY(t.Position().X(), t.Position().Y() - t.Value())); 
		}
		catch(IllegalArgumentException e){}
		
		return reachableCells;
	}
}
