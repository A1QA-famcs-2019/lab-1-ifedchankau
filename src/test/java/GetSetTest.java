import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetSetTest {

    @DataProvider(name="colorsTest")
    Object[][] colorsTest() {
        return new Object[][] {
                {1, 0.1, "BLUE"},
                {1, 0.1, "white"},
        };
    }

    @Test(dataProvider = "colorsTest")
    void getColorTest(int inkContainerValue, double sizeLetter, String color) {
        Assert.assertEquals(new Pen(inkContainerValue, sizeLetter, color).getColor(), color);
    }
}
