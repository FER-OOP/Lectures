package hr.fer.oop.testing.example5;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.erp.ExchangeRateProvider;

public class CHFCalculatorTest {
    private CHFCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CHFCalculator(new ExchangeRateProvider("sSqBg-VaQrq-aBm4L"));
    }

    @Test
    public void testChfToHrk() {
        assertThat(calculator.chfToHrk(100), is(639.9271));
        assertThat(calculator.chfToHrk(200), is(1279.8542));
        assertThat(calculator.chfToHrk(500), is(3199.6355));
    }

    @Test
    public void testHrkToChf() {
        assertThat(calculator.hrkToChf(100), is(15.626779));
        assertThat(calculator.hrkToChf(200), is(31.253558));
        assertThat(calculator.hrkToChf(500), is(78.133895));
    }
}
