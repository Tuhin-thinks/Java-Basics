import static java.lang.System.nanoTime;
import java.lang.Math;
import java.math.BigInteger;

public class fibonacci {

    BigInteger calculate_nth_fibonacci(int n){
        BigInteger f = new BigInteger("0");
        BigInteger s = new BigInteger("1");

        if(n == 0){
            return BigInteger.valueOf(0);
        }
        else if(n==1 || n==2){
            return s;
        }
        BigInteger nth;
        for(int i=2;i<=n;i++){
            nth = f.add(s);
            f = s;
            s = nth;
        }
        return s;
    }

    public static void main(String[]args){
        int n = 1000000;
        fibonacci object = new fibonacci();

        long start = nanoTime();
        BigInteger result = object.calculate_nth_fibonacci(n);
        long end = nanoTime();

        System.out.printf("(%d)th fibonacci number=", n);
        System.out.println(result);
        System.out.printf("Time taken:%f seconds.\n", (end-start)/Math.pow(10, 9));
    }
}
