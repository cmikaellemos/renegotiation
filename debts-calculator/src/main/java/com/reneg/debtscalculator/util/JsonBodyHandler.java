package com.reneg.debtscalculator.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBodyHandler<W> implements HttpResponse.BodyHandler<Supplier<W>> {

	public JsonBodyHandler() {
    }

    private static <W> Supplier<W> toSupplierOfType(InputStream inputStream) {
        return () -> {
            try (InputStream stream = inputStream) {
                return new ObjectMapper().readValue(stream, new TypeReference<W>() {
                });
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        };
    }

    private static <W> HttpResponse.BodySubscriber<Supplier<W>> asJSON() {
        return HttpResponse.BodySubscribers.mapping(
                HttpResponse.BodySubscribers.ofInputStream(),
                JsonBodyHandler::toSupplierOfType);
    }

    @Override
    public HttpResponse.BodySubscriber<Supplier<W>> apply(HttpResponse.ResponseInfo responseInfo) {
        return JsonBodyHandler.asJSON();
    }

}
