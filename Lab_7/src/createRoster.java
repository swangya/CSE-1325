import java.util.*;

public class createRoster implements command2 {

    Scanner read = new Scanner(System.in);

    HashMap<Integer, Roster> rosLst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int nument;



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

    @Override
    public HashMap<Integer, Roster> execute(){
        String r;
        int y;
        Roster x = new Roster();
        System.out.print("Enter the Id for roster: ");
        y = read.nextInt();
        setNum(y);
        if(idchk.contains(nument)){
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
        return rosLst;
    }
    public HashMap<Integer, Roster> undo(){
        rosLst.remove(nument);
        return rosLst;
    }

}
