package model;

import model.validator.*;


/**
 * The {@code Factory} class serves as a factory for creating instances of the {@code Validator} class based on a specified number.
 * It provides a method {@code addValidator} that takes a secret code and a number as parameters and returns an appropriate validator instance.
 *
 * @author Your Name
 * @version 1.0
 */
public class Factory {

      /**
       * Constructs a new Factory instance.
       */

    public Factory() {

    }

      /**
       * Creates and returns an instance of the {@code Validator} class based on the specified number and secret code.
       * The method uses a switch statement to determine the type of validator to create.
       *
       * @param secret The secret code to be used by the validator.
       * @param number The number specifying the type of validator to create.
       * @return An instance of the {@code Validator} class.
       * @throws TuringException If the specified number does not correspond to any known validator type.
       */

    public  Validator addValidator(Code secret , int number){
      return switch (number){
            case 1 -> new CompareDigitToValue(secret,1,true);

            case 2  ->new CompareDigitToValue(secret,3,true);

            case 3 -> new CompareDigitToValue(secret,3,false);

            case 4 -> new CompareDigitToValue(secret,4,false);

            case 5 -> new VerifyTheParityOfADigit(5,secret);

            case 6 -> new VerifyTheParityOfADigit(6,secret);

            case 7 -> new VerifyTheParityOfADigit(7,secret);

            case 8 -> new CountValueNumber(secret,1);

            case 9 -> new CountValueNumber(secret,3);

            case 10 -> new CountValueNumber(secret,4);

            case 11 -> new CompareTwoDigits(11,secret);

            case 12 -> new CompareTwoDigits(12,secret);

            case 13 -> new CompareTwoDigits(13,secret);

            case 14 -> new ExtremeFigure(secret,true);

            case 15 -> new ExtremeFigure(secret,false);

            case 16 -> new MostFrequentParity(secret);

            case 17 -> new CountTheNumbersPeers(secret);

            case 18 -> new ParityOfTheSumNumbers(secret);

            case 19 -> new CompareTheAmountTwoDigits(secret);

            case 20 -> new NumberOfRepetitions(secret);

            case 21 -> new TwinDigits(secret);

            case 22 -> new OrderOfNumbers(secret);

            default -> throw new TuringException("Retry the number");};
    }


}
