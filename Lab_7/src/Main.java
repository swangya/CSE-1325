import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Main implements java.io.Serializable {

    public static void main(String[] args) {
        rosterOp ros = new rosterOp();
        int choice;

        boolean cont= true;

        while (cont) {
            choice = ros.printOptions();

            switch (choice){
                case 1:
                    ros.createRoster(1);
                    break;
                case 2:
                    ros.modRoster();
                    break;
                case 3:
                    ros.delRoster(1);
                    break;
                case 4:
                    ros.printRoster();
                    break;
                case 5:
                    ros.printAll();
                    break;
                case 6:
                    ros.sortRoster();
                    break;
                case 7:
                    ros.sortAll();
                    break;
                case 8:
                    ros.copyRoster(1);
                    break;
                case 9:
                    ros.serializeARoster();
                    break;
                case 10:
                    ros.serializeallrosters();
                    break;
                case 11:
                    ros.undo();
                    break;
                case 12:
                    cont=false;
                    break;
            }

        }


    }
}
