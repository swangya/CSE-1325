import java.util.Scanner;

public class Main extends itm{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        functions s = new functions();
        int choice;
        boolean cont=true;


        while(cont){
            System.out.println("\t1.\tList items in Cart");
            System.out.println("\t2.\tAdd items to Cart");
            System.out.println("\t3.\tCheckout");
            System.out.println("\t4.\tExit");
            do{
                try {                                       //Checking for potential input error
                    System.out.print("Enter your Choice: ");
                    choice = keyboard.nextInt();
                    break;

                } catch (Exception e) {
                    System.out.println("Enter a valid choice");
                    keyboard.next();
                }
            }while(true);

            switch (choice) {
                case 1:
                    s.listCart();
                    break;
                case 2:
                    s.addItem();
                    break;
                case 3:
                    s.checkout();
                    break;
                case 4:
                    cont = false;
                    break;
                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
            System.out.println("\n\n");
        }
    }
}
