package Air.BnB_Backend.service;

import Air.BnB_Backend.entity.AppUser;
import Air.BnB_Backend.paylod.UserDto;
import Air.BnB_Backend.repo.AppUserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    //constructor based injection
    private AppUserRepository userRepository;

    public UserServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

//add user
    @Override
    public UserDto addUser(UserDto userDto) {
        AppUser user = mapToEntity(userDto);
        AppUser savedUser = userRepository.save(user);
        UserDto dto = mapToDto(savedUser);
        return dto;
    }


    UserDto mapToDto(AppUser user){

        UserDto dto = new UserDto();
        dto.setId(user.getId()); // Set the ID from savedUser
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmailId(user.getEmailId());
        //dto.setPassword(user.getPassword());     //not returning the password
        return dto;
    }


    AppUser mapToEntity(UserDto userDto){
        AppUser user = new AppUser();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmailId(userDto.getEmailId());
        user.setPassword(userDto.getPassword());
        return user;
    }




}