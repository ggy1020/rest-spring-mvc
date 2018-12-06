package com.yingxiaotong.restspringmvc.controller;

import com.yingxiaotong.restspringmvc.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonRestController {

    @GetMapping("/person/{id}")
    public Person person(@PathVariable Long id, @RequestParam(required = false) String  name){
        Person   person = new Person();
        person.setId(id);
        person.setName(name);
        return  person;
    }

    @PostMapping("/post/person")
    public String postPerson(@RequestBody Person person){
        System.err.println(person);
        return  "success";
    }

    @PostMapping(value = "/person/json/to/properties",
            consumes = "text/plain",
            produces = "application/properties+person" // 响应类型
    )
    public Person personJsonToProperties(@RequestParam String json) {

        // JSON to Map
        // Map to Properties
        return null;
    }

    @PostMapping(value = "/person/json/to/properties",
            produces = "application/properties+person" // 响应类型
    )
    public Person personJsonToProperties(@RequestBody Person person) {
        // @RequestBody 的内容是 JSON
        // 响应的内容是 Properties
        return person;
    }

    /**
     * 传入是json返回是properties
     *
     * */
    @PostMapping(value = "/person/properties/to/json",
            consumes = "application/properties+person", // 请求类型 // Content-Type
            produces =  MediaType.APPLICATION_JSON_UTF8_VALUE// 响应类型 // Accept
    )
    public Person personPropertiesToJson(@RequestBody Person person) {
        // @RequestBody 的内容是 Properties
        // 响应的内容是 JSON
        return person;
    }
}
