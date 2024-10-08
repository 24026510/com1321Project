// This Java program calculates a user's net monthly income after accounting for various expenses and financial decisions.

import java.util.Scanner;

public class declaration_parameter {
    public static void main(String[] args) {
        Scanner inputDevice = new Scanner(System.in);

        // User inputs for income and expenditures
        System.out.print("Enter your gross monthly income (before deductions): ");
        double grossIncome = inputDevice.nextDouble();

        System.out.print("Enter your estimated monthly tax deducted: ");
        double taxDeducted = inputDevice.nextDouble();

        // Declare an array for Monthly_expenditures
        double[] Monthly_expenditures = new double[5];
        String[] expenditureNames = {
            "groceries", 
            "water and lights", 
            "travel costs (including petrol)", 
            "cell phone and telephone",
            "other expenses(e.g insurance, wifi, Subscriptions)"
        };

        // Input for each type of expenditure
        for (int i = 0; i < Monthly_expenditures.length; i++) {
            System.out.print("Enter your estimated monthly expenditure on " + expenditureNames[i] + ": ");
            Monthly_expenditures[i] = inputDevice.nextDouble();
        }

        // Calculating the total expenditure
        double totalExpenditures = 0;
        for (double expenditure : Monthly_expenditures) {
            totalExpenditures += expenditure;
        }

        // Choices of accommodation
        System.out.print("Is your choice to rent accommodation or buy a property? (rent/buy): ");
        String accommodationChoice = inputDevice.next();

        double accommodationCost;

        if (accommodationChoice.equals("rent")) {
            System.out.print("Enter your monthly rental amount: ");
            accommodationCost = inputDevice.nextDouble();
        }
            else if (accommodationChoice.equals("buy")) {
            System.out.print("Enter the purchase price of the property: ");
            double purchasePrice = inputDevice.nextDouble();

            System.out.print("Enter the total deposit: ");
            double deposit = inputDevice.nextDouble();

            System.out.print("Enter the interest rate (percentage): ");
            double interestRate = inputDevice.nextDouble();

            System.out.print("Enter the number of months to repay (between 240 and 360): ");
            int repaymentMonths = inputDevice.nextInt();

            // Calculating monthly home loan repayment
            double loanAmount = purchasePrice - deposit;
            double monthlyInterestRate = interestRate / 100 / 12;
            double monthlyRepayment = (loanAmount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -repaymentMonths));
        
            accommodationCost = monthlyRepayment;
            }    
        
        // Vehicle financing
        System.out.print("Do you want to buy a vehicle? (yes/no): ");
        String vehicleChoice = inputDevice.next();
        
        double totalVehicleCost = 0;

        // If the user chooses to buy a vehicle, display a list of car models and their prices
        if (vehicleChoice.equals("yes")) {
            String[] Car_list = {"bmw", "mercedes", "toyota", "nissan", "audi", "chevrolet", "ferrari", "isuzu", "ford"};
            int[] Price_list = {130000, 2200000, 87000, 59000, 100000, 250000, 1260000, 78000, 100000};

            System.out.println("vehicle models");

            for (String show_Car : Car_list) {
                System.out.println(show_Car);
            }

            System.out.print("Enter the model and make of the vehicle: ");
            String modelAndMake = inputDevice.next();

            // Display the price of the selected car model
            if (modelAndMake.equals("bmw")) {
                System.out.println("The price of bmw is : $" + Price_list[0]);
            } else if (modelAndMake.equals("mercedes")) {
                System.out.println("Price of the mercedes is : $" + Price_list[1]);
            } else if (modelAndMake.equals("toyota")) {
                System.out.println("Price of the toyota is : $" + Price_list[2]);
            } else if (modelAndMake.equals("nissan")) {
                System.out.println("Price of nissan is : $" + Price_list[3]);
            } else if (modelAndMake.equals("audi")) {
                System.out.println("Price of audi is : $" + Price_list[4]);
            } else if (modelAndMake.equals("chevrolet")) {
                System.out.println("Price of chevrolet is : $" + Price_list[5]);
            } else if (modelAndMake.equals("ferrari")) {
                System.out.println("Price of ferarri is : $" + Price_list[6]);
            } else if (modelAndMake.equals("isuzu")) {
                System.out.println("Price of isuzu is : $" + Price_list[7]);
            } else if (modelAndMake.equals("ford")) {
                System.out.println("Price of ford is : $" + Price_list[8]);
            } else {
                System.out.println("Invalid car choice");
            }

            System.out.print("Enter the purchase price of the vehicle: ");
            double vehiclePrice = inputDevice.nextDouble();

            System.out.print("Enter the total deposit: ");
            double vehicleDeposit = inputDevice.nextDouble();

            System.out.print("Enter the interest rate (percentage): ");
            double vehicleInterestRate = inputDevice.nextDouble();

            System.out.print("Enter the estimated insurance premium: ");
            double insurancePremium = inputDevice.nextDouble();

            // Calculating monthly vehicle loan repayment
            double vehicleLoanAmount = vehiclePrice - vehicleDeposit;
            double vehicleMonthlyInterestRate = vehicleInterestRate / 100 / 12;
            double vehicleMonthlyRepayment = (vehicleLoanAmount * vehicleMonthlyInterestRate) /
                    (1 - Math.pow(1 + vehicleMonthlyInterestRate, -60)); // 5 years = 60 months

            totalVehicleCost = vehicleMonthlyRepayment + insurancePremium;
        }

        // Check if total expenditures exceed 75% of gross income
        if (totalExpenditures > 0.75 * grossIncome) {
            System.out.println("Warning: Your total expenses exceed 75% of your gross income.");
            return;
        }

        // Calculating the net monthly income
        double netMonthlyIncome = grossIncome - taxDeducted - totalExpenditures - accommodationCost - totalVehicleCost;

        // Displaying the results
        System.out.println("Gross Monthly Income: " + grossIncome);
        System.out.println("Estimated Monthly Tax Deducted: " + taxDeducted);
        System.out.println("Total Monthly Expenditures: " + totalExpenditures);
        System.out.println("Accommodation Cost: " + accommodationCost);
        System.out.println("Total Vehicle Cost: " + totalVehicleCost);
        System.out.println("Net Monthly Income: " + netMonthlyIncome);
    
}
}
