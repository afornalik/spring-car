package sdaspringcar.cardemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdaspringcar.cardemo.entity.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {


}
