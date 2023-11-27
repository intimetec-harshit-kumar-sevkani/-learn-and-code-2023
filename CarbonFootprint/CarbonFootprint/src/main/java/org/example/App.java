package org.example;

import org.example.Service.CarbonFootprintCalculator;

import javax.mail.MessagingException;


public class App 
{
    public static void main( String[] args ) throws MessagingException {
        CarbonFootprintCalculator carbonFootprintCalculator = new CarbonFootprintCalculator();
        carbonFootprintCalculator.calculateCarbonFootprint();
    }
}
