package javafxartwork;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class JavaFXArtWork extends Application {
    private String cout;
    
    @Override
    public void start(Stage primaryStage) {
    primaryStage.setTitle("Drawing Operations Test");
    Group root = new Group();
    Canvas canvas = new Canvas (700, 700);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    drawWords(gc);
    drawMatthew(gc);
    drawShapes(gc);
    drawTheSecondPart(gc);
    drawTheFirstPart(gc);
    drawTheThirdPart(gc);
    drawSmoke1(gc);
    drawSmoke2(gc);
    drawSmoke3(gc);
    drawDoor(gc);
    drawWindow(gc);
    drawWindow2(gc);
    drawLotsOfBackground(gc, 30);
    drawMoon(gc, 200, 50, 100);
    drawLotsOfSmoke(gc, 100, 75, 10);
    root.getChildren().add(canvas);
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
    }
    
private void drawMatthew(GraphicsContext psychic) {
    psychic.fillText("Matthew Mandell", 550, 650);
    psychic.setStroke(Color.BLACK);
    psychic.setLineWidth(1);
}

private void drawWords(GraphicsContext wt) {
wt.fillText("It's a house?",325, 450);
wt.setFill(Color.CRIMSON);
wt.setStroke(Color.CRIMSON);
wt.setLineWidth(700);

    }
   private void drawDoor (GraphicsContext dd) {
       dd.fillRect(350, 335, 25, 70);
       dd.setFill(Color.KHAKI);
   }
   private void drawWindow (GraphicsContext dw) {
       dw.fillRect(300, 270, 30, 30);
       dw.setFill(Color.ALICEBLUE);
   }
   private void drawWindow2 (GraphicsContext dw2) {
       dw2.fillRect(400, 270, 30, 30);
       dw2.setFill(Color.ALICEBLUE);
   }
private void drawShapes(GraphicsContext gc) {
       gc.setFill(Color.BLACK);
}
private void drawTheThirdPart (GraphicsContext ttp) {
    ttp.fillRect(360, 110, 20, 55);
    ttp.strokeRect(360, 110, 20, 55);
    ttp.setFill(Color.BLACK);
    ttp.setStroke(Color.BLACK);
    }
    private void drawTheSecondPart(GraphicsContext tsp) {
      tsp.fillArc(290, 120, 160, 250, 0, 180, ArcType.OPEN);
      tsp.strokeArc(290, 120, 160, 250, 0, 180, ArcType.OPEN);
      tsp.setLineWidth(10);
      tsp.setStroke(Color.CRIMSON);
      tsp.setFill(Color.CRIMSON);
    }
  private void drawTheFirstPart (GraphicsContext tfp) {
        tfp.fillRect(300, 250, 140, 150);
        tfp.strokeRect(300, 250, 140, 150);
    }
   private void drawSmoke1 (GraphicsContext ds1) {
       ds1.fillOval(350, 90, 15, 15);
       ds1.setFill(Color.BLACK);
   }
   private void drawSmoke2 (GraphicsContext ds2) {
       ds2.fillOval(360, 65, 25, 25);
       ds2.setFill(Color.BLACK);
}
   private void drawSmoke3 (GraphicsContext ds3) {
       ds3.fillOval(340, 75, 7, 7);
       ds3.setFill(Color.BLACK);
}
    private void drawLotsOfBackground(GraphicsContext gc, int num) {
    for (int i = 0; i < 50; i+= 5){
     drawLotsOfSmoke(gc, 7 * i, (7 * i), 7);
     gc.setFill(Color.BLACK);
    }
    }
    private void drawLotsOfSmoke(GraphicsContext gc, int x, int y, int d) {
        gc.fillOval(350, y, 10, 10);
        gc.setFill(Color.BLACK);
    }
private void drawMoon(GraphicsContext gc, int x, int y, int d) {
        gc.fillOval(100, 50, 100, 100);
        gc.setFill(Color.DARKGREY);
    }



} 
