/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.testing.example1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class StringBuilderTest3 {

    @Test
    public void testProvokeException() {
        StringBuilder sb = null;
        sb.append("Some text");
        assertEquals("Some text", sb.toString());
    }
}
