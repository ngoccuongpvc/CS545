package edu.miu.lab04.service.impl;

import edu.miu.lab04.entity.Exception;
import edu.miu.lab04.entity.Log;
import edu.miu.lab04.entity.dtos.ExceptionDto;
import edu.miu.lab04.repo.ExceptionRepo;
import edu.miu.lab04.service.ExceptionService;
import edu.miu.lab04.service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ExceptionServiceImpl implements ExceptionService {
    private final ExceptionRepo exceptionRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ExceptionServiceImpl(ExceptionRepo exceptionRepo, ModelMapper modelMapper) {
        this.exceptionRepo = exceptionRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void log(String operation, String exceptionType) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setOperation(operation);
        LocalDateTime now = LocalDateTime.now();
        exceptionDto.setDate(now.toLocalDate());
        exceptionDto.setTime(now.toLocalTime());
        exceptionDto.setExceptionType(exceptionType);

        Exception log = modelMapper.map(exceptionDto, Exception.class);
        exceptionRepo.save(log);
    }
}
