package test;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import java.io.IOException;

/**
 * Created by Tongtong Zhao on 11/05/2016.
 * M5_V2
 */

public class addTest {

    private Reports reports;

    /**
     * set up test
     */
    @Before
    public void setUp() {
        reports = new Reports();
    }

    /*
    /**
     * test for existed user

    @Test
    public void testExistReport() {
        try {
            Report temp = new Report("robert", "robert12016_10_21_23_30_0", "47.6397,-122.3031");
            Assert.assertEquals("should not add duplicate", false, reports.add(temp));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }*/

    /**
     * test for not existed user
     */
    @Test
    public void testNewReport() {
        try {
            Report temp = new Report("robert", "robertTest", "47, -120");
            Assert.assertEquals("method should add Successfully", true, reports.add(temp));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for emprty report string as input
     */
    @Test
    public void testEmptyReport() {
        try {
            Report temp = new Report("", "", "");
            Assert.assertEquals("should not add this report", false, reports.add(temp));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test null input
     */
    @Test
    public void testNull() {
        try {
            Assert.assertEquals("should not add the report", false, reports.add(null));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

}
