package com.kurdestanbootcamp.instagram.post;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/post")

public class PostController {
    private final IPostService service;
    private final PostMapper mapper;
    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody PostDTO postDTO){
        Post post =mapper.toPost(postDTO);
        service.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<PostDTO> update(@RequestBody PostDTO postDTO) {
        Post post = mapper.toPost(postDTO);
        service.update(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-by-Id/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Long id) {
        Post post = service.getById(id);
        PostDTO postDTO = mapper.toPostDTO(post);
        return ResponseEntity.ok(postDTO);
    }


    @GetMapping("/v1/all")
    public ResponseEntity<List<PostDTO>> getAll() {
       List<Post> post= service.getAll();
        List<PostDTO> list=mapper.toPostDTOList(post);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.ok().build();
    }

}