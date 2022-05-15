package Graphics;

import jatek.Varos;

import java.util.LinkedList;
import java.util.List;


public class Publisher {
    private List<Observer> observers = new LinkedList<>();

    private static Publisher instance = null;

    /**
     * Singleton osztály getInstance metódusa.
     * Inicializál, első hvásnál.
     * @return az egyetlen Publisher példányt a programban
     */
    public static Publisher getInstance()
    {
        if(instance == null)
            instance = new Publisher();
        return instance;
    }

    /**
     * fel lehet iratkozni.
     * @param observer a feliratkozó observer
     */
    public void sub(Observer observer){
        observers.add(observer);
    }

    /**
     * Az observerek nyer fv-ét híja végig
     */
    public void updateNyer(){
        for(Observer observer: observers){
            observer.subNyer();
        }
    }

    /**
     * Az observerek action fv-ét híja végig
     */
    public void updateAction(){
        for(Observer observer: observers){
            observer.subAction();
        }
    }

    /**
     * Az observerek kovetkezo fv-ét híja végig
     */
    public void updateKovetkezo(){
        for(Observer observer: observers){
            observer.subKovetkezo();
        }
    }
}
