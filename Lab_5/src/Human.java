import java.io.*;
import java.util.*;

public class Human implements Comparator<Human>{
    int id;
    String FName;
    String LName;
    int Age;

    public void setId(int a){
        id = a;
    }

    public void setFName(String f){
        FName = f;
    }

    public void setLName(String l){
        LName = l;
    }

    public void setAge(int ag){
        Age = ag;
    }

    public int getId(){
        return id;
    }

    public String getFName(){
        return FName;
    }

    public String getLName(){
        return LName;
    }

    public int getAge(){
        return Age;
    }

    void printEntry(){
        System.out.println("-----------------------------------");
        System.out.println("Id:\t\t\t\t " + id);
        System.out.println("Age:\t\t\t " + Age);
        System.out.println("First Name:\t\t " + FName);
        System.out.println("last Name:\t\t " + LName);
        System.out.println("-----------------------------------");
    }

    @Override
    public int compare(Human a, Human b){
        return a.id - b.id;
    }
}
