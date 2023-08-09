package org.example;

import java.text.NumberFormat;

public class MortgageCalculator {


    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double[] getRemainingBalances(){
//        set the array to the equal of the number of payments. GetNumberOfPayments() method
        var balances = new double[getNumberOfPayments()];
        //        loop through the array and calculate the balance for each month
        for (short month = 1; month <= balances.length; month++)
            //        add the balance to the array
            balances[month - 1] = calculateBalance(month);

        return balances;
    }

    public double calculateBalance(short numberOfPaymentsMade ) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        return principal
                //       calculate the monthly interest this in math terms is saying 1 + m to the power of n
                // we need to add 1 because we are subtracting 1 from the other side of the equation
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public short getYears() {
        return years;
    }
}
