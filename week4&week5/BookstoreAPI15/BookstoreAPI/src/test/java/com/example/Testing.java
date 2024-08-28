package com.example;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static javax.swing.UIManager.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;


@ExtendWith(MockitoExtension.class)
public class Testing {

    @Mock
    private Bookentity b ;

    @InjectMocks
    private Bookentity b1;

    @Test
    void testCreateItem() {
        //test condition(CRUD)
    }
    MockMvc mockMvc;

    @Test
    public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() {
        try {
            this.mockMvc.perform((RequestBuilder) get("/homePage")).andDo(print())
                    .andExpect(view().name("index"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
