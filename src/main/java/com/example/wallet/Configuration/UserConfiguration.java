package com.example.wallet.Configuration;

import com.example.wallet.Models.UserEntity;
import com.example.wallet.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            UserEntity musa = new UserEntity(
                    "Musa",
                    "Musa23@gmail.com"
            );
            UserEntity joy = new UserEntity(
                    "Joy",
                    "JoyAyegba8@gmail.com"
            );
            repository.saveAll(
                    List.of(musa, joy)
            );
        };
    }
}
