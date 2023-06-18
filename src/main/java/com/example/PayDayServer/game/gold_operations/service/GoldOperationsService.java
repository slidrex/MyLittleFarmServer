package com.example.PayDayServer.game.gold_operations.service;

import com.example.PayDayServer.authentication.entity.UserEntity;
import com.example.PayDayServer.authentication.repository.UserRepository;
import com.example.PayDayServer.game.gold_operations.exception.NotEnoughGoldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoldOperationsService {
    @Autowired
    private UserRepository userRepository;
    public void trySpendMoney(UserEntity user, Long spendSum) throws NotEnoughGoldException {
        if(user.getGold() < spendSum) throw new NotEnoughGoldException();
        user.setGold(user.getGold() - spendSum);
        userRepository.save(user);
    }
}
