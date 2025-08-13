package com.kenni.datos.datos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;

@SpringBootTest
@ActiveProfiles("test")
class DatosApplicationTests {

        @MockBean
        private PubSubTemplate pubSubTemplate;

	@Test
	void contextLoads() {
	}

}
