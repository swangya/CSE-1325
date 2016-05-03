import java.util.Random;

public class Student {
    int Id;
    String FName;
    String LName;
    int Age;



    public int getId(){
        return Id;
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

    public void setFName(String fnam){
        FName = fnam;
    }

    public void setLName(String lnam){
        LName = lnam;
    }

    public void setId() {
        Random rand = new Random();
        int randomNum;
        randomNum= rand.nextInt(10000-1000)+1000;
        Id=randomNum;
    }

    public void setAge(int ag){
        Age = ag;
    }

    public void print(int count){
        System.out.println("Id: " + Id);
        System.out.println("Age: " +  Age);
        System.out.println("First Name: " +  FName);
        System.out.println("Last Name: " +  LName);
        System.out.println(" ");
    }


}

