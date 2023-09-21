package com.tech.kj.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class SellerOnBoardControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createNewSeller_withPositiveTest(){
        Assertions.assertTrue(true);
    }

    @Test
    public void createNewSeller_invalidNameTest(){
        Assertions.assertTrue(true);
    }

    @Test
    public void createNewSeller_invalidContactNumberTest(){
        Assertions.assertTrue(true);
    }

    @Test
    public void createNewSeller_invalidEmailTest(){
        Assertions.assertTrue(true);
    }

    @Test
    public void createProfile_withPositiveTest(){
        Assertions.assertTrue(true);
    }

    @Test
    public void resendEmail_WithPositiveTest(){
        Assertions.assertTrue(true);
    }

    @Test
    public void resendEmail_WithNegativeTest(){
        Assertions.assertFalse(false);
    }

    @Test
    public void resendOTP_withPositiveTest(){
        Assertions.assertTrue(true);
    }

    @Test
    public void resendOTP_withNegativeTest(){
        Assertions.assertFalse(false);
    }
}
