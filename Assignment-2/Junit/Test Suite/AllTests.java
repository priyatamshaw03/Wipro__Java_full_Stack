package com.wipro.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestSort.class,
    TestCheckPresence.class
})
public class AllTests {
    // Empty — serves only as a holder for the above annotations
}
