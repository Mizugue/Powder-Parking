package program;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import parking.parking_config;

import client.Car;
import client.Owner;
import client.average_car;
import client.small_car;
import entities_enum.Color;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private List<Car> cars = new ArrayList<>();
    private List<Owner> clients = new ArrayList<>();
    private parking_config parking;

    public Menu() {
        parkingMenu();
    }


    public void parkingMenu() {
        try {
            System.out.println("which size of you Parking? ");
            System.out.print("Number of vacancies per row: ");
            int row = sc.nextInt();
            System.out.print("Number of vacancies per column: ");
            int column = sc.nextInt();
            System.out.print("Minimal usage time in hours: ");
            int min_hour = sc.nextInt();
            System.out.print("Value per hour(Average size): $ ");
            double value_average = sc.nextDouble();
            System.out.print("Value per hour(Small size): $ ");
            double value_small = sc.nextDouble();

            parking = new parking_config(row, column, min_hour, value_average, value_small);
            System.out.println(parking);
            who();
        } catch (InputMismatchException e) {
            System.out.println("The value should be integer");
            parkingMenu();
        }
    }

    public void who() {
        System.out.println("1-Citizen");
        System.out.println("2-Manager");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                mainMenu();
            case 2:
                managerMenu();
        }
    }


    public void managerMenu() {
        System.out.println("1-See layout");
        System.out.println("2-Search vehicle");
        System.out.println("3-Show all clients");
        int op = sc.nextInt();
        switch (op){
            case 1:
                System.out.println(parking);
                who();
                break;
            case 2:
                System.out.println(parking);
                System.out.println("Which car do you wanna consult?");
                System.out.print("ROW: ");
                int row = sc.nextInt();
                System.out.print("COLUMN: ");
                int column = sc.nextInt();
                parking.getCarin(row, column);
                who();
                break;
            case 3:
                parking.getAll();
                who();
                break;
        }
    }



    public void mainMenu() {
        System.out.println("-------------------------------");
        System.out.println(" Welcome to Powder Parking ");
        System.out.println("-------------------------------");
        try {
            System.out.println("1-Enter in the parking");
            System.out.println("2-Ignore");
            System.out.println("3-Back");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    getCarmenu();

                case 2:
                    System.exit(0);
                case 3:
                    who();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid type: " + e);
            mainMenu();
        }
    }

    private void getCarmenu() {
        try {
            System.out.print("Name: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Cpf: ");
            String cpf = sc.next();
            sc.nextLine();
            System.out.print("Phone: ");
            String phone = sc.next();
            sc.nextLine();

            Owner client = new Owner(name, cpf, phone);

            System.out.println("Which size of your car? ");
            System.out.println("1-Average");
            System.out.println("2-Small");
            int size = sc.nextInt();
            System.out.print("Plate: ");
            String plate = sc.next();
            System.out.print("Model: ");
            String model = sc.next();
            System.out.print("Color: ");
            String cor = sc.next().toUpperCase();
            switch (size) {
                case 1:
                    cars.add(new average_car(plate, Color.valueOf(cor), client, model));
                    break;
                case 2:
                    cars.add(new small_car(plate, Color.valueOf(cor), client, model));
                    break;
            }
            getActionmenu();
        } catch (InputMismatchException e) {
            System.out.println("Invalid type: " + e);
            getCarmenu();
        } catch (IllegalArgumentException e) {
            System.out.println("Do you really know which the color of your car? --> " + e);
            getCarmenu();
        }
    }



    private void getActionmenu() {
        System.out.println("1-Park");
        System.out.println("2-Quit");
        System.out.println("3-Back");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                System.out.println(parking);
                System.out.println("Which the local(row/column): ");
                System.out.print("ROW: ");
                int row = sc.nextInt();
                System.out.print("COLUMN: ");
                int column = sc.nextInt();
                System.out.print("How much time in hours(min: " + parking.getMin_hour() + "): ");
                int time = sc.nextInt();
                parking.stagnate(cars.getLast(), row, column, time);
                who();
                break;
            case 2:
                System.exit(0);
                break;
            case 3:
                who();
                break;
        }
    }
}









