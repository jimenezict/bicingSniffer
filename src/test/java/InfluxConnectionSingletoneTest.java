import com.jimenezict.bicing.getstationstatus.influx.InfluxRegisterDAO;
import com.jimenezict.bicing.getstationstatus.influx.InfluxRegisterDAOImpl;
import org.junit.Before;
import org.junit.Test;

public class InfluxConnectionSingletoneTest {

    InfluxRegisterDAO influxRegisterDAO;

    @Before
    public void init(){
        influxRegisterDAO = new InfluxRegisterDAOImpl();
    }

    @Test
    public void influxConnectionSingletoneTest(){
        influxRegisterDAO.getInstance();
    }
}
