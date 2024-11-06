package edu.miu.lab05.service;

import edu.miu.lab05.entity.dtos.LoginRequest;
import edu.miu.lab05.entity.dtos.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}
