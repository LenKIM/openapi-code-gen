package com.likelen.openapi;

import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.mock.OpenAPIExpectation;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class ApplicationTest {

    @Test
    void name() {
        ClientAndServer mockServer = ClientAndServer.startClientAndServer(8084);

        mockServer.upsert(
                OpenAPIExpectation
                        .openAPIExpectation("/Users/len/study/openapi-codegen-demo/app/src/test/resources/api.yml")
        );
        System.out.println("MockServer Ready.");
    }
}
