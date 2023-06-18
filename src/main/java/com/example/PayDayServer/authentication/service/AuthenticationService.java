package com.example.PayDayServer.authentication.service;

import com.example.PayDayServer.authentication.entity.UserEntity;
import com.example.PayDayServer.authentication.exception.BadPasswordException;
import com.example.PayDayServer.authentication.exception.PasswordMismatchException;
import com.example.PayDayServer.authentication.exception.UnknownUser;
import com.example.PayDayServer.authentication.exception.UserExistsException;
import com.example.PayDayServer.authentication.model.login.LoginRequest;
import com.example.PayDayServer.authentication.model.login.LoginResponse;
import com.example.PayDayServer.authentication.model.register.RegisterRequest;
import com.example.PayDayServer.authentication.model.register.RegisterResponse;
import com.example.PayDayServer.authentication.repository.UserRepository;
import com.example.PayDayServer.game.gold_operations.models.gold_per_second.PlayerGPSRequest;
import com.example.PayDayServer.game.gold_operations.service.GoldOperationsService;
import com.example.PayDayServer.game.gold_operations.service.PlayerGoldService;
import com.example.PayDayServer.game.plot.entity.PlotEntity;
import com.example.PayDayServer.game.plot.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlotRepository plotRepository;
    @Autowired
    private PasswordValidator passwordValidator;
    public RegisterResponse register(RegisterRequest request) throws UserExistsException, BadPasswordException {
        var user = new UserEntity();
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        
        
        
        var foundUser = userRepository.findByLogin(request.getLogin());
        
        if(foundUser != null) throw new UserExistsException("User already exists");
        
        passwordValidator.isPasswordStrong(request.getPassword());    

        
        
        userRepository.save(user);
        var plot = new PlotEntity(3, 3, user);
        plotRepository.save(plot);
        
        return new RegisterResponse("User created");
    }
    public LoginResponse authenticate(LoginRequest request) throws UnknownUser, PasswordMismatchException {
        var user = userRepository.findByLogin(request.getLogin());
        if(user == null) throw new UnknownUser("User doesn't exists");
        if(!user.getPassword().equals(request.getPassword())) throw new PasswordMismatchException("Invalid password");
        return new LoginResponse(user.getLogin(), user.getGold(), user.getPlots());
    }
}
