package com.kurdestanbootcamp.instagram.follower;


import com.kurdestanbootcamp.instagram.common.PagingData;
import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import com.kurdestanbootcamp.instagram.following.Following;
import com.kurdestanbootcamp.instagram.following.FollowingDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/follower")
@AllArgsConstructor
public class FollowerController {

    private final IFollowerService followerService;
    private FollowerMapper followerMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FollowerDTO followerDTO){
        Follower follower =followerMapper.toFollower(followerDTO);
        followerService.save(follower);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        followerService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<FollowerDTO> getById(@PathVariable Long id ){
        Follower follower = followerService.getById(id);
        FollowerDTO followerDTO =followerMapper.toFollowerDTO(follower);
        return ResponseEntity.ok(followerDTO);
    }


    @Timed("follower.getAll")
    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<FollowerDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<Follower> followerPage= followerService.paging(page,size);

        int totalPage=  followerPage.getTotalPages();
        List<Follower> data= followerPage.getContent();
        List<FollowerDTO> followerDTOS= followerMapper.toFollowerDTOS(data);

        PagingData<FollowerDTO> pagingData=new PagingData<>(totalPage,page,followerDTOS);


        return ResponseEntity.ok(pagingData);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<FollowerDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){

        List<Follower> followers = followerService.search(searchCriteria);
        List<FollowerDTO> followerDTOS = followerMapper.toFollowerDTOS(followers);
        return ResponseEntity.ok(followerDTOS);
    }


    @GetMapping("/v1/get-all-by-user/{userId}")
    public ResponseEntity<List<FollowerDTO>> getAllByUser(@PathVariable Long userId){
        List<Follower> followers= followerService.getAllByUser(userId);
        List<FollowerDTO> followerDTOS = followerMapper.toFollowerDTOS(followers);

        return ResponseEntity.ok(followerDTOS);
    }

    @GetMapping("/v1/get-all-by-user-with-paging/{userId}/{page}/{size}")
    public ResponseEntity<PagingData<FollowerDTO>> getAllByUser(@PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size){

        Page<Follower> followerPage= followerService.getAllByUser(userId,page,size);

        int totalPage=  followerPage.getTotalPages();
        List<Follower> data= followerPage.getContent();
        List<FollowerDTO> followerDTOS= followerMapper.toFollowerDTOS(data);

        PagingData<FollowerDTO> pagingData=new PagingData<>(totalPage,page,followerDTOS);

        return ResponseEntity.ok(pagingData);
    }

}
