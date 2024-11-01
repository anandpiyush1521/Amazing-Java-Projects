package cricinfo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Assuming the necessary imports and class definitions are present

public class CricinfoDemo {
    public static void main(String[] args) {
        CricinfoSystem cricinfoSystem = new CricinfoSystem();
        String scorecardId = "SC123";

        // Get the scorecard
        Scorecard scorecard = cricinfoSystem.getScorecard(scorecardId);

        // Update scores
        cricinfoSystem.updateScore(scorecardId, "T1", 100);
        cricinfoSystem.updateScore(scorecardId, "T2", 75);

        // Create innings
        Innings innings1 = new Innings("I1", "T1", "T2");
        Innings innings2 = new Innings("I2", "T2", "T1");

        // Add overs to innings
        Over over1 = new Over(1);
        over1.addBall(new Ball(1, "P202", "P101", "4"));
        over1.addBall(new Ball(2, "P202", "P101", "6"));
        innings1.addOver(over1);

        Over over2 = new Over(2);
        over2.addBall(new Ball(1, "P102", "P201", "1"));
        over2.addBall(new Ball(2, "P102", "P201", "0"));
        innings1.addOver(over2);

        // Add innings to the scorecard
        cricinfoSystem.addInnings(scorecardId, innings1);
        cricinfoSystem.addInnings(scorecardId, innings2);

        // Get the updated scorecard
        Scorecard updatedScorecard = cricinfoSystem.getScorecard(scorecardId);

        // Print the updated scorecard (assuming a toString method is implemented)
        System.out.println(updatedScorecard);
    }
}