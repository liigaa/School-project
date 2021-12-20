package schoolManagement;

public class Course extends Teacher{
    private String title;



    public Course(String title) {
        this.title = title;
    }

    public Course(String title, String name) {
        super(name);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "\n>>Course " + title + " with Teacher " + getName();
    }


}
