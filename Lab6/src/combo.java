public class combo extends items{
    double burF = burger+fries;
    double hotF = hotDog+fries;

    public double getPrice(int a){          //A function to return price
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
            case 6:
                return (burF);
            case 7:
                return (hotF);
        }
        return (0);
    }

    public void printItem(int a){                                   //A function to print items
        switch (a){
            case 1:
                System.out.println("1. Ice-Cream \t\t\t\t" + iceCream);
                break;
            case 2:
                System.out.println("2. Burger \t\t\t\t\t" + burger);
                break;
            case 3:
                System.out.println("3. Hot Dog \t\t\t\t\t" + hotDog);
                break;
            case 4:
                System.out.println("4. Fries \t\t\t\t\t" + fries);
                break;
            case 5:
                System.out.println("5. Cake Slice \t\t\t\t" + cakeSlice);
                break;
            case 6:
                System.out.println("6. Burger Fries Combo \t\t" + burF);
                break;
            case 7:
                System.out.println("7. Hot Dog Fries Combo \t\t" + hotF);
                break;
        }
    }
}
