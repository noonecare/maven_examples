/**
 * Created by T440P on 2017/3/4.
 */
package com.wangmeng.maven;

import junit.framework.TestCase;

public class TestForSampleForSurefire extends TestCase {
    public void testSampleForSurefireAdd()
    {
        SampleForSurefire a = new SampleForSurefire(1, 2);
        SampleForSurefire b = new SampleForSurefire(3, 4);
        SampleForSurefire exptected = new SampleForSurefire(4, 6);
        a.SampleAdd(b);
        assertEquals(a.getReal(), exptected.getReal());
        assertEquals(a.getImage(), exptected.getImage());

    }

}
