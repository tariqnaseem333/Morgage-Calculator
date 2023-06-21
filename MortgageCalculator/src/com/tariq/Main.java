package com.tariq;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

//      Validating Principal Amount
        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if( principal >= 1000 && principal <= 1_000_000 ) {
                break;
            }
            System.out.println("Enter a number Between $1K and $1M.");
        }

//      Validating Annual Interest Rate
        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if( annualInterest > 0 && annualInterest <= 30 ) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

//      Validating Period in Years
        while(true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if( years >= 1 && years <= 30 ) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value Between 1 and 30.");
        }

//      Calculating Mortgage Amount
        double expression = Math.pow((1 + monthlyInterest), numberOfPayments);
        double mortgage = principal * ( (monthlyInterest * expression) / (expression-1) );

//      Formatting and Printing Mortgage Amount
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

    }
}
