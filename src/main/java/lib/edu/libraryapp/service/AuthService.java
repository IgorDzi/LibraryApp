package lib.edu.libraryapp.service;


import lib.edu.libraryapp.controller.dto.auth.LoginDto;
import lib.edu.libraryapp.controller.dto.auth.LoginResponseDto;
import lib.edu.libraryapp.controller.dto.auth.RegisterDto;
import lib.edu.libraryapp.controller.dto.auth.RegisterResponseDto;
import lib.edu.libraryapp.infrastructure.entity.AuthEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;
import lib.edu.libraryapp.infrastructure.repository.AuthRepository;
import lib.edu.libraryapp.infrastructure.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final AuthRepository authRepository;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public RegisterResponseDto register(RegisterDto registerDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerDto.getEmail());
        userRepository.save(userEntity);

        AuthEntity authEntity = new AuthEntity();
        authEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        authEntity.setUsername(registerDto.getUsername());
        authEntity.setRole(registerDto.getRole());
        authEntity.setUser(userEntity);

       authRepository.save(authEntity);
        return new RegisterResponseDto(authEntity.getUsername(), authEntity.getRole(), userEntity.getEmail(), userEntity.getId());
    }

    public LoginResponseDto login(LoginDto loginDto) {
        AuthEntity authEntity = authRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginDto.getPassword(), authEntity.getPassword())) {
            throw new RuntimeException();}

            String token = jwtService.generateToken(authEntity);
            return new LoginResponseDto(token);
        }
    }

