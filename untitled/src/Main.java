import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
    public static void validatePassword(String str)
    {
        int fl=0,lower = 0, upper =0;
        String rs = "Password must have ";
        if(str.length()<8)
        {
            System.out.println("Password must be atleast eight characters.");
            fl = 1;

        }
        if( (str.indexOf('!')==-1) && (str.indexOf('@')==-1) &&
                (str.indexOf('#')==-1) && (str.indexOf('%')==-1) &&
                (str.indexOf('^')==-1) && (str.indexOf('&')==-1) &&
                (str.indexOf('*')==-1) && (str.indexOf('-')==-1) && (str.indexOf('_')==-1))
        {
            System.out.println("Password does not have special character");
            fl = 1;
        }
        if((str.indexOf('0')==-1) && (str.indexOf('1')==-1) &&
                (str.indexOf('2')==-1) && (str.indexOf('3')==-1) &&
                (str.indexOf('4')==-1) && (str.indexOf('5')==-1) &&
                (str.indexOf('6')==-1) && (str.indexOf('7')==-1) &&
                (str.indexOf('8')==-1) && (str.indexOf('9')==-1))
        {
            System.out.println("Password does not contain a digit");
        }
        for (int i=0;i<str.length();i++)
        {
            if(Character.isLowerCase(str.charAt(i)))
                lower = 1;
            if(Character.isUpperCase(str.charAt(i)))
                upper = 1;
        }
        if(lower == 0)
        {
            System.out.println("Password does not contain lower case");
            fl =1;
        }
        if(upper == 0)
        {
            System.out.println("Password does not contain upper case");
            fl =1;
        }
        if(fl == 0)
        {
            System.out.println("Password not verified");
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Please enter a password");
        Scanner sc = new Scanner(System.in);
        String pwd1 = sc.nextLine();
        System.out.println("Please enter the password again");
        String pwd2 = sc.nextLine();
        if(!pwd1.equals(pwd2))
        {
            System.out.println("Passwords do not match.");
            System.out.println("Password not verified");
        }
        else
            validatePassword(pwd1);
    }
}