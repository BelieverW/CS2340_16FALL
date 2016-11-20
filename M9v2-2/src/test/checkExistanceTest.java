package test;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Linhan Li on 7/15/2016.
 * M5_V2
 */
public class checkExistanceTest {

    private Database database;

    /**
     * set up test
     * @throws IOException exception in database
     */
    @Before
    public void setUp() throws IOException {
        database = new Database();
    }

    /**
     * test for existed user
     */
    @Test
    public void testExistUser() {
        try {
            Assert.assertEquals("cannot find user, wrong", true, database.checkExistance("helloliao"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for not existed user
     */
    @Test
    public void testNotExistUser() {
        try {
            Assert.assertEquals("method should not find a user here", false, database.checkExistance("haaaa"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for emprty user string as input
     */
    @Test
    public void testEmptyUser() {
        try {
            Assert.assertEquals("should not find this user", false, database.checkExistance(""));
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
            Assert.assertEquals("should not find null user", false, database.checkExistance(null));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test the first user in id list
     */
    @Test
    public void testFirstUser() {
        try {
            Assert.assertEquals("should find the first user", true, database.checkExistance("linhanli"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test the last user in id list
     */
    @Test
    public void testLastUser() {
        try {
            Assert.assertEquals("should find the last user", true, database.checkExistance("robert"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test upper case condition
     */
    @Test
    public void testCase() {
        try {
            Assert.assertEquals("should not find this user", false, database.checkExistance("ROBERT"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

}
