package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
@Controller("/")
@Validated
public class MyController {
    @Get(uri = "/test/{id}")
    public MutableHttpResponse<?> getTile(HttpRequest<?> request, @PathVariable("id") String id,
                                          @Nullable @QueryValue("nodeid") String nodeid,
                                          @Nullable @QueryValue("p") List<String> p,
                                          @Nullable @QueryValue("gutter") Integer gutter)
            throws Throwable
    {

        return HttpResponse.status(HttpStatus.OK);

    }

    @Error( status = HttpStatus.NOT_FOUND, global = true)
    public HttpResponse<?> notFound(HttpRequest<?> request) {
        return HttpResponse.serverError("");
    }

    @Error( status = HttpStatus.NOT_ACCEPTABLE, global = true)
    public HttpResponse<?> notAcceptable(HttpRequest<?> request) {
        return HttpResponse.serverError("");
    }
}
