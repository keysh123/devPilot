package com.devPilot.backend.Service;

import com.devPilot.backend.Entity.User;
import com.devPilot.backend.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TextEncryptor tokenEncryptor;

    @Transactional(readOnly = true)
    public User requiredById(UUID uuid){
        return userRepository.findById(uuid).orElseThrow(()->new IllegalArgumentException("User Not Found"));
    }

    public String decryptAccessToken(User user){
        return tokenEncryptor.decrypt(user.getAccessToken());
    }

    private static Long toLong(Object value){
        if(value instanceof Number number){
            return number.longValue();
        }
        return Long.parseLong((String.valueOf(value)));
    }
}
