import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SliderPuzzleApp extends Application {
    private SliderPuzzleGame    model;
    private SliderPuzzleView    view;

    private GamePiece           selectedPiece;
    private boolean             justGrabbed;
    private int                 lastX;
    private int                 lastY;

    public void start(Stage primaryStage) {
        model = new SliderPuzzleGame();
        view = new SliderPuzzleView(model);

        // Add event handlers to the inner game board buttons
        for (int w=1; w<=(GameBoard.WIDTH); w++) {
            for (int h=1; h<=(GameBoard.HEIGHT); h++) {
                view.getGridSection(w, h).setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent mouseEvent) {
                        handleGridSectionSelection(mouseEvent);
                    }
                });
                view.getGridSection(w, h).setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent mouseEvent) {
                        handleGridSectionMove(mouseEvent);
                    }
                });
            }
        }

        // Plug in the Start button and NeaxtBoard button event handlers
        view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.startBoard();
                view.update();
            }
        });
        view.getNextBoardButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.moveToNextBoard();
                view.update();
            }
        });

        primaryStage.setTitle("Slide Puzzle Application");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(view, -10+SliderPuzzleView.GRID_UNIT_SIZE*(GameBoard.WIDTH+2),45+SliderPuzzleView.GRID_UNIT_SIZE*(GameBoard.HEIGHT+2)));
        primaryStage.show();

        // Update the view upon startup
        view.update();


    }


    private void handleGridSectionSelection(MouseEvent mouseEvent) {
        // FILL IN YOUR CODE
        for (int x = 1; x < 7; x++) {
            for (int y = 1; y < 7; y++) {
                if(mouseEvent.getSource()== view.getGridSection(x,y)){
                    lastX = x-1;
                    lastY = y-1;
                }
            }
        }
        selectedPiece = model.getCurrentBoard().pieceAt(lastX,lastY);
        justGrabbed = true;
    }




    private void handleGridSectionMove(MouseEvent mouseEvent) {
        int currentGridX = (int)mouseEvent.getX();
        int currentGridY = (int)mouseEvent.getY();

        // FILL IN YOUR CODE

        if ((currentGridX-lastX)>= view.GRID_UNIT_SIZE){
            if (selectedPiece.canMoveRightIn(model.getCurrentBoard())&&justGrabbed){
                selectedPiece.moveRight();
                justGrabbed =false;
                model.makeAMove();
                view.update();
            }

        }
        else if((currentGridX-lastX)<0){
            if (selectedPiece.canMoveLeftIn(model.getCurrentBoard())&&justGrabbed){
                selectedPiece.moveLeft();
                justGrabbed =false;
                model.makeAMove();
                view.update();
            }

        }
        else if(currentGridY-lastY>=view.GRID_UNIT_SIZE) {
            if (selectedPiece.canMoveDownIn(model.getCurrentBoard())&&justGrabbed){
                selectedPiece.moveDown();
                justGrabbed =false;
                model.makeAMove();
                view.update();
            }
        }
        else if(currentGridY-lastY<0) {
            if (selectedPiece.canMoveUpIn(model.getCurrentBoard())&&justGrabbed){
                selectedPiece.moveUp();
                justGrabbed =false;
                model.makeAMove();
                view.update();
            }
        }
    }

    public static void main(String[] args) { launch(args); }
}
