import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ConstructorTest {
    @DataProvider(name="provideValidParams")
    Object[][] provideValidParams() {
        return new Object[][] {
                {1, 0.1, "GREEN"},      // standard params
                {0, 0.1, "GREEN"},
                {1, 1, "GREEN"},
                {1, 2.0, "GREEN"},
                {1, 0.1, "yellow"},
                {Integer.MAX_VALUE, 0.1, "GREEN"},
                {1, Double.MIN_VALUE, "GREEN"},
                {1, Double.MAX_VALUE, "GREEN"},
        };
    }


    @DataProvider(name="provideInvalidParams")
    Object[][] invalidParams() {
        return new Object[][] {
                {-1, 0.1, "GREEN"},
                {1, -0.1, "GREEN"},
                {1, 0.1, ""},
                {1, 0.1, null}
        };
    }


    @Test(dataProvider = "provideValidParams")
    void ValidConstructorTest(int inkContainerValue, double sizeLetter, String color)
    {
        new Pen(inkContainerValue);
        new Pen(inkContainerValue, sizeLetter);
        new Pen(inkContainerValue, sizeLetter, color);
    }


    @Test(dataProvider = "provideInvalidParams")
    void InvalidConstructorTest(int inkContainerValue, double sizeLetter, String color)
    {
        Assert.expectThrows(Exception.class, () -> new Pen(inkContainerValue, sizeLetter, color));
    }
}