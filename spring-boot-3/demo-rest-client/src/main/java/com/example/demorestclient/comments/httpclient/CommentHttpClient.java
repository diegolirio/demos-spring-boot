package com.example.demorestclient.comments.httpclient;

import com.example.demorestclient.comments.dto.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CommentHttpClient {

    private final RestTemplate restTemplate;

    public CommentHttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${external-application.url}")
    String externalApplicationUrl;

    public List<Comment> getListSimple() {
        return restTemplate.getForObject(
                externalApplicationUrl + "/comments",
                List.class
        );
    }

    public List<Comment> getListArrayToList() {
        return Arrays.stream(restTemplate.getForObject(
                externalApplicationUrl + "/comments",
                Comment[].class
        )).toList();
    }

    public List<Comment> getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requests = new HttpEntity<>(headers);
        return restTemplate.exchange(
                externalApplicationUrl + "/comments",
                HttpMethod.GET,
                requests,
                new ParameterizedTypeReference<List<Comment>>() {
                }
        ).getBody();
    }

    public Comment create(Comment comment) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + "token");
        HttpEntity<Object> requests = new HttpEntity<>(comment, headers);
        return restTemplate.exchange(
                externalApplicationUrl + "/comments",
                HttpMethod.POST,
                requests,
                Comment.class
        ).getBody();
    }

    public Comment getById(Long id) {
        ResponseEntity<Comment> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(
                    String.format("%s/comments/%s", externalApplicationUrl, id),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Comment>() {
                    }
            );
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return (Comment) responseEntity.getBody();
            }
            return (Comment) responseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("Comment not found = " + id);
            }
            throw new RuntimeException("Somenthing is wrong");
        }
    }

    public Comment update(Long id, Comment comment) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requests = new HttpEntity<>(comment, headers);
        return restTemplate.exchange(
                externalApplicationUrl + "/comments/" + id,
                HttpMethod.PUT,
                requests,
                new ParameterizedTypeReference<Comment>() {
                }
        ).getBody();
    }

}
