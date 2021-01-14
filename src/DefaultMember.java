public class DefaultMember {

    private Integer membershipNumber;
    private String name;
    private String startMembershipDate;

    public DefaultMember(Integer membershipNumber, String name, String startMembershipDate, int day, int month, int year){
        super();
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.startMembershipDate = startMembershipDate;
    }


    public Integer getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(Integer membershipNumber) {
        this.membershipNumber = membershipNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate){
        this.startMembershipDate = startMembershipDate;
    }
}
