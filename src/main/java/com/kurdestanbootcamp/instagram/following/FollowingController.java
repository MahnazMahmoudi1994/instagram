package com.kurdestanbootcamp.instagram.following;


import com.kurdestanbootcamp.instagram.common.PagingData;
import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/following")
@AllArgsConstructor
public class FollowingController {

    private final IFollowingService followingService;
    private FollowingMapper followingMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FollowingDTO followingDTO){
        Following following =followingMapper.toFollowing(followingDTO);
        followingService.save(following);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        followingService.delete(id);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<FollowingDTO> getById(@PathVariable Long id ){
        Following following = followingService.getById(id);
        FollowingDTO followingDTO =followingMapper.toFollowingDTO(following);
        return ResponseEntity.ok(followingDTO);
    }


    @Timed("following.getAll")
    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<FollowingDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<Following> followingPage= followingService.paging(page,size);

        int totalPage=  followingPage.getTotalPages();
        List<Following> data= followingPage.getContent();
        List<FollowingDTO> followingDTOS= followingMapper.toFollowingDTOS(data);

        PagingData<FollowingDTO> pagingData=new PagingData<>(totalPage,page,followingDTOS);


        return ResponseEntity.ok(pagingData);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<FollowingDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){

        List<Following> followings = followingService.search(searchCriteria);
        List<FollowingDTO> followingDTOS = followingMapper.toFollowingDTOS(followings);
        return ResponseEntity.ok(followingDTOS);
    }

    @GetMapping("/v1/get-all-by-user/{userId}")
    public ResponseEntity<List<FollowingDTO>> getAllByUser(@PathVariable Long userId){
        List<Following> followings= followingService.getAllByUser(userId);
        List<FollowingDTO> followingDTOS = followingMapper.toFollowingDTOS(followings);

        return ResponseEntity.ok(followingDTOS);
    }

    @GetMapping("/v1/get-all-by-user-with-paging/{userId}/{page}/{size}")
    public ResponseEntity<PagingData<FollowingDTO>> getAllByUser(@PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size){

        Page<Following> followingPage= followingService.getAllByUser(userId,page,size);

        int totalPage=  followingPage.getTotalPages();
        List<Following> data= followingPage.getContent();
        List<FollowingDTO> followingDTOS= followingMapper.toFollowingDTOS(data);

        PagingData<FollowingDTO> pagingData=new PagingData<>(totalPage,page,followingDTOS);

        return ResponseEntity.ok(pagingData);
    }

}
