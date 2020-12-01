import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {

    @Id
    private int lId;
    private String lName;

//    @ManyToOne // adds id of Student into laptop table
//    private Student student;

    @ManyToMany // adds id of Student into laptop table
    private List<Student> student = new ArrayList<Student>();

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                ", student=" + student +
                '}';
    }
}
