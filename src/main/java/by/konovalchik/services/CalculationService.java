package by.konovalchik.services;

import by.konovalchik.services.operations.MathOperation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;


public class CalculationService {

   public static Optional<Double> getResult(double num1, double num2, String operation) {
        double result;
       if(MapOperations.MAP_OPERATIONS.containsKey(operation) && (!(operation.equals("division") && num2 == 0))){
          MathOperation math = MapOperations.MAP_OPERATIONS.get(operation);
          result = math.getCalculate(num1, num2);
          BigDecimal resultBD = new BigDecimal(result);
          resultBD = resultBD.setScale(3, RoundingMode.DOWN);
          return Optional.of(resultBD.doubleValue());
       }
       else{
           return Optional.empty();
       }
   }

}
