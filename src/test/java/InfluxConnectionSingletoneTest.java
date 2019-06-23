import com.jimenezict.bicing.getstationstatus.influx.InfluxConnectionSingletone;
import org.junit.Test;

public class InfluxConnectionSingletoneTest {

    @Test
    public void influxConnectionSingletoneTest(){
        InfluxConnectionSingletone.getInstance();
    }
}
