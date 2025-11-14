class Student {
    private int stuCount = 12;
    public void go() {
        stuCount++;
        System.out.println(stuCount);
    }
}
public class Main{
    public static void main(String[]
                                    args) {
        Student s1=new Student();
        Student s2=new Student();
        s1.go();
        s2.go();
    }
}