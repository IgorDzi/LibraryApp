package lib.edu.libraryapp.service.auth;


import lib.edu.libraryapp.controller.dto.auth.LoginDto;
import lib.edu.libraryapp.controller.dto.auth.LoginResponseDto;
import lib.edu.libraryapp.controller.dto.auth.RegisterDto;
import lib.edu.libraryapp.controller.dto.auth.RegisterResponseDto;
import lib.edu.libraryapp.controller.dto.user.GetUserDto;
import lib.edu.libraryapp.infrastructure.entity.AuthEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;
import lib.edu.libraryapp.infrastructure.repository.AuthRepository;
import lib.edu.libraryapp.infrastructure.repository.UserRepository;
import lib.edu.libraryapp.service.auth.error.UserAlreadyExistsException;
import lib.edu.libraryapp.service.auth.error.WrongUsernameOrPasswordException;
import lib.edu.libraryapp.service.user.error.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * The type Auth service.
 */
@Service
public class AuthService {

    private final AuthRepository authRepository;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;


    /**
     * Instantiates a new Auth service.
     *
     * @param authRepository  the auth repository
     * @param userRepository  the user repository
     * @param jwtService      the jwt service
     * @param passwordEncoder the password encoder
     */
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Register register response dto.
     *
     * @param registerDto the register dto
     * @return the register response dto
     */
    public RegisterResponseDto register(RegisterDto registerDto){
        Optional<AuthEntity> existingAuth = authRepository.findByUsername(registerDto.getUsername());
        if (existingAuth.isPresent()) {
            throw UserAlreadyExistsException.create(registerDto.getUsername());
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerDto.getEmail());
        userEntity.setFullName(registerDto.getFullName());
        userRepository.save(userEntity);

        AuthEntity authEntity = new AuthEntity();
        authEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        authEntity.setUsername(registerDto.getUsername());
        authEntity.setRole(registerDto.getRole());
        authEntity.setUser(userEntity);

       authRepository.save(authEntity);
        return new RegisterResponseDto(authEntity.getUsername(), authEntity.getRole(), userEntity.getEmail(), userEntity.getId());
    }

    /**
     * Login login response dto.
     *
     * @param loginDto the login dto
     * @return the login response dto
     */
    public LoginResponseDto login(LoginDto loginDto) {
        AuthEntity authEntity = authRepository.findByUsername(loginDto.getUsername()).orElseThrow(WrongUsernameOrPasswordException::create);

        if (!passwordEncoder.matches(loginDto.getPassword(), authEntity.getPassword())) {
            throw WrongUsernameOrPasswordException.create();
        }

            String token = jwtService.generateToken(authEntity);
            return new LoginResponseDto(token);
        }

    }

