/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gradetracker;
import java.util.ArrayList;
import java.util.Scanner; 

public class GradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Students> students = new ArrayList<>();
        String choice = " ";
        
        
        while(!choice.equals("4")){
            System.out.println("======= Grade Tracker =======");
            System.out.println("1. Add New Student");
            System.out.println("2. Add Student Grade");
            System.out.println("3. Print Report");
            System.out.println("4. Exit");
            System.out.println("Choose: ");
            choice = sc.nextLine().trim();
            
            if(choice.equals("1")){
                System.out.println("Full name: ");
                String name = sc.nextLine().trim();
                System.out.println("Student ID: ");
                String studentID = sc.nextLine().trim();
                System.out.println("Course: ");
                String course = sc.nextLine().trim();
                Students student1 = new Students(name, studentID, course);
                students.add(student1);
                System.out.println("Student added successfully!");
                
            } else if(choice.equals("2")){
                System.out.println("Please enter the students name: ");
                String searchName = sc.nextLine().trim();
                
                Students found = null;
                for (Students student: students){
                    if(student.name.equals(searchName)){
                        found = student;
                        break;
                    }
                }
                
                if (found != null){
                    System.out.println("Enter grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine();
                    found.addGrade(grade);
                    System.out.println("Grade added!");
                } else {
                    System.out.println("Student not found!");
                }
                     
            } else if(choice.equals("3")){
                System.out.println("Please enter the students name for their report: ");
                String searchName = sc.nextLine().trim();
                
                Students found = null;
                for (Students student: students){
                    if (student.name.equals(searchName)){
                        found = student;
                        break;
                    }
                }
                
                if(found != null){
                    found.printReport();
                } else {
                    System.out.println("Student not found!");
                }
            } else if(choice.equals("4")){
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
    

