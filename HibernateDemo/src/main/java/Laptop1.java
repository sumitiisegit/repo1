import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop1 {

    @Id
    private int lId;
    private String brand;
    private int price;

    @ManyToOne
    private Alien1 alien1;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Alien1 getAlien1() {
        return alien1;
    }

    public void setAlien1(Alien1 alien1) {
        this.alien1 = alien1;
    }

    @Override
    public String toString() {
        return "Laptop1{" +
                "lId=" + lId +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", alien1=" + alien1 +
                '}';
    }
}
