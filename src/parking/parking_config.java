package parking;
import client.small_car;
import client.Car;
import client.average_car;
import entities_enum.Color;

import java.util.Date;

public class parking_config {
    private String[][] size;
    private Car[][] parked_cars;
    private int min_hour;
    private double value_per_hour_average_size;
    private double value_per_hour_small_size;


    public parking_config() {
    }


    public parking_config(int rows, int columns, int min_data, Double value_per_hour_average_size, Double value_per_hour_small_size) {
        size = new String[rows][columns];
        this.min_hour = min_data;
        this.value_per_hour_average_size = value_per_hour_average_size;
        this.value_per_hour_small_size = value_per_hour_small_size;
        parked_cars = new Car[rows][columns];
    }


    @Override
    public String toString() {
        String str = "";
        int numRows = size.length;
        int numCols = size[0].length;
        int street = numRows / 2;


        str += "    ";
        for (int col = 0; col < numCols; col++) {
            str += String.format("%-9d", col);
        }


        str += "  ";
        str += "\n";


        for (int i = 0; i < numRows; i++) {
            if (i == street) {
                str += "---------------------------------------------------\n";
                str += "=   =   =  =  =   =   =  =  =   =   =  =  =   =   ";
                str += "\n---------------------------------------------------\n";
            }
            str += String.format("%-2d", i) + "  ";
            for (int j = 0; j < numCols; j++) {
                str += (size[i][j] != null ? size[i][j] : "null") + "    ";
            }
            str += "\n";
        }

        return str;
    }





    public void stagnate(Car car, int row_vacancy, int column_vacancy, int time) {
        if (time < min_hour) {
            System.out.println(String.format("Do you cannot stay %d hora (min %d)!", time, min_hour));
            return;
        }
    
        String color = car.getCor().toString();
        String color_car_emoji = "";
        switch (color) {
            case "WHITE":
                color_car_emoji = "\uD83D\uDE90";
                break;
            case "BLACK":
                color_car_emoji = "\uD83D\uDE94";
                break;
            case "GRAY":
                color_car_emoji = "\uD83D\uDE93";
                break;
            case "RED":
                color_car_emoji = "\uD83D\uDE97";
                break;
            case "BLUE":
                color_car_emoji = "\uD83D\uDE99";
                break;
        }
    
    
        if (car instanceof average_car) {
            if (row_vacancy < size.length - 1 && size[row_vacancy][column_vacancy] == null && size[row_vacancy + 1][column_vacancy] == null) {
                size[row_vacancy][column_vacancy] = color_car_emoji;
                parked_cars[row_vacancy][column_vacancy] = car;
                size[row_vacancy + 1][column_vacancy] = color_car_emoji;
                parked_cars[row_vacancy + 1][column_vacancy] = car;
                double value = time * value_per_hour_average_size;
                System.out.println("You will shall pay $" + value);
                return;
            } else {
                System.out.println("This vacancy are not empty");
                return;
            }
        } else if (car instanceof small_car) {
            if (row_vacancy < size.length && size[row_vacancy][column_vacancy] == null) {
                size[row_vacancy][column_vacancy] = color_car_emoji;
                parked_cars[row_vacancy][column_vacancy] = car;
                double value = time * value_per_hour_small_size;
                System.out.println("You will shall pay $" + value);
                return;
            } else {
                System.out.println("This vacancy are not empty");
                return;
            }
        }
    }


    public void getCarin(int row, int column) {
        if (parked_cars[row][column] != null) {
            Car car = parked_cars[row][column];
            System.out.println(car.toString());
            return;
        }
        System.out.println("There is not car in this vacancy! ");
        return;

    }

    public void getAll() {
        for (Car[] car : parked_cars){
            for (int i = 0; i < car.length; i++)
                if (car[i] != null){
                    System.out.println(car[i].toString());
            }
        }
    }








    public int getMin_hour() {
        return min_hour;
    }

    public String[][] getSize() {
        return size;
    }

    public Car[][] getParked_cars() {
        return parked_cars;
    }



    public double getValue_per_hour_average_size() {
        return value_per_hour_average_size;
    }

    public double getValue_per_hour_small_size() {
        return value_per_hour_small_size;
    }
}
