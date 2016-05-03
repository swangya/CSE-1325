import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Roster implements java.io.Serializable {

    public int rosterId;
    public int nument;
    public int flg=0;

    String rosName;
    HashMap<Integer, Human> lst= new HashMap<Integer, Human>();
    List<Integer>idchk= new ArrayList<>();

    Scanner read = new Scanner(System.in);

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

    void modEntry(){
        Human z;
        int modId;
        int choice;
        System.out.print("Enter Id to be modified");
        modId=read.nextInt();
        if(lst.containsKey(modId)){
            System.out.println("\nEntry Found! \n");
            z=lst.get(modId);
            printEntry(z, modId);
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
            printEntry(z, modId);
            System.out.println("Do You esnt to delete entry? (y/n)");
            choice = read.next().trim().charAt(0);
            if (choice == 'y') {
                lst.remove(modId);
            }
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

    /*void sortAge(){
        int check_r = 0;
        for(Integer key_r: classroomRoster.keySet())
        {
            if (key_r == i){
                check_r =1;
                Set<Entry<Integer, Student>> set = classroomRoster.get(key_r).studentList.entrySet();
                List<Entry<Integer, Student>> list = new ArrayList<Entry<Integer, Student>>(set);
                Collections.sort(list, new Comparator<HashMap.Entry<Integer, Student>>() {
                    @Override
                    public int compare(HashMap.Entry<Integer, Student> o1, HashMap.Entry<Integer, Student> o2) {
                        return(o1.getValue().getStudentAge())-(o2.getValue().getStudentAge());
                    }
                });
                Roster roster = classroomRoster.get(i);
                System.out.println("Roster ID: " + roster.getRosterID());
                System.out.println("Roster Name: " + roster.getRosterName());
                System.out.println("Student");
                for (HashMap.Entry<Integer, Student> entry: list){
                    System.out.println("StudentID: " +entry.getValue().getStudentID());
                    System.out.println("Student Age: " +entry.getValue().getStudentAge());
                    System.out.println("Student First name: " +entry.getValue().getFirstname());
                    System.out.println("Student Last name: " +entry.getValue().getLastname());
                }
            }
        }*/

}


