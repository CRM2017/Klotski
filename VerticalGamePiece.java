import javafx.scene.paint.Color;

public class VerticalGamePiece extends GamePiece {
    public VerticalGamePiece(int h, Color c, int x, int y) {
        super(1, h, c, x, y);
    }

    public boolean canMoveDownIn(GameBoard b) {
        // REPLACE THE CODE BELOW WITH YOUR OWN CODE
        boolean answer = true;
        if ((b.pieceAt(getTopLeftX() , getTopLeftY()+height) != null)){
            answer = false;
        }
        // if game piece meet walls
        if(getTopLeftY()+height==6){return false;}

        return answer;
    }
    public boolean canMoveUpIn(GameBoard b) {
        // REPLACE THE CODE BELOW WITH YOUR OWN CODE
        boolean answer = true;
        if ((b.pieceAt(getTopLeftX(), getTopLeftY()+1) != null)){
            answer = false;
        }
        // if game piece meet walls
        if(getTopLeftY()==0){return false;}

        return answer;
    }
}