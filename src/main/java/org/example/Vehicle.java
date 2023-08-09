package org.example;

import java.text.NumberFormat;

public class Vehicle {

    private int gas = 100;

    private String model;

    private Boolean driving;

    private Boolean gettingGas;

    private int price;

    public static int numberOfVehicles;

    public Vehicle(String model){
        setModel(model);
    }
    public Vehicle(int price, String model, int gas, Boolean driving, Boolean gettingGas ){
        setModel(model);
        setGas(gas);
        setPrice(price);
        setDriving(driving);
        setGettingGas(gettingGas);
        numberOfVehicles++;
    }

    public static void printNumberOfVehicles(){
        System.out.println(Vehicle.numberOfVehicles + " Vehicles.");
    }


    public Boolean getDriving() {
        return driving;
    }

    public void setDriving(Boolean driving) {
        if(driving){
            System.out.println("Driving the " + model + ", Calculating Gas.... ");
            gas = (gas - 5);
            System.out.println(gas);
        }

        this.driving = driving;
    }

    public Boolean getGettingGas() {
        return gettingGas;
    }

    private void setGettingGas(Boolean gettingGas) {
        if(gettingGas && gas < 160){
            System.out.println("Stopping at the gas station!... ");
            System.out.println("Refilling the " + model + "...");
            gas = (gas + 2);
            System.out.println(gas);
        }
        else {
            setGas(160);
            gettingGas = false;
            System.out.println("Sorry, you're all filled up! ");
            System.out.println("Current Max Gas: " + gas);
        }


        this.gettingGas = gettingGas;
    }


    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public String getModel() {
        if(model.equals("BMW")){
            System.out.println("Congrats, You have a bad car on gas!.. A " + model + "!");
        }
        else {
            System.out.println("Now that's a reliable car! " + model);
        }
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private int getPrice() {
        System.out.println("Total Price: " +  model + " " +  NumberFormat.getCurrencyInstance().format(price));
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
