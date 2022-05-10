package Graphics;

import jatek.Varos;

import java.util.LinkedList;
import java.util.List;

public class Publisher {
    private List<Observer> observers = new LinkedList<>();

    private static Publisher instance = null;

    public static Publisher getInstance()
    {
        if(instance == null)
            instance = new Publisher();
        return instance;
    }

    public void sub(Observer observer){
        observers.add(observer);
    }

    public void updateNyer(){
        for(Observer observer: observers){
            observer.subNyer();
        }
    }

    public void updateAction(){
        for(Observer observer: observers){
            observer.subAction();
        }
    }

    public void updateKovetkezo(){
        for(Observer observer: observers){
            observer.subKovetkezo();
        }
    }
}
