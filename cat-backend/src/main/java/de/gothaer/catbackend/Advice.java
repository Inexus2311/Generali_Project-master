package de.gothaer.catbackend;
import de.gothaer.catbackend.cat.CatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice


// Sorge das ein Status 404 zurückgegeben wird
// Fehlerhandling der Exception vom Client zurückgeben

public class Advice {
@ExceptionHandler(CatNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public String catNotFoundException(CatNotFoundException e)
{
    return e.getMessage();

}





}
