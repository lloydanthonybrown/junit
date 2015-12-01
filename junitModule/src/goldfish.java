/**
 * Created by Lloyd on 11/30/2015.
 */

public class Goldfish {
    private int age;
    private String name;
    private int length;
    private String color;

    public int sum(int var1, int var2){
        System.out.println("Adding values: " + var1 + " + " + var2);
        return var1 + var2;
    }

    public int multiply(int x, int y){
        if (x > 999){
            throw new IllegalArgumentException("X should be less than 1000");
        }
        return x * y;
    }




//    public void main (String[] args){
//
//    }
}
