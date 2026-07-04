/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradetracker;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DBConnection {
    
    public static Connection connect(String url, String username, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database!");
            return conn;    
        } catch (SQLException e){
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e){
            System.out.println("Driver not found: " + e.getMessage());
            return null;
        }
    }
    
    public static ArrayList<Students> getAllStudents(Connection conn) {
        ArrayList<Students> students = new ArrayList<>();
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            
            while (rs.next()){
                String name = rs.getString("name");
                String studentId = rs.getString("student_id");
                String course = rs.getString("course");
                
                Students student = new Students(name, studentId, course);
                students.add(student);
            }
            
        } catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
        }
        
        return students;
    }
    
    public static void addStudent(Connection conn, String name, String studentId, String course){
        try {
            String sql = "INSERT INTO students (name, student_id, course) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, name);
            pstmt.setString(2, studentId);
            pstmt.setString(3, course);
            
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
            
        } catch (SQLException e){
            System.out.println("Query failed!" + e.getMessage());
        }
    }
    
    public static void saveGrade(Connection conn, String studentId, double grade){
        try {
            String sql = "INSERT INTO grades (student_id, grade) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, studentId);
            pstmt.setDouble(2, grade);
            
            pstmt.executeUpdate();
            System.out.println("Grade saved successfully!");
           
        } catch (SQLException e){
            System.out.println("Insert failed: " + e.getMessage());
        }
    }
    
    public static void deleteStudent(Connection conn, String studentId){
        try{
            String sql = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, studentId);
            pstmt.executeUpdate();
            
            System.out.println("Student deleted successfully!");
            
        } catch (SQLException e){
            System.out.println("Delete failed! " + e.getMessage());
        }
    }
    
    public static void deleteGrade(Connection conn, int gradeId){
        try {
            String sql = "DELETE FROM grades WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, gradeId);
            pstmt.executeUpdate();
            
            System.out.println("Grade deleted successfully!");
            
        } catch (SQLException e){
            System.out.println("Delete failed! " + e.getMessage());
        }
    }
    
    public static void loadGrades(Connection conn, Students student){
        try {
            String sql = "SELECT grade FROM grades WHERE student_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, student.getStudentId());
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                student.addGrade(rs.getDouble("grade"));
            }
        } catch (SQLException e){
            System.out.println("Failed to load grades: " + e.getMessage());
        }
    }
}










