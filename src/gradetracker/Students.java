/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradetracker;
import java.util.ArrayList;

public class Students {

protected String name;
protected String studentID;
protected String course; 
protected ArrayList<Double> grades = new ArrayList<>();

public Students(String name, String studentID, String course){
this.name = name; 
this.studentID = studentID; 
this.course = course; 
}

public void addGrade(double grade){
    grades.add(grade);
}

public double getAverage(){
    double sum = 0; 
    for(int i = 0; i < grades.size(); i++){
        sum = sum + grades.get(i);
    }
    return sum / grades.size();
}

public double getHighest(){ 
    if (grades.isEmpty()){
        return 0;
    }
    
    double highest = grades.get(0);
    for(int i = 1; i < grades.size(); i++){
        if (grades.get(i) > highest){
            highest = grades.get(i);
        }
    }
    return highest;
}

public double getLowest(){
    if (grades.isEmpty()){
        return 0;
    }
    double lowest = grades.get(0);
    for(int i = 1; i < grades.size(); i++){
        if(grades.get(i) < lowest){
            lowest = grades.get(i);
        }
    }
    return lowest;
}

public String getStudentId(){
    return studentID;
}

public void printReport(){
    System.out.println("Name: " + name);
    System.out.println("StudentID: " + studentID);
    System.out.println("Course: " + course);
    System.out.println("Average: " + getAverage());
    System.out.println("Highest: " + getHighest());
    System.out.println("Lowest: " + getLowest());  
}

public void printDetails(){
    System.out.println("Name: " + name);
    System.out.println("Student ID: " + studentID);
    System.out.println("Course: " + course);
}
}
