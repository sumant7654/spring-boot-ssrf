package dev.sumantakumar.springbootssrf.controller;

import dev.sumantakumar.springbootssrf.pojo.UrlPreview;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class UrlPreviewController {

    private final RestClient restClient;

    public UrlPreviewController(RestClient.Builder builder){
        this.restClient = builder.build();
    }

    @GetMapping("/api/preview")
    public UrlPreview preview(@RequestParam String url){
        ResponseEntity<String> response = restClient.get()
                .uri(url)
                .retrieve()
                .toEntity(String.class);

        String body = response.getBody() != null ? response.getBody() : "";
        return new UrlPreview(url,
                response.getStatusCode().value(),
                String.valueOf(response.getHeaders().getContentType()),
                body.length() > 200 ? body.substring(0,200)+"..." : body
        );

    }



}
