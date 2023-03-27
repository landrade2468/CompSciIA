public class Tutor extends Person {
    private int sum;
    public Tutor(String name, String schoolEmailAddress, String grade, String subject, String quarterForTutoring, int sum) {
        super(name, schoolEmailAddress, grade, subject, quarterForTutoring);
        this.sum = sum;
    }

    public void setSum(int newSum) {
        this.sum = newSum;
    }
}
