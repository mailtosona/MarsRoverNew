package app;

import org.junit.Test;
import service.NASACapcomService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void shouldTakeUserInput (){
        NASACapcomService capcom=new NASACapcomService();
        String[] args =new String[0];
        String input="5 5 \n1 2 N\nLMLMLMLMM\nFinish";
        InputStream in=new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Rover -1 1 3 N on Plateau-1",Main.start(capcom,in,args));
    }
    @Test
    public void shouldTakeFileAsInputToStartMethod() {
        NASACapcomService capcom = new NASACapcomService();
        String[] args = {"testdata\\shouldTakeFileInputTest.txt"};
        InputStream in = System.in;
        assertEquals("ROVER-1 at 1 3 N on PLATEAU-1",  Main.start(capcom, in,args));
    }

    @Test
    public void shouldStopProcessingIfFileNotFound() {
        NASACapcomService capcom = new NASACapcomService();
        String[] args = {"nosuchfile.nosuchfile"};
        InputStream in = System.in;
        assertNull(Main.start(capcom, in,args));
    }

    @Test
    public void shouldHandleInvalidCommandInFile() {
        NASACapcomService capcom = new NASACapcomService();
        String[] args = {"testdata\\shouldHandleInvalidCommandInFile.txt"};
        InputStream in = System.in;
        assertEquals("ROVER-1 at 1 3 N on PLATEAU-1",  Main.start(capcom,in,args));
    }

    @Test
    public void shouldTestMapShowAndHide() {
        NASACapcomService capcom = new NASACapcomService();
        String[] args = {"testdata\\quadMap.txt"};
        InputStream in = System.in;
        assertEquals("ROVER-1 at 0 7 W on PLATEAU-1\nROVER-2 at 500 493 S on PLATEAU-2",  Main.start(capcom,in,args));
    }

    @Test
    public void shouldHandleBigMoves() {
        NASACapcomService capcom = new NASACapcomService();
        String[] args = {"testdata\\bigMap.txt"};
        InputStream in = System.in;
        assertEquals("ROVER-1 at 0 0 N on PLATEAU-1",  Main.start(capcom,in,args));
    }


}