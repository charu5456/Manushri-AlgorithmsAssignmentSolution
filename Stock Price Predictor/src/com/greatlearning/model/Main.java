package com.greatlearning.model;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner in = new Scanner(System.in);
        Stocks stock = new Stocks();
        stock.stage();

        do {
            System.out.println(" ----------------------------------------------- ");
            System.out.println("Enter the operation that you want to perform");
            System.out.println("1. Display the companies stock prices in ascending order");
            System.out.println("2. Display the companies stock prices in descending order");
            System.out.println("3. Display the total no of companies for which stock prices rose today");
            System.out.println("4. Display the total no of companies for which stock prices declined today");
            System.out.println("5. Search a specific stock price");
            System.out.println("6. press 0 to exit");
            System.out.println("-----------------------------------------------");

            choice = in.nextInt();
            switch (choice) {
                case 0:
                    choice = 0;
                    break;
                case 1:
                    System.out.println("Stock prices in ascending order are");
                    stock.ascending(stock.sharePrice, 0, stock.sharePrice.length - 1);
                    stock.descending();

                    break;

                case 2:
                    System.out.println("Stock prices in descending order are");
                    stock.ascending(stock.sharePrice, 0, stock.sharePrice.length - 1);
                    stock.print();
                    break;

                case 3:
                    System.out.println("Total no of companies whose stock price rose today: " + stock.Y);
                    break;


                case 4:
                    System.out.println("Total no of companies whose stock price declined today: " + stock.Z);
                    break;


                case 5:
                    stock.search();
                break;

                default:
                    System.out.println("Please enter a valid choice.");
            }
        } while (choice != 0);
        System.out.println("Exited successfully");
        in.close();
    }
}
