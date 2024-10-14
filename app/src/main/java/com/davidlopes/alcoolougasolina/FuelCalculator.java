package com.davidlopes.alcoolougasolina;

public class FuelCalculator {
    private double gasolinePrice;
    private double alcoholPrice;
    private double result;

    public FuelCalculator(double gasolinePrice, double alcoholPrice) {
        this.gasolinePrice = gasolinePrice;
        this.alcoholPrice = alcoholPrice;
    }

    public double calculate() {
        result = alcoholPrice / gasolinePrice;
        return result;
    }
}
