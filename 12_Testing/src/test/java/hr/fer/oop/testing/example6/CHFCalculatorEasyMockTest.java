package hr.fer.oop.testing.example6;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.closeTo;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.erp.ExchangeRateProvider;

import hr.fer.oop.testing.example5.CHFCalculator;

public class CHFCalculatorEasyMockTest  {
   
    private CHFCalculator calculator = new CHFCalculator(null);
   
    ExchangeRateProvider mockErp;

    @BeforeEach
    public void setUp() {   
    	mockErp = mock(ExchangeRateProvider.class);
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
