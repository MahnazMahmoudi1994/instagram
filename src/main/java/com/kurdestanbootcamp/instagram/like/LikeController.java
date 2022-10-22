package com.kurdestanbootcamp.instagram.like;

import com.kurdestanbootcamp.instagram.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/like/")
public class LikeController {
    private final ILikeService service;
    private final LikeMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<LikeDTO> save(@RequestBody LikeDTO likeDTO){
        Like like=mapper.toLike(likeDTO);
        service.Save(like);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/filter-by-user/{page}/{size}/{userId}")
    public ResponseEntity<PagingData<LikeDTO>> getByUsers(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long userId){
        Page<Like> likePage=service.getByUser(page,size,userId);
        int total=likePage.getTotalPages();

        List<Like> likeList=likePage.getContent();
        List<LikeDTO> likeDTOS=mapper.toLikeDTOS(likeList);

        PagingData<LikeDTO> likeDTOPagingData=new PagingData<>(total,page,likeDTOS);
        return ResponseEntity.ok(likeDTOPagingData);
    }

    @DeleteMapping("v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<LikeDTO> getById(@PathVariable Long id){
        Like like= service.getById(id);
        LikeDTO likeDTO=mapper.toLikeDTO(like);
        return ResponseEntity.ok(likeDTO);
    }

    @GetMapping("/v1/all")
    public ResponseEntity<List<LikeDTO>> getAll() {
        List<Like> list = service.getAll();
        List<LikeDTO> likeDTOS = mapper.toLikeDTOS(list);
        return ResponseEntity.ok(likeDTOS);
    }


}
