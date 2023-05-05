package de.gothaer.catbackend.cat;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(String s) {

        super(s); // Runtime Superklasse message mitteilen Konstruktor der Vaterklasse



    }
}
