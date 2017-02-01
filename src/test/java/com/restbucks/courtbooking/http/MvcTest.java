package com.restbucks.courtbooking.http;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {IndexRestController.class, CourtRestController.class})
public abstract class MvcTest {

    @Rule
    public JUnitRestDocumentation restDocumentation =
        new JUnitRestDocumentation("build/generated-snippets");

    protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext context;

    /**
     * setup mvc.
     */
    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
            .alwaysDo(print())
            .apply(documentationConfiguration(this.restDocumentation))
            .build();

        RestAssuredMockMvc.mockMvc(this.mvc);
    }

}
