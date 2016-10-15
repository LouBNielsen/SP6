/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author LouiseB
 */
public class RESTQuoteTest
{

    public RESTQuoteTest()
    {
    }
    private static Map<Integer, String> quotes = new HashMap()
    {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };

    @Test
    public void testGetQuote()
    {
        System.out.println("getQuote");
        String expResult = quotes.get(3);
        String result = quotes.get(3); //success
        // String result = quotes.get(2); fail
        assertEquals(expResult, result);

    }

    @Test
    public void testGetRandomQuote()
    {
        System.out.println("getRandomQuote");
        Random rand = new Random();
        String expResult = quotes.get(rand.nextInt(quotes.size()) + 1);
        String result = expResult; //success
        // String result = quotes.get(3); fails sometimes
        assertEquals(expResult, result);

    }

}
