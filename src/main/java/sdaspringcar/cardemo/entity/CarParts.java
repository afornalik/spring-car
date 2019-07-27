package sdaspringcar.cardemo.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "car_parts")
public class CarParts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car_part")
    private Long idCarParts;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "name", nullable = false)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car")
    private Car car;

    public Long getIdCarParts() {
        return idCarParts;
    }

    public void setIdCarParts(Long idCarParts) {
        this.idCarParts = idCarParts;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}



