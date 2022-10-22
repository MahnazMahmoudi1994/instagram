package com.kurdestanbootcamp.instagram.follower_following;


import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.follower.FollowerDTO;
import com.kurdestanbootcamp.instagram.follower.FollowerMapper;
import com.kurdestanbootcamp.instagram.follower.IFollowerService;
import com.kurdestanbootcamp.instagram.following.Following;
import com.kurdestanbootcamp.instagram.following.FollowingDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/follower-following/")
@AllArgsConstructor
public class FollowerFollowingController {

    private final IFollowerFollowingService followerFollowingService;
    private FollowerFollowingMapper followerFollowingMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FollowerFollowingDTO followerFollowingDTO){
        FollowerFollowing followerFollowing =followerFollowingMapper.toFollowerFollowing(followerFollowingDTO);
        followerFollowingService.save(followerFollowing);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody FollowerFollowingDTO followerFollowingDTO){
        FollowerFollowing followerFollowing =followerFollowingMapper.toFollowerFollowing(followerFollowingDTO);
        followerFollowingService.update(followerFollowing);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<FollowerFollowingDTO> getById(@PathVariable Long id ){
        FollowerFollowing followerFollowing = followerFollowingService.getById(id);
        FollowerFollowingDTO followerFollowingDTO =followerFollowingMapper.toFollowerFollowingDTO(followerFollowing);
        return ResponseEntity.ok(followerFollowingDTO);
    }


    @Timed("followerFollowing.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<FollowerFollowingDTO>> getAll(){
        List<FollowerFollowing> followerFollowings = followerFollowingService.getAll();
        List<FollowerFollowingDTO> followerFollowingDTOS = followerFollowingMapper.toFollowerFollowingDTOS(followerFollowings);

        return ResponseEntity.ok(followerFollowingDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        followerFollowingService.delete(id);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/get-all-by-following/{followingId}")
    public ResponseEntity<List<FollowerFollowingDTO>> getAllByFollowing(@PathVariable Long followingId){
        List<FollowerFollowing> followerFollowings= followerFollowingService.getAllByFollowing(followingId);
        List<FollowerFollowingDTO> followerFollowingDTOS = followerFollowingMapper.toFollowerFollowingDTOS(followerFollowings);

        return ResponseEntity.ok(followerFollowingDTOS);
    }

    @GetMapping("/v1/get-all-by-follower/{followerId}")
    public ResponseEntity<List<FollowerFollowingDTO>> getAllByFollower(@PathVariable Long followerId){
        List<FollowerFollowing> followerFollowings= followerFollowingService.getAllByFollower(followerId);
        List<FollowerFollowingDTO> followerFollowingDTOS = followerFollowingMapper.toFollowerFollowingDTOS(followerFollowings);

        return ResponseEntity.ok(followerFollowingDTOS);
    }

    @GetMapping("/v1/get-all-by-follower-user/{userId}")
    public ResponseEntity<List<FollowerFollowingDTO>> getAllByFollowerUser(@PathVariable Long userId){
        List<FollowerFollowing> followerFollowings= followerFollowingService.getAllByFollower_User(userId);
        List<FollowerFollowingDTO> followerFollowingDTOS = followerFollowingMapper.toFollowerFollowingDTOS(followerFollowings);

        return ResponseEntity.ok(followerFollowingDTOS);
    }

    @GetMapping("/v1/get-all-by-following-user/{userId}")
    public ResponseEntity<List<FollowerFollowingDTO>> getAllByFollowingUser(@PathVariable Long userId){
        List<FollowerFollowing> followerFollowings= followerFollowingService.getAllByFollowing_User(userId);
        List<FollowerFollowingDTO> followerFollowingDTOS = followerFollowingMapper.toFollowerFollowingDTOS(followerFollowings);

        return ResponseEntity.ok(followerFollowingDTOS);
    }
}
