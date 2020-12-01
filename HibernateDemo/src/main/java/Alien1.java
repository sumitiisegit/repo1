import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Alien1 {
    @Id
    private int aid;

    private String aname;

    @OneToMany(mappedBy = "alien1", fetch = FetchType.EAGER)
    // lazy will not fetch laptops until it is used. while fetching Alien it will fetch all other fields except laptop,
    // when laptop is used, it will fire another query to fetch laptops
    // eagar will fetch all fields including laptop in 1 query and uses left outer join for laptop
    private Collection<Laptop1> laps = new ArrayList<Laptop1>();

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Collection<Laptop1> getLaps() {
        return laps;
    }

    public void setLaps(Collection<Laptop1> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Alien1{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", laps=" + laps +
                '}';
    }
}
