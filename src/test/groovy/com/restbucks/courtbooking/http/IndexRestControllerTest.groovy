package com.restbucks.courtbooking.http

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@WebMvcTest(IndexRestController.class)
class IndexRestControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation =
            new JUnitRestDocumentation("build/generated-snippets")

    private MockMvc mvc

    @Autowired
    private WebApplicationContext context

    @Before
    void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build()
    }

    @Test
    void itShouldListAllRels() throws Exception {

        this.mvc.perform(get("/rel/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("index",
                links(halLinks(),
                        linkWithRel("self").description("self link"),
                        linkWithRel("courts").description("link to courts"))
        ))

    }
}