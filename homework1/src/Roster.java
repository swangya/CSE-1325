public class Roster {

    public static void sortId(Student[] s){
        Student temp;
        int comp1, comp2;
        for(int i=0; i<4;i++){
            for (int j = i; j > 0; j--) {

                comp1=s[j].getId();
                comp2=s[j-1].getId();
                if (comp1<comp2) {
                    temp = s[j];
                    s[j] = s[j - 1];
                    s[j - 1] = temp;
                }
            }
        }
    }

    public static void sortAge(Student[] s){
        Student temp;
        int comp1, comp2;
        for(int i=0; i<4;i++){
            for (int j = i; j > 0; j--) {

                comp1=s[j].getAge();
                comp2=s[j-1].getAge();
                if (comp1<comp2) {
                    temp = s[j];
                    s[j] = s[j - 1];
                    s[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student[] s = new Student[4];
        for(int i=0; i<4; i++){
            s[i]=new Student();
        }

        //initialising Student Data
        s[0].setFName("Bob");
        s[0].setLName("Smith");
        s[0].setId();
        s[0].setAge(27);

        s[1].setFName("John");
        s[1].setLName("Doe");
        s[1].setId();
        s[1].setAge(19);

        s[2].setFName("Jane");
        s[2].setLName("Doe");
        s[2].setId();
        s[2].setAge(23);

        s[3].setFName("Max");
        s[3].setLName("Brown");
        s[3].setId();
        s[3].setAge(40);

        System.out.println("Roster: sorted according to the student Id");
        sortId(s);
        for(int i=0; i<4; i++){
            System.out.println("Student: " + (i+1));
            s[i].print((i+1));
        }

        System.out.println();
        System.out.println();

        System.out.println("Roster: sorted according to the student Age");
        sortAge(s);
        for(int i=0; i<4; i++){
            System.out.println("Student: " + (i+1));
            s[i].print((i+1));
        }
    }
}
