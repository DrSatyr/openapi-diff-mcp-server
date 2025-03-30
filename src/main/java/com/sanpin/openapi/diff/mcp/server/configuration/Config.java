package com.sanpin.openapi.diff.mcp.server.configuration;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sanpin.openapi.diff.mcp.server.service.OpenApiDiffService;

@Configuration
public class Config {

    @Bean
    public OpenApiDiffService openApiDiffService() {
        return new OpenApiDiffService();
    }

    @Bean
    public ToolCallbackProvider openApiDiffTools(OpenApiDiffService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }
}
