import java.math.BigInteger;
import java.util.*;

public class FactorialMT extends Thread
{
    // Increase the number of elements to --> ~25
    // Task 1 - Create separate thread for every element
    // Task 2 - create only threads equal to the number of processors you have for your JVM
    // Task 3 - 2-3 threads
    int number;
    BigInteger result;

    public static void main(String args[])
    {
        Integer[] numbers = {10000, 20000, 50000, 30000, 43000, 50000, 65000, 15000, 42000};
        Integer[] smallNumbers = {1, 2, 3, 4, 5, 6, 7, 8};
        List<FactorialMT> threads = new ArrayList<>();
        long start = System.currentTimeMillis();
        Arrays.stream(smallNumbers)
                .forEach(x -> {
                            //new FactorialMT(x).start();
//                            Thread thread = new FactorialMT(x);
//                            thread.start();
                            FactorialMT thread = new FactorialMT(x);
                            thread.start();
                            threads.add(thread);
                            //System.out.println(thread.result);

                });
        threads.stream().forEach(x ->
        {
            try {
                x.join();
                System.out.println("Input = " + x.number + " " + ", output " + x.result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("Total time taken = " + (end - start));
    }
    public FactorialMT(int number)
    {
        this.number = number;
    }
    @Override
    public void run()
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.result = calculateFactorial();
        //System.out.println("In thread: " + currentThread() + ", for number " + this.number + ", output = " + result);
    }
    public BigInteger calculateFactorial()
    {
        BigInteger result = BigInteger.ONE;
        for(int i = 2;i <= this.number; i++)
        {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
