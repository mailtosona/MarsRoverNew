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

}