import com.jimenezict.bicing.getstationstatus.influx.InfluxRegisterDAO;
import com.jimenezict.bicing.getstationstatus.influx.InfluxRegisterDAOImpl;
import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import org.junit.Before;
import org.junit.Test;


public class InsertInfluxRegisterDTObyMeasureTest {

    private InfluxRegisterDAO influxRegisterDAO;

    @Before
    public void init(){
        influxRegisterDAO = new InfluxRegisterDAOImpl();
    }

    @Test
    public void insertRegisterOfAvailabilityOnFirstStationOnInfluxRegisterDAO(){
        InfluxRegisterDTO register = new InfluxRegisterDTO(1,15.0);
        influxRegisterDAO.insertInfluxRegisterDTOByMeasure("available",register);
    }

}
