import com.jimenezict.bicing.getstationstatus.bcnopendata.BicingApiCall;
import com.jimenezict.bicing.getstationstatus.bcnopendata.BicingApiCallImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetStationStatusTest {

    private BicingApiCall bicingApiCall;

    @Before
    public void init(){
        bicingApiCall = new BicingApiCallImpl();
    }

    @Test
    public void GetStationStatusLastUpdated(){
        assertTrue(bicingApiCall.getStationStatus().getLast_updated() > 1561116149l);
    }

    @Test
    public void GetStationStatusTTL(){
        assertTrue(bicingApiCall.getStationStatus().getTtl() > 0);
    }

    @Test
    public void CountStations(){
        assertEquals(410, bicingApiCall.getStationStatus().getData().getStations().size());
    }

}
