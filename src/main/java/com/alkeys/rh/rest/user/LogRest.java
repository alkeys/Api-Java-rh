package com.alkeys.rh.rest.user;


import com.alkeys.rh.entity.user.Log;
import com.alkeys.rh.service.user.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.alkeys.rh.rest.UrlApi.UserAppLogin;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(UserAppLogin)
public class LogRest {
    @Autowired
    private LogService logService;

    @GetMapping("/All")
    public List<Log> findAll() {
        return logService.findAll();
    }

    @GetMapping("/idUser/{id}")
    public List<Log> findByIdUser(Long id) {
        return logService.findByIdUser(id);
    }


}
