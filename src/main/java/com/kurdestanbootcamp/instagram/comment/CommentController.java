package com.kurdestanbootcamp.instagram.comment;

import com.kurdestanbootcamp.instagram.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/comment")
public class CommentController {
    private final CommentMapper mapper;
    private final ICommentService service;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CommentDTO commentDTO) {
        Comment comment =mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/get-by-Id/{id}")
    public ResponseEntity<CommentDTO> getById(@PathVariable Long id) {
        Comment comment = service.getById(id);
        CommentDTO commentDTO = mapper.toCommentDTO(comment);
        return ResponseEntity.ok(commentDTO);
    }


    @GetMapping("/v1/getAll")
    public ResponseEntity<List<CommentDTO>> getAll() {

        List<Comment> list = service.getAll();
        List<CommentDTO> postDTOs = mapper.toCommentDTOS(list);
        return ResponseEntity.ok(postDTOs);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.ok().build();


    }
}