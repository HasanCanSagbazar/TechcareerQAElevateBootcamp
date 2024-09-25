package Base;

import org.testng.Assert;

public class BaseLibrary extends TestData {
    public void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void AssetEquals(String expectedValue, String actualValue){
        Assert.assertEquals(expectedValue, actualValue);
    }

}
