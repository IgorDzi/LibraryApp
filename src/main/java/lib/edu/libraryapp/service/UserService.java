package lib.edu.libraryapp.service;

import lib.edu.libraryapp.controller.dto.user.CreateUserDto;
import lib.edu.libraryapp.controller.dto.user.CreateUserResponseDto;
import lib.edu.libraryapp.controller.dto.user.GetUserDto;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;
import lib.edu.libraryapp.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<GetUserDto> getAll(){
        var users = userRepository.findAll();
        return users.stream().map((userEntity -> new GetUserDto(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getEmail(),
                userEntity.getFullName()
        ))).collect(Collectors.toList());
    }
    public GetUserDto getOne(long id){
        var userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new GetUserDto(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getEmail(),
                userEntity.getFullName());
    }

    public CreateUserResponseDto create(CreateUserDto newUser){
        var userEntity = new UserEntity();
        userEntity.setUsername(newUser.getUsername());
        userEntity.setPassword(newUser.getPassword());
        userEntity.setRole(newUser.getRole());
        userEntity.setEmail(newUser.getEmail());
        userEntity.setFullName(newUser.getFullName());
        var user = userRepository.save(userEntity);
        return new CreateUserResponseDto(user.getId(),user.getUsername(),user.getPassword(),user.getRole(),user.getEmail(),user.getFullName());


    }

    public void delete(long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException();
        }
        userRepository.deleteById(id);
    }



}
