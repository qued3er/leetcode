package array;

import java.util.List;

public abstract  class   Subject {
    List <Observer> observers ;
    public abstract void addObserver(Observer observer);
    public abstract void action();
}
