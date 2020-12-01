import javax.persistence.*;

@Entity
@Table(name="alien_table")
public class Alien {

    @Id
    @Column(name = "aid")
    private int aid;

    @Column(name = "aname")
//Transient means column would not be created if hibernate is creating; and would not be inserted/updated.
  //  @Transient
    //private String aname;

    private AlienName aname;

    @Column(name = "color")
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public AlienName getAname() {
        return aname;
    }

    public void setAname(AlienName aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname=" + aname +
                ", color='" + color + '\'' +
                '}';
    }
}
