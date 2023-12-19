package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Имя", "Фамилия", (byte) 12);
        userService.saveUser("Имя1", "Фамилия1", (byte) 22);
        userService.saveUser("Имя2", "Фамилия2", (byte) 32);
        userService.saveUser("Имя3", "Фамилия3", (byte) 42);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
