package de.gothaer.catbackend.cat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service

public class CatService {

    // Speichert alle Get-Methoden in  LOGGER
    // Gibt eine Ausgabe der Klasse in der Konsole wieder

    final static private Logger LOGGER = LoggerFactory.getLogger("CatService.class");

    private CatRepository catRepository;
   public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public <S extends Cat> S save(S s) {
        return catRepository.save(s);
    }

    public Cat findById(Long aLong) {
       // Lamba wird aufgerufen wenn die Option leer ist , daher die leere Klammer --> orElseThrow(()->new
        //Wenn keine Katze gefunden wurde wird eine Exception rausgeworfen
        return catRepository.findById(aLong).orElseThrow(()->new CatNotFoundException("Cat with id"+ aLong + " does not exist"));
    }
@PostConstruct
    public void init(){

        Cat cat  = new Cat("Schnusula", "red");
        Cat cat1 = new Cat("Mauzi","wheat");
        Cat cat2 = new Cat("Snobilicat","red");


        catRepository.save(cat);
        catRepository.save(cat1);
        catRepository.save(cat2);

        LOGGER.info("*******************************");
        List<Cat> all = catRepository.findAll();
        all.forEach(c -> LOGGER.info(c.toString()));

        LOGGER.info("*******************************");
        List<Cat> red = catRepository.findByColor("red");

       red.forEach( c -> LOGGER.info(c.toString()));

        //catRepository.




    }

}
