package Air.BnB_Backend.controller;


import Air.BnB_Backend.paylod.UserDto;
import Air.BnB_Backend.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/{addUser}")
    public ResponseEntity<UserDto> addUse(@RequestBody UserDto userDto){
       UserDto dto = userService.addUser(userDto);


        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
