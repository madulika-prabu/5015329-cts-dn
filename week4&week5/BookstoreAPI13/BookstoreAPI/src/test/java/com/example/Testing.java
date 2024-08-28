package com.example;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


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
}
