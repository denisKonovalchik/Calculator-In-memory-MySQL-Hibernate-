package by.konovalchik.services.operations;




public class Addition implements MathOperation {

    @Override
    public double getCalculate(double... num) {
        double result = num[0];
        for(int i = 1; i < num.length; i++){
            result+= num[i];
        }
        return result;
    }
}
