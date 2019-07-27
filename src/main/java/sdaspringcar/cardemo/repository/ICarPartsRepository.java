package sdaspringcar.cardemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdaspringcar.cardemo.entity.CarParts;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ICarPartsRepository extends JpaRepository<CarParts, Long> {

    List<CarParts> findByPriceGreaterThan(BigDecimal price);
}
