package week_7.p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner inFile = new Scanner(new File("./input/week7_input.txt"));
            SortedLinkedList<Student> studentList = new SortedLinkedList<>();

            getStudentData(inFile, studentList);
            System.out.print(studentList);

            inFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file: week7_input.txt" );
        }
    }

    public static void getStudentData(Scanner inFile, SortedLinkedList<Student> studentList) {
        while(inFile.hasNextLine()) {
            String[] student_data = inFile.nextLine().split(" ");

            SortedLinkedList<Course> courseList = new SortedLinkedList<>();

            while(inFile.hasNextLine()) {
                String course_data = inFile.nextLine();

                if(course_data.equals(""))
                    break;

                String[] processed_data = course_data.split(" ");

                courseList.insert(new Course(
                        processed_data[0],
                        Integer.parseInt(processed_data[1]),
                        processed_data[2].charAt(0))
                );
            }

            studentList.insert(new Student(
                    Integer.parseInt(student_data[0]),
                    student_data[1],
                    courseList)
            );
        }
    }
}
