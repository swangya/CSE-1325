import java.util.Map;

/**
 * Created by Swangya on 5/4/2016.
 */
public interface Command {
    Map<Integer, Human> execute();
    Map<Integer, Human> undo();
    Map<Integer, Human> redo();
}
