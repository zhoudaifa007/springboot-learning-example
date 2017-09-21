package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.model.LoginParams;
import org.spring.springboot.model.ServerResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zhoudf2 on 2017-9-21.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ServerResponse login(@RequestBody LoginParams loginParams) {
        String token = UUID.randomUUID().toString();
        Map<String,String> map = new HashMap<String,String>();
        map.put("token", token);
        ServerResponse serverResponse = ServerResponse.successWithData(map);
        return serverResponse;
    }
}
