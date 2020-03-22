import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionalityTest {
    private String testWord = "i love QA";
    private String letter = "F";

    @DataProvider(name = "noInkProvider")
    Object[][] noInk() {
        return new Object[][]{
                {0, 0.1, "BLUE"},
        };
    }


    @DataProvider(name = "enoughInkProvider")
    Object[][] enoughInk() {
        return new Object[][]{
                {1000, 0.1, "BLUE"},
        };
    }


    @DataProvider(name = "oneLetterInkProvider")
    Object[][] oneLetterInk() {
        return new Object[][]{
                {1, 1, "BLUE"},
        };
    }


    @DataProvider(name = "threeLettersInkProvider")
    Object[][] threeLettersInk() {
        return new Object[][]{
                {3, 1, "BLUE"},
        };
    }



    @Test(dataProvider = "noInkProvider")
    void noInkTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        Assert.assertFalse(pen.isWork());
    }


    @Test(dataProvider = "enoughInkProvider")
    void enoughInkTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        Assert.assertTrue(pen.isWork());
    }


    @Test(dataProvider = "enoughInkProvider")
    void enoughInkAfterWritingTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        pen.write(letter);
        Assert.assertTrue(pen.isWork());
    }


    @Test(dataProvider = "oneLetterInkProvider")
    void oneLetterWritingWithOneInkTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        pen.write(letter);
        Assert.assertFalse(pen.isWork());
    }


    @Test(dataProvider = "threeLettersInkProvider")
    void severalWritingTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        pen.write(letter);
        Assert.assertTrue(pen.isWork());
        pen.write(letter + letter);
        Assert.assertFalse(pen.isWork());
    }


    @Test(dataProvider = "threeLettersInkProvider")
    void wordLongerThanInkWritingTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        pen.write(testWord + testWord + testWord);
        Assert.assertFalse(pen.isWork());
    }


    @Test(dataProvider = "enoughInkProvider")
    void writingFullWordTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        Assert.assertEquals(testWord, pen.write(testWord));
    }


    @Test(dataProvider = "threeLettersInkProvider")
    void writingPartOfWordTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        String wordPart = testWord.substring(0, 3);
        Assert.assertEquals(wordPart, pen.write(testWord));
    }


    @Test(dataProvider = "noInkProvider")
    void writingWithoutInkTest(int inkContainerValue, double sizeLetter, String color) {
        Pen pen = new Pen(inkContainerValue, sizeLetter, color);
        Assert.assertEquals("", pen.write(testWord));
    }

}
