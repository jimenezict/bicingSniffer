import com.jimenezict.bicing.getstationstatus.influx.InfluxRegisterDAO;
import com.jimenezict.bicing.getstationstatus.influx.InfluxRegisterDAOImpl;
import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import com.jimenezict.bicing.getstationstatus.service.InsertToDatabase;
import com.jimenezict.bicing.getstationstatus.service.InsertToDatabaseImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
public class InsertInfluxRegisterFromServicebyMeasureTest {

    private InsertToDatabase insertToDatabase;

    @Before
    public void init(){
        insertToDatabase = new InsertToDatabaseImpl();
    }

    @Test
    @Ignore
    public void insertRegisterOfAvailabilityOnFirstStationOnInfluxRegisterDAO(){
        List<InfluxRegisterDTO> influxRegisterDTOS = new ArrayList<>();
        influxRegisterDTOS.add( new InfluxRegisterDTO(1000,15.0));
        insertToDatabase.insertListOfStationsToGetNumberOfAvailableDocks(influxRegisterDTOS);
    }

}
