package pl.javastart;  
  
import org.junit.jupiter.api.Test;  
import java.io.IOException;  
import static org.junit.jupiter.api.Assertions.*;  
  
class MainTest {  
  
    @Test  
    void shouldGetH1() throws IOException {  
        String h1 = Main.getH1("http://example.com");  
        assertEquals("Example Domain", h1);  
    }  
}