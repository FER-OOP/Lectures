package hr.fer.oop.topic16.example6;

import com.erp.ExchangeRateProvider;
import hr.fer.oop.topic16.example5.CHFCalculator;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class CHFCalculatorEasyMockTest {

    @TestSubject
    private CHFCalculator calculator = new CHFCalculator(null);

    @Mock(type = MockType.STRICT)
    ExchangeRateProvider mockErp;

    @Before
    public void setUp() {
        calculator = new CHFCalculator(mockErp);
    }

    @Test
    public void testChfToHrk() {
        expect(mockErp.getRate("CHF", "HRK")).andReturn(6.399271).times(3);
        replay(mockErp);
        
        assertThat(calculator.chfToHrk(100), closeTo(639.9271, 0.0000001));
        assertThat(calculator.chfToHrk(200), closeTo(1279.8542, 0.0000001));
        assertThat(calculator.chfToHrk(500), closeTo(3199.6355, 0.0000001));
        
        verify(mockErp);
    }

    @Test
    public void testHrkToChf() {
        expect(mockErp.getRate("HRK", "CHF")).andReturn(0.15626779).times(3);
        replay(mockErp);
        
        assertThat(calculator.hrkToChf(100), closeTo(15.626779, 0.0000001));
        assertThat(calculator.hrkToChf(200), closeTo(31.253558, 0.0000001));
        assertThat(calculator.hrkToChf(500), closeTo(78.133895, 0.0000001)); 
        
        verify(mockErp);
    }
    
    @Test
    public void testPrintRates() {
        mockErp.printRates();
        EasyMock.expectLastCall().times(1);        
        replay(mockErp);
         
        calculator.printRates();
        
        verify(mockErp);
    }
}
