import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private final int id;
    private final String name;
    private final List<Score> scores;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.scores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Score> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public void addScore(Subject subject, double value) {
        scores.add(new Score(subject, value));
    }

    public double getScore(Subject subject) {
        for (Score score : scores) {
            if (score.getSubject().equals(subject)) {
                return score.getValue();
            }
        }
        return 0;
    }

    public void updateScore(Subject subject, double value) {
        for (Score score : scores) {
            if (score.getSubject().equals(subject)) {
                score.setValue(value);
                return;
            }
        }
        addScore(subject, value);
    }

    public double calculateAverage() {
        if (scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Score score : scores) {
            sum += score.getValue();
        }

        return sum / scores.size();
    }
}
