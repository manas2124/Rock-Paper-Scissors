import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.util.Random;

public class RockPaperScissorsApp extends Application {

    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private Label resultLabel, scoreLabel, choicesLabel;
    private int wins = 0, losses = 0, draws = 0;

    @Override
    public void start(Stage stage) {
        Label title = new Label("🎮 Rock - Paper - Scissors");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        String[] icons = {"🪨 Rock", "📄 Paper", "✂️ Scissors"};

        for (int i = 0; i < 3; i++) {
            String choice = choices[i];
            Button btn = new Button(icons[i]);
            btn.setStyle("-fx-font-size: 14px;");
            btn.setOnAction(e -> playRound(choice));
            buttonBox.getChildren().add(btn);
        }

        choicesLabel = new Label("Make your choice!");
        choicesLabel.setStyle("-fx-font-size: 16px;");
        resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        scoreLabel = new Label("🏆 Wins: 0 | ❌ Losses: 0 | 🤝 Draws: 0");

        VBox root = new VBox(20, title, buttonBox, choicesLabel, resultLabel, scoreLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #fffaf0;");

        Scene scene = new Scene(root, 450, 350);
        stage.setScene(scene);
        stage.setTitle("Rock Paper Scissors Game");
        stage.show();
    }

    private void playRound(String playerChoice) {   
        String computerChoice = choices[new Random().nextInt(3)];
        String result;

        choicesLabel.setText("🧍 You: " + playerChoice + "   🤖 Computer: " + computerChoice);

        if (playerChoice.equals(computerChoice)) {
            draws++;
            result = "🤝 It's a Draw!";
        } else if (
            (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            wins++;
            result = "✅ You Win!";
        } else {
            losses++;
            result = "❌ You Lose!";
        }

        resultLabel.setText(result);
        scoreLabel.setText("🏆 Wins: " + wins + " | ❌ Losses: " + losses + " | 🤝 Draws: " + draws);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
