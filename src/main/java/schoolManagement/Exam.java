package schoolManagement;

public class Exam extends Student{
    private int examResult;

    public Exam() {
    }

    public Exam(String name, int examResult) {
        super(name);
        this.examResult = examResult;
    }

    public Exam(int examResult) {
        this.examResult = examResult;
    }

    public int getExamResult() {
        return examResult;
    }

    public void setExamResult(int examResult) {
        this.examResult = examResult;
    }
}
