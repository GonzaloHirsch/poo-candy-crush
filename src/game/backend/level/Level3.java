package game.backend.level;

//  Cage/Jaula Level

import game.backend.element.CagedCandy;
import game.backend.element.Candy;

public class Level3 extends Level1 {


    @Override
    public  void fillCells(){
        super.fillCells();
    }

    @Override
    public void initialize(){
        super.initialize();
        setCagedCandy();
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        return super.tryMove(i1,j1,i2,j2);
    }

    private void setCagedCandy(){
        for(int i = 1; i < SIZE-1; i++) {
            g()[4][i].setContent(new CagedCandy(((Candy) g()[4][i].getContent()).getColor()));
        }
    }
}
