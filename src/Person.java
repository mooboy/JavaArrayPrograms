public class Person {
    String name;
    String phoneNo;
    String address;

    public Person(String name, String phoneNo, String address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public Boolean getName(String name) {

        if (name.equalsIgnoreCase("keerthy") || name.equalsIgnoreCase("sid")) {
            return true;
        }

        return false;
    }

    public String toString()
    {
        return this.phoneNo + ", " + this.address;
    }
}