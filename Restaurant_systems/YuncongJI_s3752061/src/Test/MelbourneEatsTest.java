package Test;
import org.junit.Test;
import java.io.FileNotFoundException;
import Main.MelbourneEats;

public class MelbourneEatsTest {

    @Test
    public void methodTest() throws FileNotFoundException {
        MelbourneEats melbourneEats =new MelbourneEats();
        melbourneEats.method();
    }

    @Test
    public void runTest(){
        MelbourneEats melbourneEats =new MelbourneEats();
        melbourneEats.run();
    }

    @Test
    public void menuTest(){
        MelbourneEats melbourneEats =new MelbourneEats();
        melbourneEats.menu();

    }

    @Test
    public void searchTest(){
        MelbourneEats melbourneEats =new MelbourneEats();
        melbourneEats.search();
    }



}
