package org.designpattern.observer.test1.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Observer {
    void update(String event);
}

class EventSource {
    List<Observer> observers = new ArrayList<>();
    void notifyObservers(String event){
        observers.forEach(observer -> observer.update(event));
    }
    void addObserver(Observer observer) {
        observers.add(observer);
    }
    void scanSystemIn(){
        var scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            notifyObservers(line);
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("Enter Text : ");
        var eventSource = new EventSource();

        eventSource.addObserver(event -> {
            System.out.println("Received response: " + event);
        });

        eventSource.scanSystemIn();
    }
}
