import javafx.scene.paint.Color;

public class HorizontalGamePiece extends GamePiece {
    public HorizontalGamePiece(int w, Color c, int x, int y) {
        super(w, 1, c, x, y);
    }
    public boolean canMoveLeftIn(GameBoard b) {
        // REPLACE THE CODE BELOW WITH YOUR OWN CODE
        boolean answer = true;
        if ((b.pieceAt(getTopLeftX() - 1, getTopLeftY()) != null)){
            answer = false;
        }
        // if game piece meet walls
        if(getTopLeftX()==0){return false;}
        return answer;

    }
    public boolean canMoveRightIn(GameBoard b) {
        // REPLACE THE CODE BELOW WITH YOUR OWN CODE
        boolean answer = true;
        if ((b.pieceAt(getTopLeftX() + width, getTopLeftY()) != null)){
            answer = false;
        }

        if(getTopLeftX()+width == 6){answer =false;}
        return answer;
    }
}