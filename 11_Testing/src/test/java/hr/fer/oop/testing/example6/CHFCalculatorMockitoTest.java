package hr.fer.oop.testing.example6;

import com.erp.ExchangeRateProvider;
import hr.fer.oop.testing.example5.CHFCalculator;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CHFCalculatorMockitoTest {

    private CHFCalculator calculator;

    @Mock
    ExchangeRateProvider mockErp;

    @Before
    public void setUp() {
        calculator = new CHFCalculator(mockErp);
    }

    @Test
    public void testChfToHrk() {
        when(mockErp.getRate("CHF", "HRK")).thenReturn(6.399271);
        
        assertThat(calculator.chfToHrk(100), closeTo(639.9271, 0.0000001));
        assertThat(calculator.chfToHrk(200), closeTo(1279.8542, 0.0000001));
        assertThat(calculator.chfToHrk(500), closeTo(3199.6355, 0.0000001));
        
        verify(mockErp, times(3)).getRate("CHF", "HRK"); 
    }

    @Test
    public void testHrkToChf() {
        when(mockErp.getRate("HRK", "CHF")).thenReturn(0.15626779);
        
        assertThat(calculator.hrkToChf(100), closeTo(15.626779, 0.0000001));
        assertThat(calculator.hrkToChf(200), closeTo(31.253558, 0.0000001));
        assertThat(calculator.hrkToChf(500), closeTo(78.133895, 0.0000001));
        
        verify(mockErp, times(3)).getRate("HRK", "CHF"); 
    }
    
    @Test
    public void testPrintRates() {      
        calculator.printRates();
        verify(mockErp).printRates(); //verify that happend once
    }
}