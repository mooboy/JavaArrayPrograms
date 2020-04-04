public class Student extends Person {
    public int rollNo;

    public Student (String name, String phoneNo, String address, int rollNo) {
        super(name, phoneNo, address);
        this.rollNo = rollNo;
    }

    public String toString()
    {
        return super.toString() + ", " + this.rollNo;
    }
}
