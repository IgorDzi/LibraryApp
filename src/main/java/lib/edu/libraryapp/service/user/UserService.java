package lib.edu.libraryapp.service.user;


import lib.edu.libraryapp.controller.dto.user.GetUserDto;
import lib.edu.libraryapp.infrastructure.repository.AuthRepository;
import lib.edu.libraryapp.infrastructure.repository.UserRepository;
import lib.edu.libraryapp.service.user.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type User service.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     * @param authRepository the auth repository
     */
    @Autowired
    public UserService(UserRepository userRepository, AuthRepository authRepository) {
        this.userRepository = userRepository;
        this.authRepository = authRepository;
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<GetUserDto> getAll(){
        var users = userRepository.findAll();
        return users.stream().map((userEntity -> new GetUserDto(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFullName()
        ))).collect(Collectors.toList());
    }

    /**
     * Get one get user dto.
     *
     * @param id the id
     * @return the get user dto
     */
    public GetUserDto getOne(long id){
        var userEntity = userRepository.findById(id).orElseThrow(() -> UserNotFoundException.create(id));
        return new GetUserDto(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFullName());
    }

    /**
     * Get by username get user dto.
     *
     * @param username the username
     * @return the get user dto
     */
    public GetUserDto getByUsername(String username){
        var user = authRepository.findByUsername(username).orElseThrow(() -> UserNotFoundException.create(username));
        var userEntity = user.getUser();
        return new GetUserDto(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFullName()
        );
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(long id){
        if(!userRepository.existsById(id)){
            throw UserNotFoundException.create(id);
        }
        userRepository.deleteById(id);
    }
}
