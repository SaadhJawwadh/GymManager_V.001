public class StudentMember extends DefaultMember{

    private String schoolName;

    public StudentMember(Integer membershipNumber, String name, String startMembershipDate, int day, int month, int year, String schoolName) {
        super(membershipNumber, name, startMembershipDate, day, month, year);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
}
