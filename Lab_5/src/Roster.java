import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Roster implements java.io.Serializable {

    public int rosterId;
    public int nument;
    public int flg=0;

    String rosName;
    HashMap<Integer, Human> lst= new HashMap<>();
    List<Integer>idchk= new ArrayList<>();

    transient Scanner read = new Scanner(System.in);

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

    void addEntry(int a){
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

        lst.put(a, x);
        idchk.add(a);
        System.out.println("Entry added.\n");
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
            z.printEntry();
        }
        System.out.println("======================================");
    }

    void modEntry(){
        Human z;
        int modId;
        int choice;
        System.out.print("Enter Id to be modified");
        modId=read.nextInt();
        if(lst.containsKey(modId)){
            System.out.println("\nEntry Found! \n");
            z=lst.get(modId);
            z.printEntry();
            System.out.println("1.\t Modify ID");
            System.out.println("2.\t Modify Age");
            System.out.println("3.\t Modify First Name");
            System.out.println("4.\t Modify Last Name");
            System.out.print("Enter a choice: ");
            choice=read.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter ID: ");
                    nument=read.nextInt();
                    if(idchk.contains(nument)){
                        System.out.println("This Id already exist");
                        System.out.println("Roster Not Modified\n");
                        break;
                    }
                    else {
                        lst.remove(modId);
                        z.setId(nument);
                        lst.put(nument, z);
                        idchk.remove(modId);
                        idchk.add(nument);
                        System.out.println("Roster Modified\n");
                    }
                    break;
                case 2:
                    System.out.print("Enter Age: ");
                    nument=read.nextInt();
                    z.setAge(nument);
                    lst.remove(modId);
                    lst.put(modId, z);
                    System.out.println("Roster Modified\n");
                    break;
                case 3:
                    String char1;
                    System.out.print("Enter First Name: ");
                    char1=read.next();
                    z.setFName(char1);
                    lst.remove(modId);
                    lst.put(modId, z);
                    System.out.println("Roster Modified\n");
                    break;
                case 4:
                    String char2;
                    System.out.print("Enter Last Name: ");
                    char2=read.next();
                    z.setLName(char2);
                    lst.remove(modId);
                    lst.put(modId, z);
                    System.out.println("Roster Modified\n");
                    break;
                default:
                    System.out.println("incorrect entry!");
                    break;
            }
        }
    }

    void delEntry(){
        Human z;
        int modId;
        char choice;
        System.out.println("Enter Id to be modified");
        modId=read.nextInt();
        if(lst.containsKey(modId)) {
            System.out.println("Entry Found! \n");
            z = lst.get(modId);
            z.printEntry();
            System.out.println("Do You esnt to delete entry? (y/n)");
            choice = read.next().trim().charAt(0);
            if (choice == 'y') {
                lst.remove(modId);
            }
        }
    }

    void sortId() {
        Map<Integer, Human> treeMap = new TreeMap<>(lst);
        List<Human> list = new ArrayList<>();
        for (int key : treeMap.keySet()) {
            list.add(treeMap.get(key));
        }
        Collections.sort(list, new Human());
        for (Human a : list) {
            a.printEntry();
        }
    }
}


