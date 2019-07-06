package com.codegym.service;

import com.codegym.persistence.CalculatorPersistenceImpl;

public class CalculatorServiceImpl implements GeneralService {
    CalculatorPersistenceImpl calculatorPersistence = new CalculatorPersistenceImpl();
    @Override
    public float add(float a, float b) {
        return calculatorPersistence.add(a,b);
    }

    @Override
    public float sub(float a, float b) {
        return calculatorPersistence.sub(a,b);
    }

    @Override
    public float mul(float a, float b) {
        return calculatorPersistence.mul(a,b);
    }

    @Override
    public float div(float a, float b) {
        return calculatorPersistence.div(a,b);
    }
}
