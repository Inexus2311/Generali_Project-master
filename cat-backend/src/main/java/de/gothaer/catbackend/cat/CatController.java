package de.gothaer.catbackend.cat;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getAll()
    {
        return ResponseEntity.ok(catService.findAll());
    }


    @GetMapping("/{id}") // /cats/123

    public ResponseEntity<Cat> findOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(catService.findById(id));
    }

    // Put ändert nur die Objektinhalte in Klassen
    @PutMapping("/{id}")
    public ResponseEntity<Cat> put (@PathVariable Long id, @RequestBody Cat cat)
    {
        Cat byId = catService.findById(id);
        if(id==null || id.equals(byId))
        {
            return ResponseEntity.badRequest().body(cat);
        }

        byId.setName(cat.getName());
        byId.setColor(cat.getColor());

        catService.save(byId);

        return ResponseEntity.noContent().build();
    }

    // Erstellt ein neues Objekt falls es nicht vorhanden ist
    @PostMapping
    public ResponseEntity<Cat>create (@RequestBody Cat cat)
    {
        Cat save =catService.save(cat); // Objekt ertstellen
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getId())
                .toUri()).body(save);
    }

}
