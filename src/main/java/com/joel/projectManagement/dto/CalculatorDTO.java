package com.joel.projectManagement.dto;

import java.math.BigDecimal;
import java.util.List;

public class CalculatorDTO {
    public List<BigDecimal> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<BigDecimal> numbers) {
        this.numbers = numbers;
    }

    private List<BigDecimal> numbers;
}


