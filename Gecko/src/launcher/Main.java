package launcher;

import model.Game;
import controler.ActionController;
import controler.Loader;

public class Main {

	public static void main(String[] args) {
		//Loader dataGridLoader = new Loader("");
		Game grid = new Game("VBRRBRRBVRRBARVBRRVBBRRRD");
		ActionController gameController = new ActionController(grid);
	}
}
