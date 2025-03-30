# openapi-diff-mcp-server

MCP server interface for AI integration with [openapi-diff](https://github.com/OpenAPITools/openapi-diff) tool for comparing OpenAPI specifications.

## Features

- TBD

## Usage

The server exposes an MCP function `compare_openapi_specs` that takes two parameters:
- `oldSpec`: The original OpenAPI specification
- `newSpec`: The updated OpenAPI specification

### Example Request

```json
{
  "name": "compare_openapi_specs",
  "arguments": {
    "oldSpec": "openapi: 3.0.0\ninfo:\n  title: API\n  version: 1.0.0",
    "newSpec": "openapi: 3.0.0\ninfo:\n  title: API\n  version: 2.0.0"
  }
}
```

## Building and Running

```bash
mvn clean install
java -jar target/openapi-diff-mcp-server-<VERSION>.jar
```
