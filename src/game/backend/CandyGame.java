package game.backend;

import game.backend.cell.Cell;
import game.backend.element.Element;
import game.backend.element.Fruit;
import game.backend.element.FruitType;
import game.backend.level.Level1;

public class CandyGame implements GameListener {

	private Class<?> levelClass;
	private Grid grid;
	protected GameState state;
	
	public CandyGame(Class<?> clazz) {
		this.levelClass = clazz;
	}


	public Class<?> getLevelClass() {
		return levelClass;
	}

	public void initGame() {
		try {
			this.grid = (Grid)this.levelClass.newInstance(); //TODO DEPRECATED
		} catch(IllegalAccessException | InstantiationException e) {
			System.out.println("ERROR AL INICIAR");
		}
		this.state = this.grid.createState();
		this.grid.initialize();
		addGameListener(this);
	}
	
	public int getSize() {
		return Grid.SIZE;
	}
	
	public boolean tryMove(int i1, int j1, int i2, int j2){
		return grid.tryMove(i1, j1, i2, j2);
	}

	/*
		Returns the cell in the given position (i, j)
	 */
	public Cell get(int i, int j){
		return grid.getCell(i, j);
	}
	
	public void addGameListener(GameListener listener) {
		grid.addListener(listener);
	}
	
	public long getScore() {
		return state.getScore();
	}
	
	public boolean isFinished() {
		return state.gameOver();
	}
	
	public boolean playerWon() {
		return state.playerWon();
	}

	public int getMovesLeft() { return state.getMaxMoves() - state.getMoves();};
	
	@Override
	public void cellExplosion(Element e) {
		state.addScore(e.getScore());
	}
	
	@Override
	public void gridUpdated() {
		//
	}

}
