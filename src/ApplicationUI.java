import java.util.Scanner;

public class ApplicationUI {

    private static MyGymManager manager = new MyGymManager();
    private static int count = 0 ;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("1 for insert member");
        System.out.println("2 for delete member");
        System.out.println("3 for print list of members");
        System.out.println("4 for sort members");
        System.out.println("5 for save members");

        int choice = input.nextInt();

        switch (choice){
            case 1:
                insertMember();
                break;
            case 2:
                deleteMember();
                break;
            case 3:
                manager.print();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private static void deleteMember(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter membership number: ");
        String membershipNumber = input.next();
        boolean result = manager.deleteMember(membershipNumber);
        if (result){
            count--;
        }
    }

    private static void insertMember() {
        Scanner input = new Scanner(System.in);
        if (count < 100) {
            System.out.println("Enter membership number: ");
            String membershipNumber = input.next();
            System.out.println("Enter the name: ");
            String name = input.next();
            System.out.println("Enter the date in the following format DD/MM/YYYY: ");
            String membershipStartDate = input.next();
            System.out.println("Enter your phone number: ");
            String phoneNumber = input.next();
            System.out.println("Enter your address: ");
            String address = input.next();
            System.out.println("Enter the type of membership (D-Default member S-Student member O-Over60 member)");
            String type = input.next();
            DefaultMember member = null;

            switch (type){
                case "D":
                case "d":
                    member = new DefaultMember(membershipNumber,name,membershipStartDate,phoneNumber);
                    break;
                case "S":
                case "s":
                    System.out.println("School Name: ");
                    String schoolName = input.next();
                    member = new StudentMember(membershipNumber,name,membershipStartDate,schoolName,phoneNumber,address);
                    break;
                case "O":
                case "o":
                    System.out.println("Age: ");
                    int age = input.nextInt();
                    member = new Over60Member(membershipNumber,name,membershipStartDate,phoneNumber,age);
                    break;
                default:
                    System.out.println("Invalid input");
            }
            manager.addMember(member);
            count++;
        }else {
            System.out.println("no free space! membership has achieved the maximum level");
        }
    }
}
