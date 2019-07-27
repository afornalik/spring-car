package sdaspringcar.cardemo.entity;


import sdaspringcar.cardemo.entity.carModel.CarModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car")
    private Long idCar;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "model",nullable = false,columnDefinition = "enum (  'COMBI', 'HATCHBACK', 'SEDAN','SUV')")
    @Enumerated(EnumType.STRING)
    private CarModel carModel;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "car")
    private Set<CarParts> carParts;

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Set<CarParts> getCarParts() {
        return carParts;
    }

    public void setCarParts(Set<CarParts> carParts) {
        this.carParts = carParts;
    }
}
