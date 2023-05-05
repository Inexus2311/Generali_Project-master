package de.gothaer.catbackend.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface CatRepository extends JpaRepository<Cat,Long> {

    List<Cat> findByColor(String color);

    List<Cat> findByColorAndName(String color, String name);


}
