package com.company;

import enums.Gender;
import model.User;
import service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static enums.Gender.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserServiceImpl userService = new UserServiceImpl();

        User user1 = new User("Dinara",1,18,FEMALE);
        User user2 = new User("Ulan", 2, 26, MALE);
        User user3 = new User("Nargiza",3,18,FEMALE);
        User user4 = new User("Nurgazy",4,17,MALE);
        User user5 = new User("Aziza",5,28,FEMALE);
        User user6 = new User("Ceiit",6,32,MALE);
        User user7 = new User("Azat",7,32,MALE);

        userService.allUserAdd(user1);
        userService.allUserAdd(user2);
        userService.allUserAdd(user3);

        System.out.println("Id to write: ");
        int id = scanner.nextInt();
        System.out.println(userService.withIdFindUser(id));
        System.out.println("All users: ");
        userService.allUsersFind().stream().forEach(System.out::println);
        System.out.println("Remove second users: ");
        int idRemove = scanner.nextInt();
        userService.withIdRemove(idRemove);
        System.out.println("After remove: ");
        userService.allUsersFind().stream().forEach(System.out::println);


        Map<Gender, List<User>> allUsers = userService.allUsersFind().
                stream().collect(Collectors.groupingBy(User::getGender));


        allUsers.forEach(((gender, users) -> {
            System.out.println(gender);
            users.forEach(System.out::println);
            System.out.println();
        }));

    }
}
