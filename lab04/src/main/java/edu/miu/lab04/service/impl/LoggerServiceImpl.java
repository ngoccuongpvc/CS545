package edu.miu.lab04.service.impl;

import edu.miu.lab04.entity.Log;
import edu.miu.lab04.entity.dtos.LogDto;
import edu.miu.lab04.repo.LoggerRepo;
import edu.miu.lab04.service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class LoggerServiceImpl implements LoggerService {
    private final LoggerRepo loggerRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public LoggerServiceImpl(LoggerRepo loggerRepo, ModelMapper modelMapper) {
        this.loggerRepo = loggerRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void log(String principle, String operation) {
        LogDto logDto = new LogDto();
        logDto.setOperation(operation);
        logDto.setPrinciple(principle);
        LocalDateTime now = LocalDateTime.now();
        logDto.setDate(now.toLocalDate());
        logDto.setTime(now.toLocalTime());

        Log log = modelMapper.map(logDto, Log.class);
        loggerRepo.save(log);
    }
}
