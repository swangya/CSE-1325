import java.util.*;

public class createRoster implements command2 {

    transient Scanner read = new Scanner(System.in);

    HashMap<Integer, Roster> rosLst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int nument;
    int id;

    void getId(int a){
        id = a;
    }

    void setRos(HashMap<Integer, Roster> a){
        rosLst=a;
    }

    void setNum(int a){
        nument=a;
    }
    void set_idchk(List<Integer> a){
        idchk = a;
    }

    List<Integer> get_idchk(){
        return idchk;
    }

    Roster x = new Roster();

    @Override
    public HashMap<Integer, Roster> execute(){
        x.clear();
        x.printRoster();
        String r;
        System.out.print("Enter the Name for roster: ");
        r = read.next();
        x.setRosterId(nument);
        x.setRosName(r);
        rosLst.put(nument, x);
        idchk.add(nument);
        System.out.println("The Roster has been Created.\n");
        return rosLst;
    }

    @Override
    public HashMap<Integer, Roster> undo(){
        rosLst.remove(nument);
        return rosLst;
    }

    @Override
    public HashMap<Integer, Roster> redo(){
        rosLst.put(nument, x);
        idchk.add(nument);
        return rosLst;
    }

}
