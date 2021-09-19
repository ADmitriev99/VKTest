package org.example.TEST;

import static org.example.API.APITest.APITest;
import static org.example.UI.UITest.UITest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test on VK.com")
public class CommonTest {
    @Test
    public void Common() {
        APITest();
        UITest();
    }
}
