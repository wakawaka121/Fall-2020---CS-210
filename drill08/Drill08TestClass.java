import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Drill08TestClass {

    @Test
    public void canMakeSumTrue() {
    	Integer[] array = new Integer[] { 2, 1, 1, 3, 5};
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        assertTrue(Drill08.canMakeSum(list, 9));
    }
    
    @Test
    public void canMakeSumFalse() {
    	Integer[] array = new Integer[] { 5, 4, 1, 6};
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        assertFalse(Drill08.canMakeSum(list, 8));
    }
    
    @Test
    public void canMakeSumZero() {
    	Integer[] array = new Integer[] { 5, 4, 1, 6};
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        assertTrue(Drill08.canMakeSum(list, 0));
    }
    
    @Test
    public void canMakeSum1() {
    	Integer[] array = new Integer[] { 5 };
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        assertFalse(Drill08.canMakeSum(list, 10));
    }
    
    @Test
    public void canMakeSum2() {
    	Integer[] array = new Integer[] { 5, 2, 1, 1 };
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        assertTrue(Drill08.canMakeSum(list, 4));
    }
    
    @Test
    public void lcs1() {
        assertEquals("te", Drill08.longestCommonSubsequence("tyler", "kate"));
    }
    
    @Test
    public void lcs2() {
        assertEquals("anna", Drill08.longestCommonSubsequence("hannah", "banana"));
    }
    
    @Test
    public void lcs3() {
        assertEquals("sesells", Drill08.longestCommonSubsequence("she sells", "seashells"));
    }
    
    @Test
    public void lcs4() {
        assertEquals("", Drill08.longestCommonSubsequence("CS210", "arizona"));
    }
    
    @Test
    public void editDistance1() {
        assertEquals(1, Drill08.editDistance("driving", "diving"));
    }
    
    @Test
    public void editDistance2() {
        assertEquals(3, Drill08.editDistance("debate", "irate"));
    }
    
    @Test
    public void editDistance3() {
        assertEquals(6, Drill08.editDistance("football", "cookies"));
    }
}
