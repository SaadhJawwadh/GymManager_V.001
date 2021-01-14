import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultMemberTest {


    @Test
    public void getName() {
        DefaultMember test = new DefaultMember(1,"Saadh","12-3-2020",12,3,2020);
        assertEquals("Saadh", test.getName());
    }


    @Test
    public void getStartMembershipDate() {
        DefaultMember test = new DefaultMember(1,"Saadh","12-3-2020",12,3,2020);
        assertEquals("12-3-2020", test.getStartMembershipDate());
    }

}