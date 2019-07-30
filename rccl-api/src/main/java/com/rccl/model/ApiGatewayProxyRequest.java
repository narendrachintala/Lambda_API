package com.rccl.model;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * The Class ApiGatewayProxyRequest.
 */
public class ApiGatewayProxyRequest {
    
    /** The resource. */
    private String resource;
    
    /** The path. */
    private String path;
    
    /** The http method. */
    private String httpMethod;
    
    /** The headers. */
    private Map<String, String> headers;
    
    /** The query string parameters. */
    private Map<String, String> queryStringParameters;
    
    /** The path parameters. */
    private Map<String, String> pathParameters;
    
    /** The stage variables. */
    private Map<String, String> stageVariables;
    
    /** The context. */
    private Context context;
    
    /** The body. */
    private String body;
    
    /** The is base 64 encoded. */
    private Boolean isBase64Encoded;

    /**
     * Instantiates a new api gateway proxy request.
     */
    public ApiGatewayProxyRequest() {}

    /**
     * Gets the resource.
     *
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the http method.
     *
     * @return the http method
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * Gets the headers.
     *
     * @return the headers
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Gets the query string parameters.
     *
     * @return the query string parameters
     */
    public Map<String, String> getQueryStringParameters() {
        return queryStringParameters;
    }

    /**
     * Gets the path parameters.
     *
     * @return the path parameters
     */
    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    /**
     * Gets the stage variables.
     *
     * @return the stage variables
     */
    public Map<String, String> getStageVariables() {
        return stageVariables;
    }

    /**
     * Gets the context.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Gets the checks if is base 64 encoded.
     *
     * @return the checks if is base 64 encoded
     */
    public boolean getIsBase64Encoded() {
        return isBase64Encoded;
    }

    /**
     * Sets the resource.
     *
     * @param resource the new resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Sets the path.
     *
     * @param path the new path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets the http method.
     *
     * @param httpMethod the new http method
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * Sets the headers.
     *
     * @param headers the headers
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Sets the query string parameters.
     *
     * @param queryStringParameters the query string parameters
     */
    public void setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }

    /**
     * Sets the path parameters.
     *
     * @param pathParameters the path parameters
     */
    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    /**
     * Sets the stage variables.
     *
     * @param stageVariables the stage variables
     */
    public void setStageVariables(Map<String, String> stageVariables) {
        this.stageVariables = stageVariables;
    }

    /**
     * Sets the context.
     *
     * @param context the new context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Sets the body.
     *
     * @param body the new body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Sets the base 64 encoded.
     *
     * @param base64Encoded the new base 64 encoded
     */
    public void setBase64Encoded(Boolean base64Encoded) {
        isBase64Encoded = base64Encoded;
    }

    /**
     * Instantiates a new api gateway proxy request.
     *
     * @param resource the resource
     * @param path the path
     * @param httpMethod the http method
     * @param headers the headers
     * @param queryStringParameters the query string parameters
     * @param pathParameters the path parameters
     * @param stageVariables the stage variables
     * @param context the context
     * @param body the body
     * @param isBase64Encoded the is base 64 encoded
     */
    public ApiGatewayProxyRequest(String resource, String path, String httpMethod, Map<String, String> headers, Map<String, String> queryStringParameters, Map<String, String> pathParameters, Map<String, String> stageVariables, Context context, String body, boolean isBase64Encoded) {
        this.resource = requireNonNull(resource);
        this.path = requireNonNull(path);
        this.httpMethod = requireNonNull(httpMethod);
        this.headers = requireNonNull(headers);
        this.queryStringParameters = requireNonNull(queryStringParameters);
        this.pathParameters = requireNonNull(pathParameters);
        this.stageVariables = requireNonNull(stageVariables);
        this.context = context;
        this.body = requireNonNull(body);
        this.isBase64Encoded = requireNonNull(isBase64Encoded);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "ApiGatewayProxyRequest{" +
                "resource='" + resource + '\'' +
                ", path='" + path + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", headers=" + headers +
                ", queryStringParameters=" + queryStringParameters +
                ", pathParameters=" + pathParameters +
                ", stageVariables=" + stageVariables +
                ", context=" + context +
                ", body='" + body + '\'' +
                ", isBase64Encoded=" + isBase64Encoded +
                '}';
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiGatewayProxyRequest)) return false;

        ApiGatewayProxyRequest that = (ApiGatewayProxyRequest) o;

        if (isBase64Encoded != that.isBase64Encoded) return false;
        if (resource != null ? !resource.equals(that.resource) : that.resource != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (httpMethod != null ? !httpMethod.equals(that.httpMethod) : that.httpMethod != null) return false;
        if (headers != null ? !headers.equals(that.headers) : that.headers != null) return false;
        if (queryStringParameters != null ? !queryStringParameters.equals(that.queryStringParameters) : that.queryStringParameters != null)
            return false;
        if (pathParameters != null ? !pathParameters.equals(that.pathParameters) : that.pathParameters != null)
            return false;
        if (stageVariables != null ? !stageVariables.equals(that.stageVariables) : that.stageVariables != null)
            return false;
        if (context != null ? !context.equals(that.context) : that.context != null)
            return false;
        return body != null ? body.equals(that.body) : that.body == null;

    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int result = resource != null ? resource.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (httpMethod != null ? httpMethod.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        result = 31 * result + (queryStringParameters != null ? queryStringParameters.hashCode() : 0);
        result = 31 * result + (pathParameters != null ? pathParameters.hashCode() : 0);
        result = 31 * result + (stageVariables != null ? stageVariables.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (isBase64Encoded ? 1 : 0);
        return result;
    }
}
