package org.designpattern.observer.test2;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("june");
        User user2 = new User("shine");

        chatServer.register("게임1", user1);
        chatServer.register("게임1", user2);

        chatServer.register("게임2", user1);

        chatServer.sendMessage(user1, "게임1", "실행1");
        chatServer.sendMessage(user2, "게임2", "실행2");

    }
}
