package by.konovalchik.services;

import by.konovalchik.dao.LogOperationsDAO;
import by.konovalchik.entity.User;
import by.konovalchik.services.operations.MathOperation;
import by.konovalchik.entity.Operation;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
