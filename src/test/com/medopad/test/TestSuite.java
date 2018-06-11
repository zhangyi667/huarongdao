package com.medopad.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestPuzzleParser.class, TestMaps.class, TestPoints.class
})
public class TestSuite {
}
