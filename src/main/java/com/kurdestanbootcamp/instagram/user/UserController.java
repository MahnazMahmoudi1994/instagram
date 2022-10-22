package com.kurdestanbootcamp.instagram.user;


import com.kurdestanbootcamp.instagram.common.PagingData;
import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.follower.FollowerDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    private UserMapper userMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user =userMapper.toUser(userDTO);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody UserDTO userDTO){
        User user =userMapper.toUser(userDTO);
        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        userService.delete(id);
        return ResponseEntity.ok().build();

    }


    @Timed("user.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User> users= userService.getAll();
        List<UserDTO> userDTOS = userMapper.toUserDTOS(users);

        return ResponseEntity.ok(userDTOS);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id ){
        User user = userService.getById(id);
        UserDTO userDTO =userMapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/v1/get-by-username/{username}")
    public ResponseEntity<UserDTO> getByUsername(@PathVariable String username ){
        User user = userService.getAllByUsername(username);
        UserDTO userDTO =userMapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<UserDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<User> userPage= userService.paging(page,size);

        int totalPage=  userPage.getTotalPages();
        List<User> data= userPage.getContent();
        List<UserDTO> userDTOS= userMapper.toUserDTOS(data);

        PagingData<UserDTO> pagingData=new PagingData<>(totalPage,page,userDTOS);


        return ResponseEntity.ok(pagingData);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<UserDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){

        List<User> users = userService.search(searchCriteria);
        List<UserDTO> userDTOS = userMapper.toUserDTOS(users);
        return ResponseEntity.ok(userDTOS);
    }


}
