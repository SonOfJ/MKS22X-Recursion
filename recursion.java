import java.util.ArrayList;
public class recursion{
    public static double sqrt(double n, double tolerance) {
      if (n == 0) {
        return n;
      }
      if (n <= 0) {
        throw new IllegalArgumentException("The input has to be positive.");
      }
      if (tolerance > 100 || tolerance <= 0) {
        throw new IllegalArgumentException("The tolerance has to be between 0 (exclusive) and 100 (inclusive).");
      }
      return better(n, n / 2, tolerance / 100.0); //Tolerance is a double so it should be divided by a double.
    }
    private static double better(double n, double guess, double tolerance) { //Function to return an accurate guess.
      if (Math.abs(guess * guess - n) / n <= tolerance) { //Is it tolerable?
        return guess;
      } else {
        return better(n, (n / guess + guess) / 2, tolerance); //Try a better guess.
      }
    }
    public static int fib(int n) {
      if (n < 0) {
        throw new IllegalArgumentException("Please input a nonnegative integer.");
      }
      return fiber(n, 0, 1); //Add two extra parameters: the first two terms in the sequence.
    }
    private static int fiber(int n, int previous, int sum) {
      if (n == 0) { //First base case.
        return previous;
      }
      if (n == 1) { //Second base case.
        return sum;
      } else {
        return fiber(n - 1, sum, sum + previous); //Move on while adding the previous number.
      }
    }
    public static ArrayList<Integer> makeAllSums(int n) {
      if (n < 0) {
        throw new IllegalArgumentException("Please input a nonnegative integer.");
      }
      ArrayList<Integer> list = new ArrayList<Integer>();
      maker(n, list, 0); //Calls for the helper.
      return list;
    }
    private static void maker(int n, ArrayList<Integer> list, int sum) { //n serves as a counter and the sum parameter is the answer that will be added to the list.
      if (n < 1) {
        list.add(sum);
      } else{
        maker(n - 1, list, sum + n); //Add the value.
        maker(n - 1, list, sum); //Don't add the value.
      }
    }
    public static void main(String[] args) {
      System.out.println(sqrt(100, 10)); //Should return some thing close to 10.
      //System.out.println(sqrt(5, 101)); //Should return error message.
      //System.out.println(sqrt(-12, 5)); //Should return error message.
      //System.out.println(sqrt(5, -100)); //Should return error message.
      System.out.println(sqrt(70.2, 1)); //Should return something fairly close to 8.38.
      System.out.println(fib(7)); //Should return 13.
      System.out.println(fib(0)); //Should return 0.
      System.out.println(fib(1)); //Should return 1.
      //System.out.println(fib(-7)); //Should return error message.
      System.out.println(fib(30)); //Testing the speed.
      System.out.println(makeAllSums(3)); //Should return a list of all possible sums.
      System.out.println(makeAllSums(6)); //Should return a list of all possible sums.
      //System.out.println(makeAllSums(-7)); //Should return a list of all possible sums.
    }
}
