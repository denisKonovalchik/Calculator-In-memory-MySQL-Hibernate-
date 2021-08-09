package by.konovalchik.services;

import by.konovalchik.services.operations.MathOperation;
import by.konovalchik.entity.Operation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {

    public static Operation getResult(double num1, double num2, String operation) {
        double result = 0;

       if( MapOperations.MAP_OPERATIONS.containsKey(operation)){
        MathOperation math = MapOperations.MAP_OPERATIONS.get(operation);
        result = math.getCalculate(num1, num2);
        BigDecimal resultBD = new BigDecimal(result);
        resultBD = resultBD.setScale(3, RoundingMode.DOWN);
        result = Double.parseDouble(String.valueOf(resultBD));
       }
       return new Operation(num1, num2, operation, result);
   }

}
