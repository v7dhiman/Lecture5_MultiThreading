import java.math.BigInteger;
import java.util.*;

public class Factorial
{
    public static void main(String args[])
    {
        //MapToObj - is used to convert InstStream --> Stream<Integer>

        int[] numbers = {10000, 20000, 50000, 30000, 43000, 50000, 65000, 15000, 42000};
        int[] smallNumbers = {1, 2, 3, 4, 5, 6, 7, 8};

        long start = System.currentTimeMillis();
        Arrays.stream(numbers)
                .mapToObj(Factorial::calculateFactorial)
                .forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("Total time taken is = " + (end - start));
    }
    public static BigInteger calculateFactorial(int number)
    {
        BigInteger result = BigInteger.ONE;
        for(int i = 2;i <= number; i++)
        {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
