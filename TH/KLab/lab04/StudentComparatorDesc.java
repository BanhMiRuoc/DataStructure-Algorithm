import java.util.Comparator;
public class StudentComparatorDesc implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        double avg = s1.avg() - s2.avg();
        return (avg < 0) ? 1 : (avg > 0) ? -1 : 0;
    }
}