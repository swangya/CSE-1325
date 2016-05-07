import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Swangya on 5/7/2016.
 */
public class copyRoster implements command2{
    Scanner read = new Scanner(System.in);

    HashMap<Integer, Roster> rosLst= new HashMap<>();
    HashMap<Integer, Roster> templst= new HashMap<>();
    List<Integer> idchk= new ArrayList<>();
    int oldId;
    int newId;

    Roster Temp = new Roster();

    copyRoster(HashMap<Integer, Roster> a){
        rosLst=a;
    }
    void set_idchk(List<Integer> a){
        idchk = a;
    }

    List<Integer> get_idchk(){
        return idchk;
    }
    void setTemp(Roster a){
        Temp.lst=a.lst;
        Temp.idchk=a.idchk;
    }

    @Override
    public HashMap<Integer, Roster> execute(){
        Roster x;
        Roster y= new Roster();
        String nam;
        int ident;
        System.out.print("Enter the Roster Id to copy: ");
        ident=read.nextInt();
        if(rosLst.containsKey(ident)){
            x=rosLst.get(ident);
            setTemp(x);
            oldId=ident;
            y.lst=x.lst;
            y.idchk=x.idchk;
            System.out.println("Roster found Initiating Copy.");
            System.out.print("Enter Name for Roster: ");
            nam=read.next();
            y.setRosName(nam);
            newId=ident;
            while(true){
                System.out.println(newId);
                newId=newId*2;
                if(!idchk.contains(newId)){
                    break;
                }
            }
            y.setRosterId(newId);
            idchk.add(newId);
            rosLst.put(newId, y);
            System.out.println("Roster Has been copied.");
        }
        return rosLst;
    }
    @Override
    public HashMap<Integer, Roster> undo(){
        rosLst.remove(newId);
        return rosLst;
    }

}
