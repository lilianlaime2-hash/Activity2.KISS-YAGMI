public class Score {

    private Subject subject;
    private double value;

    public Score(Subject subject, double value) {
        this.subject = subject;
        this.value = value;
    }

    public Score(String subjectName, double value) {
        this(new Subject(subjectName), value);
    }

    public Subject getSubject() {
        return subject;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
