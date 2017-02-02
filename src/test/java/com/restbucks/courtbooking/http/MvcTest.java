package com.restbucks.courtbooking.http;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureRestDocs(outputDir = "build/snippets")
public abstract class MvcTest {

    @Autowired
    protected MockMvc mvc;

    @Before
    public void setUp() {
        RestAssuredMockMvc.mockMvc(this.mvc);
    }

}
