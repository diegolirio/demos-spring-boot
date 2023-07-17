package com.example.demorestclient.todo.httpclient;

import com.example.demorestclient.todo.dto.ToDo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@HttpExchange(url = "/todos")
public interface TodoHttpClient {

    @GetExchange("/{id}")
    ToDo getById(@PathVariable long id);

    @GetExchange
    List<ToDo> getAll();

    @PostExchange
    ToDo create(@RequestBody ToDo toDo);

    @PutExchange("/{id}")
    ToDo update(@PathVariable Long id, @RequestBody ToDo toDo);
}
