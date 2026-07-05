package dev.sumantakumar.springbootssrf.pojo;

public record UrlPreview(
            String url,
            int status,
            String contentType,
            String bodyPreview
    ){}