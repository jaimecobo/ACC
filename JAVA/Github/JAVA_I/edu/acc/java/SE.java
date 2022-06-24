/* in-class demo code for review */

package edu.acc.java;

public class SE {
    int[] y = {1,2,3};
    int x = 8;
    String a = "a";
    String b = new String("a");
    
    public static void main(String... args) {
        SE se = new SE();
        System.out.println("BEFORE x=" + se.x);
        System.out.println("BEFORE y[0]=" + se.y[0]);
        se.meth(se.x, se.y);
        System.out.println("AFTER x=" + se.x);
        System.out.println("AFTER y[0]=" + se.y[0]);

        System.out.println(se.a.equals(se.b));
        System.out.println(se);
    }

    public void meth(int v, int[] vv) {
        v = 6;
        vv[0] = 10;
    }

    public String toString() {
        return "Hey, this is Thursday!";
    }
   
}