import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

public class rosterOp {
    public int stuId=1;
    public int teachId=10001;
    public int nument;
    public int lastId;
    public int lastrosid;
    int lastCommand=0;
    HashMap<Integer, Roster> rosLst = new HashMap<Integer, Roster>();
    List<Integer>idchk= new ArrayList<>();

    int rosterid=1;

    transient Scanner read = new Scanner(System.in);

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
        System.out.println("11.\tUndo");
        System.out.println("12.\tRedo");
        System.out.println("13.\tEXIT");

        System.out.print("Enter your choice: ");
        choice=read.nextInt();
        return choice;
    }

    createRoster ob1 = new createRoster();
    public void createRoster(int a){
        ob1.set_idchk(idchk);
        ob1.setRos(rosLst);
        //ob1.setNum(rosterid);
        rosterid++;
        while(idchk.contains(rosterid)){
            rosterid++;
        }
        if(a==1){
            ob1.setNum(rosterid);
            rosLst=ob1.execute();
            idchk=ob1.get_idchk();
        }
        else if(a==2){
            rosLst=ob1.redo();
            idchk=ob1.get_idchk();
        }
        else{
            rosLst=ob1.undo();
            idchk=ob1.get_idchk();
        }

        idchk=ob1.get_idchk();
        lastCommand=1;
    }

    public void modRoster(){
        Roster x;
        int choice;
        int id;

        System.out.print("Enter the Roster id: ");
        id=read.nextInt();
        if(rosLst.containsKey(id)){
            lastrosid=id;
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
                    x.addEntry(stuId, 1);
                    lastCommand=2;
                    lastId=stuId;
                    stuId++;
                    break;
                case 2:
                    if(x.getflg()<1) {
                        x.addEntry(teachId, 1);
                        teachId++;
                        lastId=teachId;
                        lastCommand=2;
                        x.setflg(1);
                    }
                    else
                        System.out.println("There is already a teacher in this Roster.");
                    break;
                case 3:
                    x.modEntry(1);
                    lastCommand=3;
                    break;
                case 4:
                    x.delEntry(1);
                    lastCommand=4;
                    break;
                default:
                    System.out.println("incorrect entry!");
                    break;
            }
        }
    }
    delRoster ob2 = new delRoster(rosLst);
    public void delRoster(int a){

        ob2.set_idchk(idchk);
        if(a==1){
            rosLst=ob2.execute();
            idchk=ob2.get_idchk();
        }
        else if(a==2){
            rosLst=ob2.redo();
            idchk=ob2.get_idchk();
        }
        else{
            rosLst=ob2.undo();
        }
        lastCommand = 5;
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

    void sortRoster(){
        Roster x;
        int choice;
        int key;
        System.out.println("1. Sort by Age.");
        System.out.println("2. Sort by Id.");
        choice=read.nextInt();
        if(choice==1){
            sortAge();
        }
        else{
            System.out.println("Enter the roster Id: ");
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
                Set<Map.Entry<Integer, Human>> set = rosLst.get(key_r).lst.entrySet();
                List<Map.Entry<Integer, Human>> list = new ArrayList<Map.Entry<Integer, Human>>(set);
                Collections.sort(list, new Comparator<HashMap.Entry<Integer, Human>>() {
                    @Override
                    public int compare(HashMap.Entry<Integer, Human> o1, HashMap.Entry<Integer, Human> o2) {
                        return (o1.getValue().getAge()) - (o2.getValue().getAge());
                    }
                });
                Roster roster = rosLst.get(i);
                System.out.println("Roster ID: " + roster.getRosterId());
                System.out.println("Roster Name: " + roster.getrosName());
                System.out.println("Student");
                for (HashMap.Entry<Integer, Human> entry : list) {
                    //System.out.println("StudentID: " +entry.getValue().());
                    System.out.println("Student Age: " + entry.getValue().getAge());
                    System.out.println("Student First name: " + entry.getValue().getFName());
                    System.out.println("Student Last name: " + entry.getValue().getLName());
                }
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

    copyRoster ob3 = new copyRoster(rosLst);
    public void copyRoster(int a){

        ob3.set_idchk(idchk);
        if(a==1){
            rosLst=ob3.execute();
            idchk=ob3.get_idchk();
        }
        else if(a==2){
            rosLst=ob3.redo();
            idchk=ob3.get_idchk();
        }
        else{
            rosLst=ob3.undo();
        }
        lastCommand = 6;
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
                        objOut.writeObject(rosLst);
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

    void undo(){
        Roster x;
        switch (lastCommand){
            case 1:
                createRoster(3);
                System.out.println("Last action Undone!");
                break;
            case 2:
                x=rosLst.get(lastrosid);
                x.addEntry(lastId, 3);
                System.out.println("Last action Undone!");
                break;
            case 3:
                x=rosLst.get(lastrosid);
                x.modEntry(3);
                System.out.println("Last action Undone!");
                break;
            case 4:
                x=rosLst.get(lastrosid);
                x.delEntry(3);
                System.out.println("Last action Undone!");
                break;
            case  5:
                delRoster(3);
                System.out.println("Last action Undone!");
                break;
            case 6:
                copyRoster(3);
                System.out.println("Last action Undone!");
                break;
            default:
                System.out.println("Last action can't be undone");
                break;
        }
    }

    void redo(){
        Roster x;
        switch (lastCommand){
            case 1:
                createRoster(2);
                System.out.println("Last action Redone!");
                break;
            case 2:
                x=rosLst.get(lastrosid);
                x.addEntry(lastId, 2);
                System.out.println("Last action Redone!");
                break;
            case 3:
                x=rosLst.get(lastrosid);
                x.modEntry(2);
                System.out.println("Last action Redone!");
                break;
            case 4:
                x=rosLst.get(lastrosid);
                x.delEntry(2);
                System.out.println("Last action Redone!");
                break;
            case  5:
                delRoster(2);
                System.out.println("Last action Redone!");
                break;
            case 6:
                copyRoster(2);
                System.out.println("Last action Redone!");
                break;
            default:
                System.out.println("Last action can't be redone");
                break;
        }
    }

}
