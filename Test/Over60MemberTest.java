import org.junit.Test;

import static org.junit.Assert.*;

public class Over60MemberTest {

    @Test
    public void getName() {
        Over60Member test = new Over60Member( 1,"Saadh","12-3-2020",12,3,2020,72);
        assertEquals("Saadh", test.getName());
    }

    @Test
    public void getStartMembershipDate() {
        Over60Member test = new Over60Member( 1,"Saadh","12-3-2020",12,3,2020,72);
        assertEquals("12-3-2020", test.getStartMembershipDate());
    }

    @Test
    public void getAge() {
        Over60Member test = new Over60Member( 1,"Saadh","12-3-2020",12,3,2020,72);
        assertEquals(72, test.getAge());
    }

}