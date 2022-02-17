package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.validation.Validated;
import jakarta.inject.Singleton;

@Singleton
@Controller("/")
@Validated
public class MyController {
    @Get(uri = "/test/{id}")
    public MutableHttpResponse<?> getTile(HttpRequest<?> request, @PathVariable("id") String id)
    {
        return HttpResponse.ok("OK").status(HttpStatus.OK);
    }

    @Error( status = HttpStatus.NOT_FOUND, global = true)
    public HttpResponse<?> notFound(HttpRequest<?> request) {
        return HttpResponse.serverError("Not found").status(HttpStatus.NOT_FOUND);
    }

    @Error( status = HttpStatus.NOT_ACCEPTABLE, global = true)
    public HttpResponse<?> notAcceptable(HttpRequest<?> request) {
        return HttpResponse.serverError("Not acceptable").status(HttpStatus.NOT_ACCEPTABLE);
    }
}
