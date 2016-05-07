import java.util.*;

public class Roster {
    public int rosterId;
    public String rosName;

    HashMap<Integer, Human> lst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int flg=0;

    void setflg(int a){
        flg=a;
    }
    int getflg(){
        return flg;
    }

    void setRosterId(int a){
        rosterId = a;
    }
    void setRosName(String a){
        rosName = a;
    }

    int getRosterId(){
        return rosterId;
    }
    String getrosName(){
        return rosName;
    }

    addEntry ob1 = new addEntry(lst);
    void addEntry(int a, int b){
        if(b==1){
            ob1.set_idchk(idchk);
            ob1.seta(a);
            lst=ob1.execute();
            idchk=ob1.get_idchk();
        }
        else{
            lst=ob1.undo();
            idchk=ob1.get_idchk();
        }
    }

    void printRoster(){
        Human z;
        System.out.println("======================================");
        System.out.println("Roster Id " + rosterId );
        System.out.println("Roster Name: " + rosName);
        for (int key : lst.keySet()){
            z=lst.get(key);
            if(key<10000)
                System.out.println("Student:");
            else
                System.out.println("Teacher:");
            printEntry(z, key);
        }
        System.out.println("======================================");
    }

    void printEntry(Human z, int a){
        System.out.println("-----------------------------------");
        System.out.println("Id:\t\t\t\t " + a);
        System.out.println("Age:\t\t\t " + z.getAge());
        System.out.println("First Name:\t\t " + z.getFName());
        System.out.println("last Name:\t\t " + z.getLName());
        System.out.println("-----------------------------------");
    }

    modEntry ob3 = new modEntry(lst);
    void modEntry(int b){
        if(b==1){
            ob3.set_idchk(idchk);
            lst=ob3.execute();
            idchk=ob3.get_idchk();
        }
        else{
            lst=ob3.undo();
            idchk=ob3.get_idchk();
        }
    }


    /*---------------------------------------------------------------
    Remember to correct idchk.
   -----------------------------------------------------------------*/


    delEntry ob2 = new delEntry(lst);
    void delEntry(int b){
        if(b==1){
            ob2.set_idchk(idchk);
            lst=ob2.execute();
            idchk=ob2.get_idchk();
        }
        else{
            lst=ob2.undo();
            idchk=ob2.get_idchk();
        }
    }

    void sortId(){
        Map<Integer, Human> treeMap = new TreeMap<Integer, Human>(lst);
        Human z;
        System.out.println("======================================");
        System.out.println("Roster Id " + rosterId );
        System.out.println("Roster Name: " + rosName);
        for (int key : treeMap.keySet()){
            z=treeMap.get(key);
            if(key<10000)
                System.out.println("Student:");
            else
                System.out.println("Teacher:");
            printEntry(z, key);
        }
        System.out.println("======================================");
    }



}
