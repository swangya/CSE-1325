import java.util.*;

public class addEntry implements Command {
    Scanner read = new Scanner(System.in);

    HashMap<Integer, Human> lst= new HashMap<>();
    HashMap<Integer, Human> templst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int a;
    Human x = new Human();

    addEntry(HashMap<Integer, Human> a){
        lst=a;
        templst=a;
    }
    int nument;

    void seta(int num){
        a=num;
    }

    void set_idchk(List<Integer> a){
        idchk = a;
    }

    List<Integer> get_idchk(){
        return idchk;
    }

    @Override
    public HashMap<Integer, Human> execute() {
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

        return lst;
    }

    @Override
    public HashMap<Integer, Human> undo(){
        System.out.println("Last action undone");
        lst.remove(a);
        return lst;
    }

    @Override
    public HashMap<Integer, Human> redo(){
        lst.put(a, x);
        return lst;
    }
}
