package schoolManagement;

import javax.swing.*;
import java.util.ArrayList;

public class School {
    public ArrayList<Student> students;
    public ArrayList<Teacher> teachers;
    public ArrayList<Course> courses;
    public ArrayList<Exam> exams;
    public ArrayList<Course> teacherCourse;

    public School(){
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses= new ArrayList<>();
        this.exams = new ArrayList<>();
        this.teacherCourse = new ArrayList<>();
    }


    public ArrayList<Course> getTeacherCourse() {
        return teacherCourse;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public String addStudent(){
        String name = JOptionPane.showInputDialog(null,"Enter Student name",
                "Add Student", JOptionPane.QUESTION_MESSAGE);
        Student student = new Student(name);
        if(student.getName() == null || student.getName().isEmpty()){
            return "Please add Student name";
        }
        this.students.add(student);
        return "Student " + student.getName() + " was added successfully";
    }

    public Student findStudent(String name){
        for(Student student: students){
            if(student.getName().equals(name)){
                return student;
            }
        }return null;
    }

    public String addTeacher(){
        String name = JOptionPane.showInputDialog(null,"Enter Teacher name",
                "Add Teacher", JOptionPane.QUESTION_MESSAGE);
        Teacher teacher = new Teacher(name);
        if(teacher.getName() ==null || teacher.getName().isEmpty()){
            return "Please add Teacher name";
        } this.teachers.add(teacher);
        return "Teacher " + teacher.getName() + " was added successfully";
    }
    public Teacher findTeacher(String name){
        for(Teacher teacher: teachers){
            if(teacher.getName().equals(name)){

                return teacher;
            }
        }return null;
    }

    public String addCourse(){
        String title = JOptionPane.showInputDialog(null,"Enter Course title",
                "Add Course", JOptionPane.QUESTION_MESSAGE);
        Course course = new Course(title);
        if(course.getTitle() ==null || course.getTitle().isEmpty()) {
            return "Please add Course title";
        }this.courses.add(course);
        return "Course " + course.getTitle() + " was added successfully";
    }

    public Course findCourse(String title){
        for(Course course: courses){
            if(course.getName().equals(title)){
                return course;
            }
        }return null;
    }

    public Course findTeacherCourse(String title){
        for(Course course: teacherCourse){
            if(course.getName().equals(title)){
                return course;
            }
        }return null;
    }
    public String addExam(){
        int examResult = Integer.parseInt(JOptionPane.showInputDialog("Enter exam Result"));
        Exam exam = new Exam(examResult);
        this.exams.add(exam);
        return exam.getExamResult() + " was added successfully";
    }

    public String addCourseWithTeacher(){
          try {
              Course title = (Course) JOptionPane.showInputDialog(null,
                      "Choose course",
                      "Add Teacher to course",
                      JOptionPane.QUESTION_MESSAGE,
                      null,
                      this.courses.toArray(new Course[0]),
                      this.courses.toArray()
              );

       // String title = JOptionPane.showInputDialog("Enter Course title");
//        Course course = new Course(title);
//        this.courses.add(course);
        Teacher name = (Teacher) JOptionPane.showInputDialog(null,
                "Choose Teacher",
                "Add Teacher to course",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.teachers.toArray(new Teacher[0]),
                this.teachers.toArray()
        );
        Course teacherCourse = new Course(title.getTitle(), name.getName());
        this.teacherCourse.add(teacherCourse);
        return teacherCourse + " add successfully!";
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, "No course or/and teacher added",
                      "Warning!", JOptionPane.WARNING_MESSAGE);
          }return "Add Course or/and Teacher";
    }
}
