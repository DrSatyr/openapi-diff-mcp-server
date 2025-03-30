package com.sanpin.openapi.diff.mcp.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.reactive.function.client.WebClient;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.WebFluxSseClientTransport;
import io.modelcontextprotocol.spec.McpSchema.InitializeResult;
import io.modelcontextprotocol.spec.McpSchema.Tool;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class OpenApiDiffMCPServerTest {

    @LocalServerPort
    private int port;
    private McpSyncClient mcpSyncClient;
    private InitializeResult syncClientInitResult;


    @BeforeEach
    public void setup() {
        var transport = new WebFluxSseClientTransport(WebClient.builder().baseUrl("http://localhost:" + port));
        mcpSyncClient = McpClient.sync(transport).build();
        syncClientInitResult = mcpSyncClient.initialize();
    }

    @Test
    public void testServerSSEConnection() {
        List<Tool> tools = mcpSyncClient.listTools().tools();

        assertEquals(2, tools.size());
        assertTrue(tools.stream().anyMatch(tool -> tool.name().equals("version")));
        assertTrue(tools.stream().anyMatch(tool -> tool.name().equals("hasBreakingChanges")));
    }
}