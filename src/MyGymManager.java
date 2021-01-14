import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyGymManager implements GymManager {

    private final List<DefaultMember> memberList = new ArrayList<DefaultMember>();


    @Override
    //Insert
    public void addMember(DefaultMember member) {

        if (memberList.size() < 100) {
            memberList.add(member);
            System.out.println("Number of used slots: " + memberList.size()); //Slots
            System.out.println("Number of free slots: " + (100 - memberList.size()));
        } else {
            System.out.println("There is no free slots");
        }


    }

    @Override
    //Delete
    public boolean deleteMember(Integer membershipNumber) {
        boolean flag = false;
        for (DefaultMember member : memberList) {
            if (member.getMembershipNumber().equals(membershipNumber)) {
                flag = true;
                memberList.remove(member);
                System.out.println("Member belongs to M -  " + membershipNumber + " has been removed");
                System.out.println("Number of used slots: " + memberList.size()); //Slots
                System.out.println("Number of free slots: " + (100 - memberList.size()));
                if (member instanceof StudentMember) {
                    System.out.println("Member type is StudentMember\n");
                } else if (member instanceof Over60Member) {
                    System.out.println("Member type is Over60Member\n");
                } else {
                    System.out.println("Member type is DefaultMember\n");
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("Can not found");
        }
        return flag;
    }

    @Override
    //Print
    public void print() {
        for (DefaultMember member : memberList) {
            System.out.println("Membership No: " + member.getMembershipNumber() + " ");
            System.out.println("Name is " + member.getName() + " ");
            System.out.println("Membership start date is: " + member.getStartMembershipDate());

            if (member instanceof StudentMember) {
                System.out.println("Type of Membership is StudentMember");
                System.out.println("School name is: " + ((StudentMember) member).getSchoolName());
                break;
            } else if (member instanceof Over60Member) {
                System.out.println("Type of Membership is Over60Member");
                System.out.println("Your age is: " + ((Over60Member) member).getAge());
                break;
            } else {
                System.out.println("Type of Membership is DefaultMember\n");
            }
        }
        if (memberList.size() == 0) {
            System.out.println("Nothing to print\n");
        }

    }

    @Override
    //Sorting
    public void sort() { }

    @Override
    //Saving
    public void save() {
        DefaultMember[] arr = memberList.toArray(new DefaultMember[]{});
        File file = new File("MemberList.txt"); //Creating a text file to store
        BufferedWriter fileOut;


            try (FileWriter fw = new FileWriter(file)) {

                fileOut = new BufferedWriter (fw);
                for (int i = 0; i < memberList.size(); i++) {
                    fileOut.write( "#Membership Number: " + memberList.get(i).getMembershipNumber()
                            +" #Name: " + memberList.get(i).getName() + " #Start Date: "
                            + memberList.get(i).getStartMembershipDate());

                    System.out.println("<===saved successfully===>");
                    fileOut.flush();
                    fileOut.newLine();
                }

            } catch (Exception e) {
                System.out.println("Nothing to save");
            }
        }

    @Override
    public void Search() {

    }

    @Override
        public List<DefaultMember> getMemberList () {
            return null;
        }

        @Override
        public DefaultMember getMemberbyMembershipNumber (String membershipNumber){
            return null;
        }

        @Override
        public DefaultMember[] getmemberbyName (String name){
            return new DefaultMember[0];
        }



    }
