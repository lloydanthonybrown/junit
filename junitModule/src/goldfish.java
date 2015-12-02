import java.util.ArrayList;

/**
 * Created by Lloyd on 11/30/2015.
 */

public class Goldfish {
    private int age;
    private String name;
    private int length;
    private String color;

    public Goldfish(){

    }

    public Goldfish(int fishAge, String fishName, int fishLength, String fishColor){

    }

    public boolean isDead() {
        return isDead;
    }
    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    private boolean isDead;
    private int distance = 10;

    // Method for ... addition.
    public int sum(int var1, int var2){
        System.out.println("Adding values: " + var1 + " + " + var2);
        return var1 + var2;
    }

    // Method for ... multiplication.
    public int multiply(int x, int y){
        if (x > 999){
            throw new IllegalArgumentException("X should be less than 1000");
        }
        return x * y;
    }

    // Method for eating.
    public boolean eat(){
        if (isDead == false){
            return true;
        }
        return false;
    }

    // Method for jumping.
    public int jump(int distance){
        return 5;
    }


}
