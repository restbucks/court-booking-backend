package com.restbucks.courtbooking.http

import org.junit.Test

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class CourtRestControllerTest extends MvcTest {

    @Test
    void itShouldListAllCourts() throws Exception {

        this.mvc.perform(get("/rel/courts"))
                .andExpect(status().isOk())
                .andDo(document("courts",
                links(halLinks(),
                        linkWithRel("self").description("self link"))
        ))

    }
}
