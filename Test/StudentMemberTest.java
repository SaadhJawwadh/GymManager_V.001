import org.junit.Test;

import static org.junit.Assert.*;

public class StudentMemberTest {

    @Test
    public void getName() {
        StudentMember test = new StudentMember( 1,"Saadh","12-3-2020",12,3,2020,"Zahira");
        assertEquals("Saadh", test.getName());
    }

    @Test
    public void getStartMembershipDate() {
        StudentMember test = new StudentMember( 1,"Saadh","12-3-2020",12,3,2020,"Zahira");
        assertEquals("12-3-2020", test.getStartMembershipDate());
    }

    @Test
    public void getSchoolName() {
        StudentMember test = new StudentMember( 1,"Saadh","12-3-2020",12,3,2020,"Zahira");
        assertEquals("Zahira", test.getSchoolName());
    }

}