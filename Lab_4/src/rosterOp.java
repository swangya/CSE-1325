import java.util.*;
import java.io.*;
import java.util.Scanner;

public class rosterOp implements java.io.Serializable {
    public int stuId=1;
    public int teachId=10001;
    public int nument;
    HashMap<Integer, Roster> rosLst = new HashMap<Integer, Roster>();
    List<Integer>idchk= new ArrayList<>();

    Scanner read = new Scanner(System.in);

    public boolean idchk(int a){
        if(idchk.contains(a)){
            return true;
        }
        else{
            return false;
        }
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
        System.out.println("9.\tSearilize a Roster");
        System.out.println("10.\tEXIT");

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
        Roster x;
        int delId;
        int i;
        System.out.print("Enter the Id of the Roster: ");
        delId=read.nextInt();
        if(rosLst.containsKey(delId)){
            System.out.println("Roster Found\n");
            rosLst.remove(delId);
        }

    }

    public void printRoster(){
        Roster x = new Roster();
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
        int i;
        for (int key : rosLst.keySet()){
            x=rosLst.get(key);
            x.printRoster();
        }
    }

    public void sortRoster(){
        Roster x = new Roster();
        int choice;
        int id;

        System.out.print("Enter the Roster id: ");
        id=read.nextInt();
        if(rosLst.containsKey(id)){
            System.out.println("Roster Found\n");
            x=rosLst.get(id);
            System.out.println("1.\tSort Roster by ID.");
            System.out.println("2.\tSort Roster by Age.");

            System.out.print("Enter your choice: ");
            choice=read.nextInt();

            switch (choice) {
                case 1:
                    x.sortId();
                    break;
                case 2:
                    //x.sortAge();
                    break;
            }
        }
    }

    public void copyRoster(){
        Roster x;
        int ident;
        int newId;
        String nam;
        System.out.print("Enter the Roster Id to copy: ");
        ident=read.nextInt();
        if(rosLst.containsKey(ident)){
            x=rosLst.get(ident);
            System.out.println("Roster found Initiating Copy.");
            System.out.print("Enter Name for Roster: ");
            nam=read.next();
            x.setRosName(nam);
            newId=ident;
            while(true){
                newId=newId*2;
                if(idchk.contains(newId)){
                    continue;
                }
                else
                    break;

            }
            idchk.add(newId);
            rosLst.put(newId, x);
            System.out.println("Roster Has been copied.");
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
                    try{
                        ObjectOutputStream objOut = new ObjectOutputStream(file);
                        objOut.writeObject(r);
                        System.out.println("Roster " + r.getrosName() + " has been serialized successfully!");
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
}


