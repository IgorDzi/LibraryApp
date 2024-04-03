package lib.edu.libraryapp.service.user;


import lib.edu.libraryapp.controller.dto.user.GetUserDto;
import lib.edu.libraryapp.infrastructure.repository.UserRepository;
import lib.edu.libraryapp.service.user.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
                userEntity.getEmail(),
                userEntity.getFullName()
        ))).collect(Collectors.toList());
    }
    public GetUserDto getOne(long id){
        var userEntity = userRepository.findById(id).orElseThrow(() -> UserNotFoundException.create(id));
        return new GetUserDto(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFullName());
    }

    public void delete(long id){
        if(!userRepository.existsById(id)){
            throw UserNotFoundException.create(id);
        }
        userRepository.deleteById(id);
    }
}
