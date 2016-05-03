public class items {
    double iceCream;
    double burger;
    double hotDog;
    double fries;
    double cakeSlice;

    items(){
        iceCream    = 1.25;
        burger      = 3.50;
        hotDog      = 4.00;
        fries       = 2.50;
        cakeSlice   = 6.75;
    }

    public double getPrice(int a){
        switch (a){
            case 1:
                return(iceCream);

            case 2:
                return(burger);

            case 3:
                return(hotDog);

            case 4:
                return(fries);

            case 5:
                return(cakeSlice);

        }
        return (0);
    }


    public void printItem(int a){
        switch (a){
            case 1:
                System.out.println("1. Ice-Cream \t\t\t" + iceCream);
                break;
            case 2:
                System.out.println("2. Burger \t\t\t\t" + burger);
                break;
            case 3:
                System.out.println("3. Hot Dog \t\t\t\t" + hotDog);
                break;
            case 4:
                System.out.println("4. Fries \t\t\t\t" + fries);
                break;
            case 5:
                System.out.println("5. Cake Slice \t\t\t" + cakeSlice);
                break;
        }
    }
}
