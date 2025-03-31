# openapi-diff-mcp-server

MCP server interface for AI integration with [openapi-diff](https://github.com/OpenAPITools/openapi-diff) tool for comparing OpenAPI specifications.

## Features

- TBD

## Usage

### Using MCP Server with Cloude Desktop

1. Build MCP server Jar using:

```shell
mvn clean install
```

2. To use the MCP server with Cloude Desktop, you need to configure it using a `claude_desktop_config.json` file. Below is an example configuration:

```json
{
  "mcpServers": {
    "openapi-diff-mcp-server": {
      "command": "java",
      "args": [
        "-jar",
        "-Dmcp.transport=stdio",
        "/path/to/jar/openapi-diff-mcp-server-0.0.1-SNAPSHOT.jar"
      ]
    }
  }
}
```

## Building and Running

```bash
mvn clean install
java -jar target/openapi-diff-mcp-server-<VERSION>.jar
```
