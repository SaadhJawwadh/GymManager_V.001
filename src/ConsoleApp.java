import javafx.application.Application;
import java.util.Scanner;

Name: Saadh Jawwadh
Student Id: 2019175
UoW ID


public class ConsoleApp {

    private static MyGymManager manager = new MyGymManager();
    private static int count = 0 ;

    public static void main(String[] args) {

        System.out.println("<=== Welcome to the Gym Membership Manager by Saadh Jawwadh ===>");


             Scanner input = new Scanner(System.in);


                int count;
                choiceLoop:
                for (count = 0; count <= 100; count++) { //Maximum members is 100

                    //Choices
                    System.out.println("<===Choose one action===>");
                    System.out.println(" 1: Insert a new member");
                    System.out.println(" 2: Delete a member");
                    System.out.println(" 3: Print the members list");
                    System.out.println(" 4: Search a member");
                    System.out.println(" 5: Save the changes");
                    System.out.println(" 6: Sort the members");
                    System.out.println(" 0: Reset the Programme");
                    System.out.print("============================\n Enter your choice here: ");
                    int choice = input.nextInt();

                    System.out.println("============================");

                    switch (choice) {
                        case 4:
                            System.out.println("Search GUI is Running..."); // Will run search UI
                            Application.launch(GUI.class, args);
                            break ;

                        case 1:
                            System.out.println("<==New member details==>"); //Add New member
                            insertMember();
                            break;
                        case 2:
                            System.out.println("<===Delete Menu==>"); //Delete
                            deleteMember();
                            break;
                        case 3:
                            System.out.println("<===Printed List===>"); //Print
                            manager.print();
                            break;
                        case 6:
                            System.out.println(" Not yet implemented");
                            System.out.println("============================");
                            manager.sort(); //Not yet implemented
                            break;
                        case 5:
                            manager.save(); //Save
                            break;

                        case 0:
                            System.out.println("Programme has been reset!\n" +
                                    "Please Re run the programme");
                            System.out.println("============================");
                            System.exit(0);
                        default:
                            System.out.println("Please Enter a Valid Choice"); //Validation
                            System.out.println("============================");
                    }
                }
        }


    private static void deleteMember(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter membership number: ");
        Integer membershipNumber = input.nextInt();
        boolean result = manager.deleteMember(membershipNumber);
        if (result){
            count--;
        }
    }

    //Insert
    private static void insertMember() {

        Scanner input = new Scanner(System.in);

        if (count < 100) {

            //String membershipNumber = input.next();
            Integer membershipNumber = count+1;
            System.out.println("Member Number is No -> "+membershipNumber); // auto generated member number
            System.out.print("Enter the name: ");
            String name = input.next();
            //Validation
            while(!name.matches("[a-zA-Z]+")){
                System.out.println("Please enter a valid name!");
                System.out.print("Enter the name:  ");
                name = input.next();
            }

            System.out.print("Enrollment Day: ");
            int day = input.nextInt();
            //Validation
                while (!(day > 0 && day < 31)) {
                    System.out.println("Please enter a valid day!");
                    System.out.print("Enrollment Day:  ");
                    day = input.nextInt();
                }

            System.out.print("Enrollment Month: ");
            int month = input.nextInt();
            //Validation
            while(!(month > 0 && month <13)){
                System.out.println("Please enter a valid Month!");
                System.out.print("Enrollment Month:  ");
                month = input.nextInt();
            }

            System.out.print("Enrollment Year: ");
            int year = input.nextInt();
            //Validation
            while(!(year > 1900)){
                System.out.println("Please enter a valid Year [2xxx]!");
                System.out.print("Enrollment Year:  ");
                year = input.nextInt();
            }
            String membershipStartDate = day +"-" + month+"-" + year;


            System.out.print("Enter the Mtype of membership \n" +
                    "(D:Default member S:Student member O: Over 60 member): ");
            String Mtype = input.next();
            //validation
            while(!(Mtype.equals("d") || Mtype.equals("D") || Mtype.equals("s") || Mtype.equals("S") || Mtype.equals("o") || Mtype.equals("O"))){
                System.out.println("Please enter a valid Type!");

                System.out.print("Enter the Mtype of membership \n" +
                        "(D:Default member S:Student member O: Over 60 member): ");
                Mtype = input.next();
            }

            DefaultMember member = null;

            switch (Mtype) {

                case "D":
                case "d":
                    member = new DefaultMember(membershipNumber, name, membershipStartDate,day,month,year);
                    break;
                case "S":
                case "s":
                    String schoolName = null;
                    System.out.print("Enter your School Name: ");
                    schoolName = input.next();
                    //Validation
                    while(!schoolName.matches("[a-zA-Z]+")){
                        System.out.println("Please enter a valid School name!");
                        System.out.print("Enter your School Name: ");
                        schoolName = input.next();
                    }
                    member = new StudentMember(membershipNumber, name, membershipStartDate, day,month,year, schoolName);
                    break;

                case "O":
                case "o":
                    System.out.print("Enter your Age(60+): ");
                    int age = input.nextInt();
                    //Validation
                    while(!(age > 60)){
                        System.out.println("Please enter a valid Age (60+)!");
                        System.out.print("Enter your Age(60+): ");
                        age = input.nextInt();
                    }
                    member = new Over60Member(membershipNumber, name, membershipStartDate,day,month,year,age);
                    break;

                default:
                    System.out.println("Invalid input");
            }
            manager.addMember(member);
            count++;

        }else {
            System.out.println("Maximum Slot limit has been reached! \n" +
                    "You can still add a member by Delete another (*_*)");
            System.out.println("====================================");
        }
    }
}

