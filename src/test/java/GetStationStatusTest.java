import com.jimenezict.bicing.getstationstatus.opendata.GetStationsStatus;
import com.jimenezict.bicing.getstationstatus.opendata.GetStationsStatusImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetStationStatusTest {

    private GetStationsStatus getStationsStatus;

    @Before
    public void init(){
        getStationsStatus = new GetStationsStatusImpl();
    }

    @Test
    public void GetStationStatusLastUpdated(){
        assertTrue(getStationsStatus.getStationStatus().getLast_updated() > 1561116149l);
    }

    @Test
    public void GetStationStatusTTL(){
        assertTrue(getStationsStatus.getStationStatus().getTtl() > 0);
    }

    @Test
    public void CountStations(){
        assertEquals(410,getStationsStatus.getStationStatus().getData().getStations().size());
    }

}
