//package com.google.challenges;

public class one {
    int a[]= new int[3];
    String ans=null;

    one(){
        a[0]=0;
        a[1]=0;
        a[2]=0;

    }

    public String getFormat(){
        if(a[0]<10 && a[1]<10 && a[2]<10){
            ans = String.format("0%d/0%d/0%d", a[0], a[1], a[2]);
        }
        else if(a[0]<10 && a[1]<10 && a[2]>10){
            ans = String.format("0%d/0%d/%d", a[0], a[1], a[2]);
        }
        else if(a[0]<10 && a[1]>10 && a[2]>10){
            ans = String.format("0%d/%d/%d", a[0], a[1], a[2]);
        }
        return (ans);
    }


    public  void sort(){

        int temp;
        for (int i = 1; i < a.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(a[j] < a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public String allDiff() {
        if (a[0] == 1 || a[0] == 3 || a[0] == 5 || a[0] == 7 || a[0] == 8 || a[0] == 10 || a[0] == 12) {
            if (a[0]<13 && a[1] < 32 && a[2] > 31) {
                ans = String.format("%d/%d/%d", a[0], a[1], a[2]);
                return (ans);
            }
            else{
                return ("Ambiguous");
            }
        }
        else{
            if (a[0] < 13 && a[1]>12 && a[1] < 31 && a[2] > 30) {
                ans = String.format("%d/%d/%d", a[0], a[1], a[2]);
                return (ans);
            }
            else{
                return ("Ambiguous");
            }

        }
    }

    public String monSame(){
        if (a[0] == 1 || a[0] == 3 || a[0] == 5 || a[0] == 7 || a[0] == 8 || a[0] == 10 || a[0] == 12){
            if (a[2]>31){
                ans = getFormat();
                return (ans);
            }
            else{
                return ("Ambiguous");
            }

        }
        else{
            if (a[0]<13 && a[2]>30){
                ans = getFormat();
                return (ans);
            }
            else{
                return ("Ambiguous");
            }
        }
    }

    public String yearSame(){
        if (a[0] == 1 || a[0] == 3 || a[0] == 5 || a[0] == 7 || a[0] == 8 || a[0] == 10 || a[0] == 12){
            if(a[2]<31){
                ans = getFormat();
                return (ans);
            }
            else{
                return ("Ambiguous");
            }
        }
        else{
            if (a[0]<13 && a[2]<30){
                ans = getFormat();
                return (ans);
            }
            else{
                return ("Ambiguous");
            }
        }
    }

    public String allSame(){
        if(a[0]<13){
            ans = getFormat();
            return (ans);
        }
        else{
            return ("Ambiguous");
        }

    }

    public String answer(int x, int y, int z) {
        String fin = "";

        a[0]= x;
        a[1]= y;
        a[2]= z;

        sort();

        if(x!=y && x!=z && y!=z){
            fin=allDiff();
        }

        if(a[0]==a[1]){
            fin=monSame();
        }

        if(a[1]==a[2]){
            fin=yearSame();
        }

        if(a[0]==a[1] && a[1]==a[2]){
            fin=allSame();
        }

        return (fin);



    }
}