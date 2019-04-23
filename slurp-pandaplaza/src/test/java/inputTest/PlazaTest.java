package inputTest;

import main.Interaction;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class PlazaTest {



    @Test
    public void testInit() throws IOException {
       File result = new File("testResult.txt");
       clearFile(result);
       Interaction.listen(new FileReader("tests/input/initInput.txt"), true);
       File assertOut = new File("tests/output/initOutput.txt");
       Assert.assertTrue(FileUtils.contentEquals(result, assertOut));
    }

    private void clearFile(File f) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(f);
        writer.print("");
        writer.close();
    }

}
