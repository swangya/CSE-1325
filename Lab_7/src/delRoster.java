import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class delRoster implements command2{
    transient Scanner read = new Scanner(System.in);

    HashMap<Integer, Roster> rosLst= new HashMap<>();
    HashMap<Integer, Roster> templst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int nument;
    int delId;

    Roster temp;

    delRoster(HashMap<Integer, Roster> a){
        rosLst=a;
        templst=a;
    }
    void set_idchk(List<Integer> a){
        idchk = a;
    }

    List<Integer> get_idchk(){
        return idchk;
    }

    @Override
    public HashMap<Integer, Roster> execute(){
        Roster x;
        int i;
        System.out.print("Enter the Id of the Roster: ");
        delId=read.nextInt();
        if(rosLst.containsKey(delId)){
            temp=rosLst.get(delId);
            System.out.println("Roster Found\n");
            rosLst.remove(delId);
        }
        return rosLst;
    }

    @Override
    public HashMap<Integer, Roster> undo(){
        rosLst.put(delId, temp);
        return rosLst;
    }

    @Override
    public HashMap<Integer, Roster> redo(){
        rosLst.remove(delId);
        return rosLst;
    }
}