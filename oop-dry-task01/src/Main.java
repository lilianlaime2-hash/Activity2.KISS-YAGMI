import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static double calculateAvg(double score1, double score2, double score3) {
        return (score1 + score2 + score3) / 3;
    }

    public static void main(String[] args) {
        Subject programming = new Subject("Programming");
        Subject database = new Subject("DataBase");
        Subject language = new Subject("Language");

        List<Subject> subjects = new ArrayList<>(List.of(programming, database, language));
        List<Student> students = new ArrayList<>();

        Student student1 = new Student(1, "Gery");
        student1.addScore(programming, 67.0);
        student1.addScore(database, 70.0);
        student1.addScore(language, 69.0);

        Student student2 = new Student(2, "Joel");
        student2.addScore(programming, 80.0);
        student2.addScore(database, 85.0);
        student2.addScore(language, 85.0);

        Student student3 = new Student(3, "Carmen");
        student3.addScore(programming, 90.5);
        student3.addScore(database, 65.5);
        student3.addScore(language, 95.5);

        Student student4 = new Student(4, "Lia");
        student4.addScore(programming, 75.3);
        student4.addScore(database, 75.3);
        student4.addScore(language, 85.3);

        Student student5 = new Student(5, "Phill");
        student5.addScore(programming, 60.0);
        student5.addScore(database, 80.0);
        student5.addScore(language, 74.0);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Scanner sc = new Scanner(System.in);
        int option = 0;

        while (option != 6) {
            System.out.println("1. New student");
            System.out.println("2. List students");
            System.out.println("3. Add subject");
            System.out.println("4. Edit scores");
            System.out.println("5. View student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.println("Insert name");
                    String name = sc.nextLine();
                    Student newStudent = new Student(students.size() + 1, name);
                    for (Subject subject : subjects) {
                        newStudent.addScore(subject, 0.0);
                    }
                    students.add(newStudent);
                }
                break;
                case 2: {
                    for (int i = 0; i < students.toArray().length; i++) {
                        Student student = students.get(i);
                        System.out.println("Name: " + student.getName());
                        for (int j = 0; j < subjects.size(); j++) {
                            Subject subject = subjects.get(j);
                            System.out.print(subject + ": " + student.getScore(subject) + " ");
                        }
                        System.out.println();
                    }
                }
                break;
                case 3:
                    String newSubjectName = "";
                    System.out.println("Subject name: ");
                    newSubjectName = sc.nextLine();
                    Subject newSubject = new Subject(newSubjectName);
                    subjects.add(newSubject);
                    for (Student student : students) {
                        student.addScore(newSubject, 0.0);
                    }
                    break;
                case 4: {
                    int studentIndex = -1;
                    System.out.println("Select student index:");
                    studentIndex = Integer.parseInt(sc.nextLine());
                    Student student = students.get(studentIndex);
                    System.out.println(student.getName());
                    for (int i = 0; i < subjects.size(); i++) {
                        Subject subject = subjects.get(i);
                        System.out.println(subject + " Current score :" + student.getScore(subject));
                        System.out.print("new Score: ");
                        double newScore = Integer.parseInt(sc.nextLine());
                        student.updateScore(subject, newScore);
                    }
                }
                break;
                case 5: {
                    int studentIndex = -1;
                    System.out.println("Select student index: ");
                    studentIndex = Integer.parseInt(sc.nextLine());
                    Student student = students.get(studentIndex);
                    System.out.println(student.getName());
                    double average = 0.0;
                    for (int i = 0; i < subjects.toArray().length; i++) {
                        Subject subject = subjects.get(i);
                        double score = student.getScore(subject);
                        System.out.println(subject + ": " + score + " ");
                        average += score;
                    }
                    System.out.println("Average : " + average / subjects.size());
                }
                break;
                default:
                    break;
            }
        }
    }
}
