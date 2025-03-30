package com.sanpin.openapi.diff.mcp.server.service;

import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class OpenApiDiffService {

    @Tool(name="hasBreakingChanges", description = "Compare two OpenAPI specifications and check if there are breaking changes or not.")
    public Boolean hasBreakingChanges(@ToolParam(description = "old spec to compare") String oldSpec,
                                      @ToolParam(description = "new spec to compare") String newSpec) {
        ChangedOpenApi diff = OpenApiCompare.fromContents(oldSpec, newSpec);
        return !diff.isCompatible();
    }

    @Tool(name = "version", description = "Get the version of library used for OpenAPI comparing.")
    public String version() {
        return OpenApiCompare.class.getPackage().getImplementationVersion();
    }
}
