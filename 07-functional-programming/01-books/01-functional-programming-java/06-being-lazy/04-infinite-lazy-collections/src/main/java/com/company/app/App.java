package com.company.app;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App
{
    public static boolean isPrime(final int number){
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }
    static int primeAfter(final int number){
        if(isPrime(number + 1)){
            return number + 1;
        }
        else{
            return primeAfter(number + 1);
        }
    }
    static List<Integer> primes(final int fromNumber, final int count){
        return Stream.iterate(primeAfter(fromNumber - 1), App::primeAfter)
                .limit(count)
                .collect(Collectors.toList());
    }
    public static void main( String[] args )
    {
        System.out.println("10 primes from 1: " + primes(1, 10));
        System.out.println("5 primes from 100: " + primes(100, 5));

        System.out.println("#streamTest");
        streamTest();

        System.out.println("#intStreamTest");
        intStreamTest();
    }

    private static void streamTest() {
        /*
        iterate() takes two arguments: a seed and a function
        A seed is the first element of the stream. The second element is generated by applying the function to the first
        element. The third element is generated by applying the function on the second element, and so on.
         */
        Stream<Integer> numbers = Stream.iterate(1, n -> n * 2)
                .limit(3);
        numbers.forEach(n -> System.out.printf("%s ", n));
        System.out.println("");
        Stream<Integer> negativeNumbers = Stream.iterate(-1, n -> n * 2)
                .limit(3);
        negativeNumbers.forEach(n -> System.out.printf("%s ", n));
        System.out.println("");
    }

    /*
    rangeClosed(1,3) will return the range of value 1,2,3 packed into a Stream.
     */
    private static void intStreamTest() {
        System.out.println("##print each item in rangeClosed");
        IntStream.rangeClosed(1, 3).forEach(n -> System.out.printf("%s ", n));
        System.out.println("");

        System.out.println("##noneMatch false");
        boolean result1 = IntStream.rangeClosed(1, 3).noneMatch(n -> {
            System.out.printf("%s ", n);
            return n % 2 == 0;
        });
        System.out.println("\n1,2,3 none-match n % 2 ? "+result1);

        System.out.println("##noneMatch true");
        boolean result2 = IntStream.rangeClosed(1, 3).noneMatch(n -> {
            System.out.printf("%s ", n);
            return n % 4 == 0;
        });
        System.out.println(result2);
    }
}
/*
output:
10 primes from 1: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
5 primes from 100: [101, 103, 107, 109, 113]
#streamTest
1 2 4
-1 -2 -4
#intStreamTest
##print each item in rangeClosed
1 2 3
##noneMatch false
1 2
1,2,3 none-match n % 2 ? false
##noneMatch true
1 2 3 true
 */
