import schoolManagement.*;

import javax.swing.*;


public class Main {
    School rnv = new School();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    void menu() {
        String option;

        do {
            String[] options = {"Select...", "Students", "Teachers","Add course","Add course with teacher",
                    "View all courses with teachers", "Updated courses","Add Exam result", "Exit"};

            option = (String) JOptionPane.showInputDialog(null, """
                            Welcome to RNV school!
                            Please select Options or
                            Choose EXIT to quit""",
                    "School Management",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
            switch (option) {
                case "Students":
                    student();
                    break;
                case "Teachers":
                    teacher();
                    break;
                case "Add course with teacher":
                    JOptionPane.showMessageDialog(null, rnv.addCourseWithTeacher());
                    break;
                case "View all courses with teachers":
                    JOptionPane.showMessageDialog(null, rnv.getTeacherCourse(),
                            "All Courses with Teacher", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "Add Exam result":
                    JOptionPane.showMessageDialog(null, examResult());
                    break;
                case "Updated courses":
                    JOptionPane.showMessageDialog(null, updateCourseWithTeacher());
                    break;
                case "Add course":
                    JOptionPane.showMessageDialog(null, rnv.addCourse());
                    break;
                default:
                    break;
            }
        } while (!option.equals("Exit"));
    }

    void student() {
        String option;

        do {
            String[] options = {"Select...", "Add Student", "Update Student", "Remove Student","See Students", "Exit"};

            option = (String) JOptionPane.showInputDialog(null, "Welcome to RNV school Student menu!" +
                    "\nAll Students " + rnv.getStudents() +
                            "\nPlease select your task \nChoose EXIT to quit",
                    "RNV School Student Management",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
            switch (option) {
                case "Add Student":
                    JOptionPane.showMessageDialog(null, rnv.addStudent(),
                            "Add Student", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Update Student":
                    JOptionPane.showMessageDialog(null, updateStudent(),
                            "Student update", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "See Students":
                    JOptionPane.showMessageDialog(null,
                            rnv.getStudents(), "All Students", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "Remove Student":
                    JOptionPane.showMessageDialog(null, removeStudent(),
                            "Remove Student", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    break;
            }
        } while (!option.equals("Exit"));
    }

    void teacher(){
        String option;

        do {
            String[] options = {"Select...", "Add Teacher", "Update Teacher", "Remove Teacher","See Teachers", "Exit"};

            option = (String) JOptionPane.showInputDialog(null,
                            "Welcome to RNV school Teacher menu!" +
                            "\nAll Teachers: " + rnv.getTeachers() +
                            "\nPlease select your task \nChoose EXIT to quit",
                    "RNV School Teacher Management",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
            switch (option) {
                case "Add Teacher":
                    JOptionPane.showMessageDialog(null, rnv.addTeacher(),
                            "Add Teacher", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "Update Teacher":
                    JOptionPane.showMessageDialog(null, updateTeacher(),
                            "Teacher Update", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "See Teachers":
                    JOptionPane.showMessageDialog(null, rnv.getTeachers(),
                            "All Teachers", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "Remove Teacher":
                    JOptionPane.showMessageDialog(null, removeTeacher(),
                            "Remove Teacher", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    break;
            }
        } while (!option.equals("Exit"));
    }

    String updateStudent() {
        try {Student studentUpdate = (Student) JOptionPane.showInputDialog(null, "Choose Student to update",
                    "Update Student",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    this.rnv.getStudents().toArray(new Student[0]),
                    this.rnv.getStudents());
            Student student = rnv.findStudent(studentUpdate.getName());
            String name = JOptionPane.showInputDialog(null, "Enter Students new name ",
                    "Students update", JOptionPane.QUESTION_MESSAGE);
            student.setName(name);
            return "Student " + student.getName() + " updated successfully";
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No students to update",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        return "Add Student";
    }
   String removeStudent() {
       try{ Student studentRemove = (Student) JOptionPane.showInputDialog(null, "Choose Student to remove",
                "Remove Student",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.rnv.getStudents().toArray(new Student[0]),
                this.rnv.getStudents());
        Student student = rnv.findStudent(studentRemove.getName());
        rnv.students.remove(studentRemove);
        return "Student " + student.getName() + " removed successfully";
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, "No students to remove",
                   "Warning!", JOptionPane.WARNING_MESSAGE);
       }return "Add Student";
    }
    String updateTeacher() {
        try {Teacher teacherUpdate = (Teacher) JOptionPane.showInputDialog(null, "Choose Teacher to update",
                    "Update Teacher",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    this.rnv.getTeachers().toArray(new Teacher[0]),
                    this.rnv.getTeachers());
        Teacher teacher = rnv.findTeacher(teacherUpdate.getName());
        String name = JOptionPane.showInputDialog(null, "Enter Teachers new name ",
                "Teachers update", JOptionPane.QUESTION_MESSAGE);
        teacher.setName(name);
        return "Teacher " + teacher.getName() + " updated successfully";
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "No teacher to update",
                "Warning!", JOptionPane.WARNING_MESSAGE);
    }return "Add teacher";
    }

    String removeTeacher() {
        try {
            Teacher teacherRemove = (Teacher) JOptionPane.showInputDialog(null, "Choose Teacher to remove",
                    "Remove Teacher",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    this.rnv.getTeachers().toArray(new Teacher[0]),
                    this.rnv.getTeachers());
            Teacher teacher = rnv.findTeacher(teacherRemove.getName());
            rnv.teachers.remove(teacherRemove);
            return "Teacher " + teacher.getName() + " removed successfully";
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No teacher to remove",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }return "Add Teacher";
    }
    String updateCourseWithTeacher(){
       try {
           Course courseToUpdate = (Course) JOptionPane.showInputDialog(null, "Choose course to update",
                   "Course to update",
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   this.rnv.getTeacherCourse().toArray(new Course[0]),
                   this.rnv.getTeacherCourse());
           Course title = (Course) JOptionPane.showInputDialog(null, "Choose course",
                   "Course to update",
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   this.rnv.getCourses().toArray(new Course[0]),
                   this.rnv.getCourses());
           courseToUpdate.setTitle(title.getTitle());
           Teacher newTeacher = (Teacher) JOptionPane.showInputDialog(null, "Choose Teacher to add",
                   "Course to update",
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   this.rnv.getTeachers().toArray(new Teacher[0]),
                   this.rnv.getTeachers());
           //  Teacher teacher = rnv.findTeacher(newTeacher.getName());
           courseToUpdate.setName(newTeacher.getName());
           return courseToUpdate + " updated successfully!";
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "No course to update",
                "Warning!", JOptionPane.WARNING_MESSAGE);
    }return "Add course";
    }

    String examResult(){
        Student studentAddExam = (Student) JOptionPane.showInputDialog(null,
                "Choose Student to add exam result",
                "Exam result",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.rnv.getStudents().toArray(new Student[0]),
                this.rnv.getStudents());
       // Student student = rnv.findStudent(studentAddExam.getName());
        Course teacherCourse = (Course) JOptionPane.showInputDialog(null, "Choose Course",
                "Exam result",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.rnv.getTeacherCourse().toArray(new Course[0]),
                this.rnv.getTeacherCourse());
       // Course courseTeacher = rnv.findTeacherCourse(teacherCourse.getTitle());
        int resultExam = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter exam result",
                "Exam result", JOptionPane.QUESTION_MESSAGE));
        Exam exam = new Exam(studentAddExam.getName(), resultExam);
        this.rnv.exams.add(exam);

     // String [studentAddExam][courseTeacher][resultExam];
       return "Student " + studentAddExam.getName() + " in course " + teacherCourse.getTitle() + " gets " + resultExam;
    }
//     String viewAllTeacher(){
//         ArrayList<Teacher> teachers = rnv.getTeachers();
//         for (Teacher teacher: teachers){
//           return teacher.getName();
//         }return " Please add teacher!";
//     }

 }

