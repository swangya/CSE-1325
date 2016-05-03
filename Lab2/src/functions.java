import java.util.*;
public class functions {

    items s = new items();
    ArrayList<Integer> a = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);


     void displayMenu(){                                        //To display the menu
        System.out.println("-----------------------------");
        System.out.println("\tItem\t\t\t   Price");
        System.out.println("-----------------------------");
        s.printItem(1);
        s.printItem(2);
        s.printItem(3);
        s.printItem(4);
        s.printItem(5);
        System.out.println("-----------------------------");
    }

    void additem(){                                            //Adds Items to cart
        displayMenu();
        int val;
        char cont='y';
        while(cont=='y'||cont=='Y'){
            while(true) {
                do {
                    try {                                     //Checking for potential input error
                        System.out.print("Enter the item number to add to cart: ");
                        val = keyboard.nextInt();
                        break;

                    } catch (Exception e) {
                        System.out.println("Enter a valid choice");
                        keyboard.next();
                    }
                } while (true);
                if (val > 5) {
                    System.out.println("Enter a valid choice");
                } else {
                    break;
                }
            }

            a.add(val);
            System.out.println("Item number "+ val + " added.");
            while (true) {
                System.out.print("Do You want to enter more? (Y/N)");
                cont = keyboard.next().trim().charAt(0);
                if(cont=='Y'||cont=='y'||cont=='n'||cont=='N'){
                    break;
                }
                else{
                    System.out.println("The input is invalid.");
                }
            }

        }
    }

    void listCart(){                                    //Lists items in cart
        double total;
        System.out.println("\n\n-----------------------------");
        System.out.println("\t\t\t CART");
        System.out.println("-----------------------------");
        System.out.println("\tItem\t\t\t   Price");
        System.out.println("-----------------------------");
        for (Integer anA : a) {
            s.printItem(anA);
        }
        total=getTotal();
        System.out.println("-----------------------------");
        System.out.println("Total \t\t\t\t\t" + total);
        System.out.println("-----------------------------");
    }

    double getTotal(){                                  //Returns total of the price of items in cart
        double total=0;
        double temp;
        for (Integer anA : a) {
            temp=s.getPrice(anA);
            total = total+temp;
        }
        return(total);
    }

    void checkout(){                                    //Final Checkout
        listCart();
        double pay;
        double change;
        double total;
        total=getTotal();
        while(true){
            do{
                try {                                   //Checking for potential input error
                    System.out.print("Enter the amount you want to pay: ");
                    pay = keyboard.nextDouble();
                    break;

                } catch (Exception e) {
                    System.out.println("Enter a valid choice");
                    keyboard.next();
                }
            }while(true);

            if(pay<total){
                System.out.println("payment rejected! enter a valid amount.");
            }
            else{
                break;
            }
        }
        change=pay-total;

        System.out.println("You Paid: "+ pay);
        System.out.println("Your Change: "+ change);
        a.clear();                                      //Clears Array List

    }
}