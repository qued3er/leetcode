package array;

public class Cat extends Subject {

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void action() {
        System.out.println("cat action");
        for (Observer observer:observers) {
            observer.response();
        }
    }

    public static void main(String[] args) {
        Observer observer=new Master();
        Subject subject=new Cat();
        subject.addObserver(observer);
        subject.action();
    }
}
