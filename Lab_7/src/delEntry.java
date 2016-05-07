import java.util.*;

public class delEntry implements Command {
    Scanner read = new Scanner(System.in);

    HashMap<Integer, Human> lst= new HashMap<>();
    HashMap<Integer, Human> templst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int modId;

    delEntry(HashMap<Integer, Human> a){
        lst=a;
        templst=a;
    }
    int nument;

    void set_idchk(List<Integer> a){
        idchk = a;
    }
    void putid(int a){
        modId=a;
    }

    Human temp=new Human();

    void setTemp(Human a){
        temp = a;
    }

    List<Integer> get_idchk(){
        return idchk;
    }

    @Override
    public HashMap<Integer, Human> execute(){
        Human z;
        int a;
        char choice;
        System.out.println("Enter Id to be modified");
        a=read.nextInt();

        if(lst.containsKey(a)) {
            putid(a);
            System.out.println("Entry Found! \n");
            z = lst.get(modId);
            setTemp(z);
            printEntry(z, modId);
            System.out.println("Do You want to delete entry? (y/n)");
            choice = read.next().trim().charAt(0);
            if (choice == 'y') {
                lst.remove(modId);
            }
        }
        return lst;
    }

    @Override
    public HashMap<Integer, Human> undo(){
        lst.put(modId, temp);
        return lst;
    }

    void printEntry(Human z, int a){
        System.out.println("-----------------------------------");
        System.out.println("Id:\t\t\t\t " + a);
        System.out.println("Age:\t\t\t " + z.getAge());
        System.out.println("First Name:\t\t " + z.getFName());
        System.out.println("last Name:\t\t " + z.getLName());
        System.out.println("-----------------------------------");
    }
}
