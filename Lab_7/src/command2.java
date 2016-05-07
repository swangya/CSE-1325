import java.util.HashMap;
import java.util.Map;

public interface command2 {

    HashMap<Integer, Roster> execute();
    HashMap<Integer, Roster> undo();

}
