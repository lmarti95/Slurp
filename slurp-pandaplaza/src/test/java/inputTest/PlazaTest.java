package inputTest;

import main.Interaction;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

public class PlazaTest {


    @Before
    public void initTest() throws FileNotFoundException {
        Interaction.initGame();
        File result = new File("testResult.txt");
        PrintWriter writer = new PrintWriter(result);
        writer.print("");
        writer.close();
    }


    @Test
    public void testInit() throws IOException {

       Interaction.listen(new FileReader("tests/input/initInput.txt"), true);
       File result = new File("testResult.txt");
       File assertOut = new File("tests/output/initOutput.txt");
       Assert.assertTrue(FileUtils.contentEquals(result, assertOut));
    }

    @Test
    public void testOBrokenTile() throws IOException {

        Interaction.listen(new FileReader("tests/input/oBrokenTileInput.txt"), true);
        File result = new File("testResult.txt");
        File assertOut = new File("tests/output/oBrokenTileOutput.txt");
        Assert.assertTrue(FileUtils.contentEquals(result, assertOut));
    }

}
