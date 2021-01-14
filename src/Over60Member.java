public class Over60Member extends DefaultMember {

    private int age;

    public Over60Member(Integer membershipNumber, String name, String startMembershipDate, int day, int month, int year, int age) {
        super(membershipNumber, name, startMembershipDate, day, month, year);
        this.age = age;
        setAge(this.age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }
    }
