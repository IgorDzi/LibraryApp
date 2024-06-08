package lib.edu.libraryapp.service.auth;


import lib.edu.libraryapp.controller.dto.auth.*;
import lib.edu.libraryapp.infrastructure.entity.AuthEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;
import lib.edu.libraryapp.infrastructure.repository.AuthRepository;
import lib.edu.libraryapp.infrastructure.repository.UserRepository;
import lib.edu.libraryapp.service.auth.error.UserAlreadyExistsException;
import lib.edu.libraryapp.service.auth.error.WrongUsernameOrPasswordException;
import lib.edu.libraryapp.service.user.error.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return new RegisterResponseDto(authEntity.getUsername(), authEntity.getRole(), userEntity.getEmail(), userEntity.getFullName(), userEntity.getId());
    }

    /**
     * Update password update password response dto.
     *
     * @param updateForm the update form
     * @return the update password response dto
     */
    @Transactional
    public UpdatePasswordResponseDto updatePassword(UpdatePasswordDto updateForm){
        AuthEntity user = authRepository.findByUsername(updateForm.getUsername()).orElseThrow(()->UserNotFoundException.create(updateForm.getUsername()));
        user.setPassword(passwordEncoder.encode(updateForm.getPassword()));
        authRepository.save(user);
        return new UpdatePasswordResponseDto(user.getUsername(), true);
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

    /**
     * Get role string.
     *
     * @param username the username
     * @return the string
     */
    public String getRole(String username) {
        AuthEntity authEntity = authRepository.findByUsername(username).orElseThrow(() -> UserNotFoundException.create(username));
        return authEntity.getRole().toString();
    }

    public String getUsername(long userId) {
        UserEntity user =  userRepository.findById(userId).orElseThrow(()->UserNotFoundException.create(userId));
        AuthEntity authEntity = authRepository.findByUser(user).orElseThrow(()->UserNotFoundException.create(userId));
        return authEntity.getUsername();
    }

    public String getRoleById(long userId) {
        UserEntity user =  userRepository.findById(userId).orElseThrow(()->UserNotFoundException.create(userId));
        AuthEntity authEntity = authRepository.findByUser(user).orElseThrow(()->UserNotFoundException.create(userId));
        return authEntity.getRole().toString();
    }
}


