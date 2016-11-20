package test;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
//import java.io.IOException;

/**
 * Created by Yunlan Sun on 6/11/2016.
 * M5_V2
 */

public class checkSubmitReport {

    private User user;

    /**
     * set up test
     */
    @Before
    public void setUp() {
        user = new User("zichengliu","456789", UserLevel.USER,"none@mail.com");
    }

    /**
     * test for existed Report
     */
    @Test
    public void testExistReport() {

        Report exitReport = new UserReport("zichengliu", "testagian", "2016_10_31_19_55_20", "47.6297,-122.3231", WaterType.OTHER, WaterCondition.UNKNOWN);
        Assert.assertEquals("file already existed, wrong", false, user.submitReport(exitReport));
    }

    /**
     * test null input
     */
    @Test
    public void testNull() {

            Assert.assertEquals("method should not find a user here", false, user.submitReport(null));

    }

    /**
     * test for new report
     */
    @Test
    public void testNewReport() {
        try {
            Report newReport = new UserReport("zichengliu", "testagian3", "2022_10_31_19_55_20", "47.6297,-122.3231", WaterType.OTHER, WaterCondition.UNKNOWN);
            boolean result =  user.submitReport(newReport);
            String path = newReport.getPath();
            File f;
            boolean bool;

                // create new file
                f = new File(path);

                // tries to delete a non-existing file
                bool = f.delete();

                // prints
                System.out.println("File deleted: " + bool);

                // creates file in the system
                f.createNewFile();

                // createNewFile() is invoked
                System.out.println("createNewFile() method is invoked");

                // tries to delete the newly created file
                bool = f.delete();

                // print
                System.out.println("File deleted: " + bool);
                Assert.assertEquals("user can submit new report", true, result);
            } catch (Exception e) {
                // if any error occurs
                e.printStackTrace();
            }


    }
    /**
     * test for wrong report type
     */
    @Test
    public void testWrongReportType() {
        try {
            Report newReport = new WorkerReport("zichengliu", "testagian3", "2022_10_31_19_55_20", Condition.SAFE, "1", "2");
            Assert.assertEquals("submit wrong report type", false, user.submitReport(newReport));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("should not have this exception");
        }
    }
}

