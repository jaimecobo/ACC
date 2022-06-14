public class Countdown {

    public static void main(String[] zzz) {
    // print 10 to 0 then "Liftoff!"

    // iterative solution
    for (int count=10; count >= 0; count--) {
        System.out.println(count);
    }
    System.out.println("Liftoff!");

    // recursive solution
    do_countdown(10);
    }

    public static void do_countdown(int count) {
        if (count >= 0) {
            System.out.println(count);
            do_countdown(count - 1);
        }
        else {
            System.out.println("Liftoff!");
        }
    }
}