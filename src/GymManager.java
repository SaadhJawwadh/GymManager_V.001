import java.util.List;

public interface GymManager {
    public void addMember(DefaultMember member);
    public boolean deleteMember(Integer membershipNumber);
    public void print();
    public void sort();
    public void save();
    public void Search();
    public List<DefaultMember> getMemberList();
    public DefaultMember getMemberbyMembershipNumber(String membershipNumber);
    public DefaultMember[] getmemberbyName(String name);
}
