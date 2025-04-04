abstract class Course {
    protected String courseCode;
    protected String title;
    protected int creditHours;
    
    public Course(String code, String title, int credits) {
        this.courseCode = code;
        this.title = title;
        this.creditHours = credits;
    }
    
    abstract void conductClass();
    abstract void gradeStudents();
    
    void displayCourseInfo() {
        System.out.println(courseCode + ": " + title + " (" + creditHours + " credits)");
    }
}

class ProgrammingCourse extends Course {
    public ProgrammingCourse(String code, String title, int credits) {
        super(code, title, credits);
    }
    
    void conductClass() {
        System.out.println("Teaching programming concepts with live coding");
    }
    
    void gradeStudents() {
        System.out.println("Grading based on projects and exams");
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        Course javaCourse = new ProgrammingCourse("CS101", "Introduction to Java", 4);
        
        javaCourse.displayCourseInfo();
        javaCourse.conductClass();
        javaCourse.gradeStudents();
    }
}
