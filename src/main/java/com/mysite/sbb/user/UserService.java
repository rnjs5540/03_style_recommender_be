package com.mysite.sbb.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setEmail(email);
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();    // 암호화하여 비밀번호 저장
        // BCryptPasswordEncoder 객체를 직접 생성x 빈으로 등록한 PasswordEncoder 객체를 주입받아 사용
        user.setPassword(passwordEncoder.encode(password));
        user.setUsername(username);
        this.userRepository.save(user);
        return user;
    }
}