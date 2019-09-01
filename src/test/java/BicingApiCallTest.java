import com.jimenezict.bicing.bcnopendata.BicingApiCall;
import com.jimenezict.bicing.bcnopendata.BicingApiCallImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BicingApiCallTest {

    private BicingApiCall underTest;

    @Before
    public void init(){
        underTest = new BicingApiCallImpl();
    }

    @Test
    public void getStationStatus_validatesLastUpdateIsOnThePass_whenCallsToTheAPI(){
        assertTrue(underTest.getStationStatus().getLast_updated() > 1561116149l);
        underTest.getStationStatus().getLast_updated();
    }

    @Test
    public void getStationStatus_validatesThatTTLisMajorThanZero_whenCallsToTheAPI(){
        assertTrue(underTest.getStationStatus().getTtl() > 0);
    }

    @Test
    public void getStationStatus_validatesTheNumberOfStation_whenCallsToTheAPI(){
        assertEquals(410, underTest.getStationStatus().getData().getStations().size());
    }

}
