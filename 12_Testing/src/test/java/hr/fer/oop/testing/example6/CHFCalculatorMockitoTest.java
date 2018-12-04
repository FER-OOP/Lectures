package hr.fer.oop.testing.example6;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.erp.ExchangeRateProvider;

import hr.fer.oop.testing.example5.CHFCalculator;

public class CHFCalculatorMockitoTest {

    private CHFCalculator calculator;

    @Mock
    ExchangeRateProvider mockErp;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
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