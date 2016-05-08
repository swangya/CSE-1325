import java.io.Serializable;
import java.util.*;

public class modEntry implements Command, java.io.Serializable {
    transient Scanner read = new Scanner(System.in);

    HashMap<Integer, Human> lst= new HashMap<>();
    HashMap<Integer, Human> templst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int modId;
    int ch=0;
    modEntry(HashMap<Integer, Human> a){
        lst=a;
    }
    int nument;

    void putid(int a){
        modId=a;
    }

    Human temp=new Human();

    void setTemp(Human a){
        temp.id = a.id;
        temp.Age = a.Age;
        temp.FName = a.FName;
        temp.LName = a.LName;
    }

    void set_idchk(List<Integer> a){
        idchk = a;
    }

    List<Integer> get_idchk(){
        return idchk;
    }
    Human z = new Human();

    @Override
    public HashMap<Integer, Human> execute() {

        int a;
        int choice;
        System.out.print("Enter Id to be modified");
        a=read.nextInt();
        if(lst.containsKey(a)){
            putid(a);
            System.out.println("\nEntry Found! \n");
            z=lst.get(modId);
            setTemp(z);
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
                        lst.remove(modId);
                        z.setId(nument);
                        lst.put(nument, z);
                        System.out.println("Roster Modified\n");
                        ch =1;
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
        return lst;
    }

    @Override
    public HashMap<Integer, Human> undo(){
        if (ch==1){
            System.out.println(modId+ "  " + nument);
            lst.remove(nument);
            lst.put(modId, temp);
        }
        else{
            lst.remove(modId);
            lst.put(modId, z);
        }
        return lst;
    }

    @Override
    public HashMap<Integer, Human> redo(){
        if (ch==1){
            lst.remove(modId);
            lst.put(nument, z);
        }
        else{
            lst.remove(modId);
            lst.put(modId, z);
        }
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
