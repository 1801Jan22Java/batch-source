package com.revature.GeneMutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GeneMutations gm = new GeneMutations();
        
        ArrayList<String> testBank = new ArrayList<String>();
        
        Collections.addAll(testBank, "AAGGTTCT","AAGGTTTT","AAGTTTCC");
        
        // Tested, works.
        System.out.println(gm.checkValidMutation(testBank, "AAGGTTCC"));
        
        // Case where bank is equal
        gm.assessor("AAGGTTCC", "AAGGTTCC", testBank);
        
        // Case where end is illegal
        gm.assessor("AAGGTTCC", "AAGGOTCC", testBank);
        
        // Case where it's a valid mutation
        gm.assessor("AAGGTTCC", "AAGGTTTT", testBank);
        
        // Case where intermediate is not valid
        gm.assessor("AGGCTTCC", "AAGGTTTT", testBank);
    }
}
