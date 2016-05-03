import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Map.Entry;

public class rosterOp implements java.io.Serializable {
    public int stuId=1;
    public int teachId=10001;
    public int nument;
    HashMap<Integer, Roster> rosLst = new HashMap<>();
    List<Integer>idchk= new ArrayList<>();

    transient Scanner read = new Scanner(System.in);

    public boolean idchk(int a){
        return idchk.contains(a);
    }

    public int printOptions(){
        int choice;

        System.out.println("1.\tCreate a Roster.");
        System.out.println("2.\tModify a Roster.");
        System.out.println("3.\tDelete a Roster.");
        System.out.println("4.\tPrint a Roster.");
        System.out.println("5.\tPrint All Rosters.");
        System.out.println("6.\tSort a Roster");
        System.out.println("7.\tSort all Rosters");
        System.out.println("8.\tCopy Roster");
        System.out.println("9.\tSerialize a Roster");
        System.out.println("10.\tSerialize all Roster");
        System.out.println("11.\tEXIT");

        System.out.print("Enter your choice: ");
        choice=read.nextInt();
        return choice;
    }

    public void createRoster(){
        String r;
        Roster x = new Roster();
        System.out.print("Enter the Id for roster: ");
        nument = read.nextInt();
        if(idchk(nument)){
            System.out.print("Roster with this Id Already Exist");
        }
        else {
            System.out.print("Enter the Name for roster: ");
            r = read.next();
            x.setRosterId(nument);
            x.setRosName(r);
            rosLst.put(nument, x);
            idchk.add(nument);
            System.out.println("The Roster has been Created.\n");
        }
    }

    public void modRoster(){
        Roster x;
        int choice;
        int id;

        System.out.print("Enter the Roster id: ");
        id=read.nextInt();
        if(rosLst.containsKey(id)){
            x=rosLst.get(id);
            System.out.println("\nRoster Found\n");
            System.out.println("1.\tAdd Student.");
            System.out.println("2.\tAdd Teacher.");
            System.out.println("3.\tModify Entry.");
            System.out.println("4.\tDelete Entry.\n");

            System.out.print("Enter your choice: ");
            choice=read.nextInt();

            switch (choice){
                case 1:
                    x.addEntry(stuId);
                    stuId++;
                    break;
                case 2:
                    if(x.getflg()<1) {
                        x.addEntry(teachId);
                        teachId++;
                        x.setflg(1);
                    }
                    else
                        System.out.println("There is already a teacher in this Roster.");
                    break;
                case 3:
                    x.modEntry();
                    break;
                case 4:
                    x.delEntry();
                    break;
                default:
                    System.out.println("incorrect entry!");
                    break;
            }
        }


    }

    public void delRoster(){
        int delId;
        System.out.print("Enter the Id of the Roster: ");
        delId=read.nextInt();
        if(rosLst.containsKey(delId)){
            System.out.println("Roster Found\n");
            rosLst.remove(delId);
        }

    }

    public void printRoster(){
        Roster x;
        int id;

        System.out.print("Enter the Roster id: ");
        id=read.nextInt();

        if(rosLst.containsKey(id)){
            x=rosLst.get(id);

            System.out.println("Roster: " +  x.getRosterId());
            x.printRoster();
        }
        else
            System.out.println("Roster Not Found!\n");


    }

    public void printAll(){
        Roster x;
        for (int key : rosLst.keySet()){
            x=rosLst.get(key);
            x.printRoster();
        }
    }

    public void copyRoster(){
        Roster x;
        int newId;
        Roster y= new Roster();
        String nam;
        int ident;
        System.out.print("Enter the Roster Id to copy: ");
        ident=read.nextInt();
        if(rosLst.containsKey(ident)){
            x=rosLst.get(ident);
            y.lst=x.lst;
            y.idchk=x.idchk;
            System.out.println("Roster found Initiating Copy.");
            System.out.print("Enter Name for Roster: ");
            nam=read.next();
            y.setRosName(nam);
            newId=ident;
            while(true){
                System.out.println("THis runs");
                System.out.println(newId);
                newId=newId*2;
                if(!idchk.contains(newId)){
                    break;
                }
            }
            System.out.println(newId);
            y.setRosterId(newId);
            idchk.add(newId);
            rosLst.put(newId, y);
            System.out.println("Roster Has been copied.");
        }
    }

    void sortRoster(){
        Roster x;
        int choice;
        int key;
        System.out.println("1. Sort by Age.");
        System.out.println("2. Sort by Id.");
        System.out.print("Enter your Choice: ");
        choice=read.nextInt();
        if(choice==1){
            sortAge();
        }
        else{
            System.out.print("Enter the roster Id: ");
            key=read.nextInt();
            x=rosLst.get(key);
            x.sortId();
        }
    }

    void sortAge() {
        int i;
        System.out.print("Enter Roster Id: ");
        i = read.nextInt();
        for (Integer key_r : rosLst.keySet()) {
            if (key_r == i) {
                Set<Entry<Integer, Human>> set = rosLst.get(key_r).lst.entrySet();
                List<Entry<Integer, Human>> list = new ArrayList<>(set);
                Collections.sort(list, new Comparator<HashMap.Entry<Integer, Human>>() {
                    @Override
                    public int compare(HashMap.Entry<Integer, Human> o1, HashMap.Entry<Integer, Human> o2) {
                        return (o1.getValue().getAge()) - (o2.getValue().getAge());
                    }
                });

                Roster roster = rosLst.get(i);
                System.out.println("======================================");
                System.out.println("Roster Id " + roster.getRosterId() );
                System.out.println("Roster Name: " + roster.getRosterId());
                for (HashMap.Entry<Integer, Human> entry : list) {
                    if(entry.getValue().getId()<10000)
                        System.out.println("Student:");
                    else
                        System.out.println("Teacher:");

                    entry.getValue().printEntry();
                }
                System.out.println("======================================");
            }
        }
    }

    void sortAll(){
        Roster x;
        for (int key : rosLst.keySet()){
            x=rosLst.get(key);
            x.sortId();
        }
    }

    public void serializeARoster(){
        System.out.println("Enter the roster ID to serialize :");
        int ID = read.nextInt();
        Roster r = rosLst.get(ID);

        if(r!=null) {
            System.out.println("Enter a file name to write the roster " + r.getrosName() + " to: ");
            String f_name = read.next();
            if (!f_name.equals("")) {

                try {
                    OutputStream file = new FileOutputStream(f_name);
                    System.out.println("File is " + file);

                    System.out.println("1");
                    try{
                        ObjectOutputStream objOut = new ObjectOutputStream(file);
                        System.out.println("2");
                        objOut.writeObject(r);
                        System.out.println("3");
                        System.out.println("Roster " + r.getrosName() + " has been serialized successfully!");
                    }
                    catch (Exception e){
                        System.out.println("Object Write error.\n\t" + e);
                    }
                } catch (Exception e) {
                    System.out.println("File not Found.\n\t" + e);
                }

            }
            else {
                System.out.println("\nBreaking from current operation.\n");
            }
        }
    }

    public void serializeallrosters(){
        System.out.println("Enter a file name to write the rosters to: ");
        String fname = read.next();
        if (!fname.equals("")) {
            try {
                OutputStream file = new FileOutputStream(fname);
                try{
                    ObjectOutputStream objOut = new ObjectOutputStream(file);
                    for(Roster i : rosLst.values()) {
                        objOut.writeObject(i);
                    }
                    System.out.println("Rosters have been serialized successfully!");

                }
                catch (Exception e){
                    System.out.println("Object Write error.\n\t" + e);
                }
            } catch (Exception e) {
                System.out.println("File not Found.\n\t" + e);
            }

        } else {
            System.out.println("\nBreaking from current operation.\n");
        }

    }
}