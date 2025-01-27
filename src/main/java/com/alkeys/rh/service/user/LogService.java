package com.alkeys.rh.service.user;

import com.alkeys.rh.entity.user.Log;
import com.alkeys.rh.repository.user.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService{
    @Autowired
    private LogRepository logRepository;


    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public List<Log> findByIdUser(Long id) {
        return logRepository.findByUser(id);
    }

}
