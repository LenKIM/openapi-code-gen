package com.likelen.openapi.mockserver;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.mock.OpenAPIExpectation;

class Main {

    public static void main(String[] args) {
        ClientAndServer mockServer = ClientAndServer.startClientAndServer(8085);
        mockServer.upsert(
                OpenAPIExpectation
                        .openAPIExpectation("openapi.yaml")
        );

        System.out.println("MockServer Ready.");
    }
}
