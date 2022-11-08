import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Jordle class.
 *
 * @author CS1331
 * @version 1
 */
public class Jordle extends Application {
    @Override
    public void start(Stage primaryStage) {
        final String[] guessWord = {Words.list.get((int) Math.round(Math.random() * Words.list.size())).toUpperCase()};
        VBox root = new VBox();
        Label label = new Label("Jordle");
        label.setFont(new Font("Arial", 30));
        label.setPadding(new Insets(5, 5, 5, 5));
        label.setAlignment(Pos.CENTER);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        Rectangle[][] rectangles = {
            {new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE)},
            {new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE)},
            {new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE)},
            {new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE)},
            {new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE)},
            {new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE), new Rectangle(40, 40, Color.WHITE),
                new Rectangle(40, 40, Color.WHITE)}};
        Label[][] labels = {
            {new Label(""), new Label(""), new Label(""), new Label(""), new Label("")},
            {new Label(""), new Label(""), new Label(""), new Label(""), new Label("")},
            {new Label(""), new Label(""), new Label(""), new Label(""), new Label("")},
            {new Label(""), new Label(""), new Label(""), new Label(""), new Label("")},
            {new Label(""), new Label(""), new Label(""), new Label(""), new Label("")},
            {new Label(""), new Label(""), new Label(""), new Label(""), new Label("")}
        };
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                gridPane.add(rectangles[row][col], col, row);
                gridPane.add(labels[row][col], col, row);
            }
        }
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15, 20, 10, 10));
        hBox.setAlignment(Pos.BASELINE_CENTER);
        Label label2 = new Label("Try guessing a word!");
        Button btn1 = new Button("Restart");
        Button btn2 = new Button("Instructions");
        hBox.getChildren().add(label2);
        hBox.getChildren().add(btn1);
        hBox.getChildren().add(btn2);
        root.getChildren().add(label);
        root.getChildren().add(gridPane);
        root.getChildren().add(hBox);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 590, 800);
        primaryStage.setTitle("Jordle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();

        final int[] currentX = {0};
        final int[] currentY = {0};
        btn1.setOnMouseClicked(e -> {
            label2.setText("Try guessing a word!");
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 5; col++) {
                    rectangles[row][col].setFill(Color.WHITE);
                    labels[row][col].setText("");
                }
            }
            currentX[0] = 0;
            currentY[0] = 0;
            guessWord[0] = Words.list.get((int) Math.round(Math.random() * Words.list.size())).toUpperCase();
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Pane pane = new Pane();
                Text text = new Text(10.0, 25.0, "Welcome to Jordle! Try Guess some words by typing. "
                        + "The word contains 5 character, and you have 6 chances to guess it! After typing the word, "
                        + "press return to check the correctness. If it is yellow, which means the word contains the "
                        + "character, but not in the correct position. If it is green, which means the word contains "
                        + "the character and in the correct position. If it is grey, which means that the guess is not "
                        + "correct.");
                text.setWrappingWidth(590);
                pane.getChildren().add(text);
                Stage stage = new Stage();
                stage.setTitle("Instructions");
                stage.setScene(new Scene(pane, 600, 400));
                stage.show();
            }
        });
        scene.setOnKeyPressed(e -> {
            if (e.getCode().isLetterKey()) {
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText(e.getText());
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            } else {
                switch (e.getCode()) {
                case BACK_SPACE:
                    if (currentX[0] > 0) {
                        labels[currentY[0]][currentX[0] - 1].setText("");
                        currentX[0]--;
                    }
                    return;
                case ENTER:
                    if (currentX[0] == 5) {
                        int count = 0;
                        for (int i = 1; i < 6; i++) {
                            if (guessWord[0].substring(5 - i, 6 - i).
                                    equals(labels[currentY[0]][currentX[0] - i].getText())) {
                                rectangles[currentY[0]][currentX[0] - i].setFill(Color.GREEN);
                                count++;
                            } else if (guessWord[0].contains(labels[currentY[0]][currentX[0] - i].getText())) {
                                rectangles[currentY[0]][currentX[0] - i].setFill(Color.YELLOW);
                            } else {
                                rectangles[currentY[0]][currentX[0] - i].setFill(Color.GRAY);
                            }
                        }
                        currentY[0]++;
                        currentX[0] = 0;
                        if (count == 5) {
                            label2.setText("Congratulations! You've guessed the word!");
                            currentY[0] = 6;
                        } else if (currentY[0] == 6) {
                            label2.setText("Game over. The word was " + guessWord[0].toLowerCase() + ".");
                        }
                    } else {
                        Pane pane = new Pane();
                        Text text = new Text(10.0, 25.0, "Please enter a 5-letter word.");
                        text.setWrappingWidth(590);
                        pane.getChildren().add(text);
                        Stage stage = new Stage();
                        stage.setTitle("Error");
                        stage.setScene(new Scene(pane, 400, 200));
                        stage.show();
                    }
                    return;
                default:
                    return;
                }
            }
        });
    }
}

/*
            switch (e.getCode()) {
            case A:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("A");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case B:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("B");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case C:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("C");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case D:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("D");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case E:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("E");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case F:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("F");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case G:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("G");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case H:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("H");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case I:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("I");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case J:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("J");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case K:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("K");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case L:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("L");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case M:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("M");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case N:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("N");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case O:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("O");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case P:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("P");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case Q:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("Q");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case R:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("R");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case S:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("S");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case T:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("T");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case U:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("U");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case V:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("V");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case W:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("W");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case X:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("X");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case Y:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("Y");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;
            case Z:
                if (currentX[0] <= 4 && currentY[0] <= 5) {
                    labels[currentY[0]][currentX[0]].setText("Z");
                    labels[currentY[0]][currentX[0]].setFont(new Font("Arial", 24));
                    labels[currentY[0]][currentX[0]].setPadding(new Insets(5, 5, 5, 12));
                    currentX[0]++;
                }
                return;


            case BACK_SPACE:
                if (currentX[0] > 0) {
                    labels[currentY[0]][currentX[0] - 1].setText("");
                    currentX[0]--;
                }
                return;
            case ENTER:
                if (currentX[0] == 5) {
                    int count = 0;
                    for (int i = 1; i < 6; i++) {
                        if (guessWord[0].substring(5 - i, 6 - i).equals(labels[currentY[0]][currentX[0] - i].getText()))
                        {
                            rectangles[currentY[0]][currentX[0] - i].setFill(Color.GREEN);
                            count++;
                        } else if (guessWord[0].contains(labels[currentY[0]][currentX[0] - i].getText())) {
                            rectangles[currentY[0]][currentX[0] - i].setFill(Color.YELLOW);
                        } else {
                            rectangles[currentY[0]][currentX[0] - i].setFill(Color.GRAY);
                        }
                    }
                    currentY[0]++;
                    currentX[0] = 0;
                    if (count == 5) {
                        label2.setText("Congratulations! You've guessed the word!");
                        currentY[0] = 6;
                    } else if (currentY[0] == 6) {
                        label2.setText("Game over. The word was " + guessWord[0].toLowerCase() + ".");
                    }
                } else {
                    Pane pane = new Pane();
                    Text text = new Text(10.0, 25.0, "Please enter a 5-letter word.");
                    text.setWrappingWidth(590);
                    pane.getChildren().add(text);
                    Scene scene2 = new Scene(pane, 400, 200);
                    Stage stage = new Stage();
                    stage.setTitle("Error");
                    stage.setScene(scene2);
                    stage.show();
                }
                return;
            default:
                return;
            }

             */