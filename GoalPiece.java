import javafx.scene.paint.Color;

public class GoalPiece extends HorizontalGamePiece {
    public GoalPiece(int x, int y) {
        super(2, Color.RED, x, y);
    }
    public boolean canMoveRightIn(GameBoard b) {
        // REPLACE THE CODE BELOW WITH YOUR OWN CODE
        boolean answer = true;
        if ((b.pieceAt(getTopLeftX() - 1, getTopLeftY()) != null)){
            answer = false;
        }
        // if game piece meet walls
        if(getTopLeftX()==0 ||getTopLeftX()==5){return false;}
        return answer;


    }
}