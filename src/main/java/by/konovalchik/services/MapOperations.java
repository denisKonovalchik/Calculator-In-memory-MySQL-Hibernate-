package by.konovalchik.services;

import by.konovalchik.services.operations.*;
import java.util.HashMap;
import java.util.Map;

public class MapOperations {
public  static Map<String, MathOperation > MAP_OPERATIONS = new HashMap<>();


    static{
        MAP_OPERATIONS.put("addition", new Addition());
        MAP_OPERATIONS.put("division", new Division());
        MAP_OPERATIONS.put("multiplication", new Multiplication());
        MAP_OPERATIONS.put("subtraction", new Subtraction());
    }

}
