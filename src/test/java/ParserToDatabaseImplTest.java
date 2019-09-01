import com.jimenezict.bicing.getstationstatus.influx.dto.InfluxRegisterDTO;
import com.jimenezict.bicing.bcnopendata.dto.Station;
import com.jimenezict.bicing.getstationstatus.service.ParserToDatabase;
import com.jimenezict.bicing.getstationstatus.service.ParserToDatabaseImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserToDatabaseImplTest {

    private ParserToDatabase parserToDatabaseImplTest;
    private List<Station> listOfStation;

    @Before
    public void init(){
        parserToDatabaseImplTest = new ParserToDatabaseImpl();
        listOfStation = new ArrayList<>();
        listOfStation.add(stationBuilder(1, 10, 5));
        listOfStation.add(stationBuilder(2, 5, 10));
    }

    private Station stationBuilder(int id, int available, int docksfree){
        Station station = new Station();
        station.setStation_id(id);
        station.setNum_bikes_available(available);
        station.setNum_docks_available(docksfree);
        return station;
    }

    @Test
    public void  processListOfStationsToGetNumberOfAvailableDocksTest(){
        List<InfluxRegisterDTO> listOfInfluxRegister =
                parserToDatabaseImplTest.processListOfStationsToGetNumberOfAvailableDocks(listOfStation);
        assertEquals(10, listOfInfluxRegister.get(1).getValue(),0.1);
    }

    @Test
    public void  processListOfStationsToGetNumberOfAvailableBikesTest(){
        List<InfluxRegisterDTO> listOfInfluxRegister =
                parserToDatabaseImplTest.processListOfStationsToGetNumberOfAvailableBikes(listOfStation);
        assertEquals(5, listOfInfluxRegister.get(1).getValue(),0.1);
    }

    @Test
    public void  processListOfStationsToGetUsePercentageTest(){
        List<InfluxRegisterDTO> listOfInfluxRegister =
                parserToDatabaseImplTest.processListOfStationsToGetUsePercentage(listOfStation);
        assertEquals(0.33, listOfInfluxRegister.get(1).getValue(),0.1);
    }
}
