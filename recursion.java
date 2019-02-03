public class recursion{
    public static double sqrt(double n, double tolerance) {
      return better(n, n / 2, tolerance);
    }
    private static double better(double n, double guess, double tolerance) { //Function to return an accurate guess.
      if (Math.abs(guess * guess - n) / n < tolerance) { //Is it tolerable?
        return guess;
      } else {
        return better(n, (n / guess + guess) / 2); //Try a better guess.
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 0
     *fib(1) = 1
     *fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n) {
      return fiber(n, 0); //Extra parameter to keep track of total sum.
    }
    private static int fiber(int n, int sum) {
      if (n < 2) { //If n is either 1 or 0;
        return sum + 1; //Return the sum plus 1;
      } else {
        return fiber(n - 1, sum + n); //Move onto the previous number while adding the current number.
      }
    }
    /*As Per classwork*/
    public static ArrayList<Integer> makeAllSums(int n) {
    }

}
