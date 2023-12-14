import java.util.*;
public class Student {
    private String studentName;
    private double mathematics;
    private double programming;
    private double DSA1;
    
    public Student() {
        studentName = null;
        mathematics = 0.0;
        programming = 0.0;
        DSA1 = 0.0;
    }
    public Student(String name, double math, double pro, double dsa1) {
        studentName = name;
        mathematics = math;
        programming = pro;
        DSA1 = dsa1;
    }
    public double avg() {
        return (double) 1/3*(mathematics + programming + DSA1);
    }
    public String toString() {
        return studentName + ": AVG = " + avg();
    }
    public static void main(String[] args) {
        Student s[] = new Student[4];
        s[0] = new Student("trang", 7.1, 8.5, 9);
        s[1] = new Student("mai", 6.5, 9.5, 3);
        s[2] = new Student("nga", 8.9, 8, 5);
        s[3] = new Student("ngan", 5.9, 7, 7);
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, new StudentComparatorAsc());
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, new StudentComparatorDesc());
        System.out.println(Arrays.toString(s));
    }
}

