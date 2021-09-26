package com.greatlearning.model;

import java.util.Scanner;

public class Stocks {
    public int totalCompanies;
    public double[] sharePrice;
    boolean hike;
    int Y = 0, Z = 0;

    Scanner sc = new Scanner(System.in);

    public void stage() {
        System.out.println("Enter the no of companies");
        totalCompanies = sc.nextInt();
        sharePrice = new double[totalCompanies];
        values();
    }

    public void values() {
        for (int i = 0; i < totalCompanies; i++) {
            System.out.println("Enter current stock price of the company " + (i + 1));
            sharePrice[i] = sc.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            hike = sc.nextBoolean();
            if (hike == true) {
                Y++;
            } else {
                Z++;
            }
        }
    }


    void merge(double[] arr, int n, int mid, int m) {
        int left = mid - n + 1;
        int right = m - mid;

        double[] leftArray = new double[left];
        double[] rightArray = new double[right];

        for (int i = 0; i < left; ++i) {
            leftArray[i] = arr[n + i];
        }
        for (int j = 0; j < right; ++j) {
            rightArray[j] = arr[mid + j + 1];
        }
        int i = 0, j = 0;
        int k = n;
        while (i < left && j < right) {
            if (leftArray[i] > rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < right) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void ascending(double[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            ascending(array, l, m);
            ascending(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    public void print() {
        for (int i = 0; i < sharePrice.length; i++) {
            System.out.println(sharePrice[i] + "  ");
        }
    }

    public void descending() {
        for (int i = sharePrice.length - 1; i >= 0; i--) {
            System.out.println(sharePrice[i] + "  ");
        }
    }

    public void search() {
        boolean stat = false;
        System.out.println("enter the key value");
        double value = sc.nextDouble();
        for (int i = 0; i < sharePrice.length; i++) {
            if (sharePrice[i] == value) {
                System.out.println("Stock of value " + value + " is present");
                stat = true;
            }
        }
        if (stat == false) {
            System.out.println("Value not found");
        }
    }
}
