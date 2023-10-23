package org.example;

import org.example.Models.Entity;

public class Main {
    public static void main(String[] args) {
        CarbonFootprint carbonFootprint = new CarbonFootprint();
        double totalCarbonFootprint = carbonFootprint.getCarbonFootprint(new Entity("abc@xyz.com", "gmail", 10, 25, 30));
        System.out.println("Total Carbon Footprint  is  : " + totalCarbonFootprint + " g CO2e");

    }
    }
