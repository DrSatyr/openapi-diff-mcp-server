package com.sanpin.openapi.diff.mcp.server.service;

import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class OpenApiDiffService {

    @Tool(name="hasBreakingChanges", description = "Compare two OpenAPI specifications to detect breaking changes.")
    public Boolean hasBreakingChanges(String oldSpec, String newSpec) {
        ChangedOpenApi diff = OpenApiCompare.fromContents(oldSpec, newSpec);
        return diff.isCompatible();
    }

    @Tool(name = "version", description = "Get the version of underlying OpenAPI Diff library.")
    public String version() {
        return OpenApiCompare.class.getPackage().getImplementationVersion();
    }
}
