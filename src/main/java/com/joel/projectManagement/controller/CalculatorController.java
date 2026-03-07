package com.joel.projectManagement.controller;

import com.joel.projectManagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/calc")
public class CalculatorController {

    @GetMapping("/add")
    public  ResponseEntity<BigDecimal> add (@RequestParam("num1")  BigDecimal num1, @RequestParam("num2")  BigDecimal num2) {
        return new ResponseEntity<>(num1.add(num2), HttpStatus.OK);
    }

    @GetMapping("/sub")
    public ResponseEntity<BigDecimal> sub (@RequestParam("num1") BigDecimal num1, @RequestParam("num2") BigDecimal num2) {
        return new ResponseEntity<>(num1.subtract(num2), HttpStatus.OK);
    }

    @GetMapping("/mul")
    public ResponseEntity mul (@RequestParam("num1") BigDecimal num1, @RequestParam("num2") BigDecimal num2) {
        return new ResponseEntity(num1.multiply(num2), HttpStatus.OK);
    }

    @GetMapping("/div")
    public ResponseEntity<BigDecimal> div (@RequestParam("num1") BigDecimal num1, @RequestParam("num2") BigDecimal num2) {
        return new ResponseEntity(num1.divide(num2), HttpStatus.OK);
    }

    @GetMapping("/fact/{num}")
    public ResponseEntity<BigInteger> fact (@PathVariable("num") long num) throws Exception {
        ResponseEntity<BigInteger> responseEntity;
        if (String.valueOf(num).split(".")[0].length() > 4) {
            throw new Exception("Sorry, Number too large!");
        }
        BigInteger result = BigInteger.ONE;

        for (long i = num; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        responseEntity = new ResponseEntity(result, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/mulm")
    public ResponseEntity<BigDecimal> mulMany (@RequestBody CalculatorDTO calculatorDTO) {
        BigDecimal result = new BigDecimal(0.0);
        List<BigDecimal> numbers = calculatorDTO.getNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            result = i == 0 ? numbers.get(i) : result.multiply(numbers.get(i));
        }

        ResponseEntity<BigDecimal> responseEntity = new ResponseEntity(result, HttpStatus.CREATED);

        return responseEntity;
    }
}
