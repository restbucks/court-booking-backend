package com.restbucks.courtbooking.http

import org.junit.Test

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class IndexRestControllerTest extends MvcTest {

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