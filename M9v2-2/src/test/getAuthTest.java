package test;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zicheng Liu on 11/08/2016.
 * M5_V2
 */

public class getAuthTest {

    private Database database;
    private User uuser;
    private User uworker;
    private User umanager;
    private User uadmin;

    /**
     * set up test
     * @throws IOException exception in database
     */
    @Before
    public void setUp() throws IOException {
        database = new Database();
        uuser = new User("zichengliu", "456789", UserLevel.USER, "none@mail.com");
        uworker = new User("linhanli", "234567", UserLevel.WORKER, "none@mail.com");
        umanager = new User("hwang630", "123456", UserLevel.MANAGER, "test@mail.com");
        uadmin = new User("bobwaters", "678912", UserLevel.ADMIN, "gh@gmaiii.com");
    }

    /**
     * test for existed user
     */
    @Test
    public void testExistUser() {
        try {
            Assert.assertEquals("Userlevel is not correct.", UserLevel.USER, database.getAuth("zichengliu", "456789").getUserLevel());
            Assert.assertEquals("User is not the same as what you entered.", true, uuser.equals(database.getAuth("zichengliu", "456789")));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for existed worker
     */
    @Test
    public void testExistWorker() {
        try {
            Assert.assertEquals("Userlevel is not correct.", UserLevel.WORKER, database.getAuth("linhanli", "234567").getUserLevel());
            Assert.assertEquals("User is not the same as what you entered.", true, uworker.equals(database.getAuth("linhanli", "234567")));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for existed manager
     */
    @Test
    public void testExistManager() {
        try {
            Assert.assertEquals("Userlevel is not correct.", UserLevel.MANAGER, database.getAuth("hwang630", "123456").getUserLevel());
            Assert.assertEquals("User is not the same as what you entered.", true, umanager.equals(database.getAuth("hwang630", "123456")));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for existed admin
     */
    @Test
    public void testExistAdmin() {
        try {
            Assert.assertEquals("Userlevel is not correct.", UserLevel.ADMIN, database.getAuth("bobwaters", "678912").getUserLevel());
            Assert.assertEquals("User is not the same as what you entered.", true, uadmin.equals(database.getAuth("bobwaters", "678912")));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for not correct password
     */
    @Test
    public void testNotCorrectPassword() {
        try {
            Assert.assertEquals("Userlevel is not null.", null, database.getAuth("bobwaters", "1215456265"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for not correct user name
     */
    @Test
    public void testNotCorrectUserName() {
        try {
            Assert.assertEquals("Userlevel is not null.", null, database.getAuth("llllll", "678912"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for not correct password and correct name
     */
    @Test
    public void testBothNotCorrect() {
        try {
            Assert.assertEquals("Userlevel is not null.", null, database.getAuth("llllll", "11111"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }

    /**
     * test for both empty
     */
    @Test
    public void testBothEmpty() {
        try {
            Assert.assertEquals("Userlevel is not null.", null, database.getAuth("", ""));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }
}
