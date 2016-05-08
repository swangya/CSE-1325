import java.io.Serializable;
import java.util.*;

public class Roster implements java.io.Serializable {
    public int rosterId;
    public String rosName;
    int nument;

    transient Scanner read = new Scanner(System.in);

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

//    addEntry ob1 = new addEntry(lst);
    int temp;
    void settemp(int a){
        temp = a;
    }
    Human xtemp = new Human();
    void setHum(Human x){
        xtemp=x;
    }
    void addEntry(int a, int b){
        if(b==1){
            Human x = new Human();
            String nam1, nam2;

            System.out.print("Enter First Name: ");
            nam1=read.next();
            x.setFName(nam1);

            System.out.print("Enter Last Name: ");
            nam2=read.next();
            x.setLName(nam2);

            System.out.print("Enter Age: ");
            nument=read.nextInt();
            x.setAge(nument);

            x.setId(a);

            setHum(x);
            settemp(a);

            lst.put(a, x);
            idchk.add(a);
            System.out.println("Entry added.\n");
        }
        else if(b==2){
            lst.put(a, xtemp);
            idchk.add(a);
        }
        else{
            lst.remove(temp);
        }




//        if(b==1){
//            ob1.set_idchk(idchk);
//            ob1.seta(a);
//            lst=ob1.execute();
//            idchk=ob1.get_idchk();
//        }
//        else if(b==2){
//            lst=ob1.redo();
//            idchk=ob1.get_idchk();
//        }
//        else{
//            lst=ob1.undo();
//            idchk=ob1.get_idchk();
//        }
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
        else if(b==2){
            lst=ob3.redo();
            idchk=ob3.get_idchk();
        }
        else{
            lst=ob3.undo();
            idchk=ob3.get_idchk();
        }
    }


    delEntry ob2 = new delEntry(lst);
    void delEntry(int b){
        if(b==1){
            ob2.set_idchk(idchk);
            lst=ob2.execute();
            idchk=ob2.get_idchk();
        }
        else if(b==2){
            lst=ob2.redo();
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

    void clear(){
        rosName=null;
        rosterId=0;
        lst.clear();
    }
}
