package scheduler;

import com.jimenezict.bicing.bcnopendata.BicingApiCall;
import com.jimenezict.bicing.bcnopendata.dto.StationStatus;
import com.jimenezict.bicing.getstationstatus.service.InsertToDatabase;
import com.jimenezict.bicing.getstationstatus.service.ParserToDatabase;
import com.jimenezict.bicing.scheduler.StationUsageDetailScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.jimenezict.bicing.scheduler.TestUtils.buildStationStatus;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StationUsageDetailSchedulerTest {

    @Mock
    BicingApiCall bicingApiCall;

    @Mock
    ParserToDatabase parserToDatabase;

    @Mock
    InsertToDatabase insertToDatabase;

    @InjectMocks
    StationUsageDetailScheduler underTest;

    @Test
    public void reportCurrentTime() {
        when(bicingApiCall.getStationStatus()).thenReturn(buildStationStatus());
        underTest.reportCurrentTime();
        verify(parserToDatabase).processListOfStationsToGetUsePercentage(any());
        verify(insertToDatabase).insertListOfStationsToGetNumberOfAvailableDocks(any());
        verify(insertToDatabase).insertListOfStationsToGetNumberOfAvailableBikes(any());
        verify(insertToDatabase).insertListOfStationsToGetUsePercentage(any());
    }
}
