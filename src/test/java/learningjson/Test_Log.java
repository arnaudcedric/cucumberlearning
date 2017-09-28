package learningjson;

//import org.testng.Assert;

import java.util.logging.Logger;

/**
 * Created by acedric on 13/06/2017.
 */
public class Test_Log {

    private final Logger logger = Logger.getLogger(getClass().getName());

    public void test(){

        int a = 1;
        int b = 2;

//        Assert.assertEquals(a,b);
        logger.info("Trying to assert two numbers " + a + " " + b);

    }

    public static void main(String[] args) {

        Test_Log test_log = new Test_Log();
        test_log.test();

    }
}
