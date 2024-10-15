package com.davidlopes.alcoolougasolina;

public class FuelCalculator {
    private double gasolinePrice = 0.0;
    private double alcoholPrice = 0.0;
    private double result;

    public FuelCalculator(double gasolinePrice, double alcoholPrice) {
        this.gasolinePrice = gasolinePrice;
        this.alcoholPrice = alcoholPrice;
    }

    public double calculate() {
        System.out.println("Gasolina: " + gasolinePrice + " alcool: " + alcoholPrice);
        result = alcoholPrice / gasolinePrice;
        return result;
    }
}
