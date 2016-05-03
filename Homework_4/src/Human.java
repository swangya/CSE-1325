import java.io.*;
import java.util.Scanner;

public class Human implements java.io.Serializable {
    String FName;
    String LName;
    int Age;

    public void setFName(String f){
        FName = f;
    }

    public void setLName(String l){
        LName = l;
    }

    public void setAge(int ag){
        Age = ag;
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

}
