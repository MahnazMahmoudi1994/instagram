package com.kurdestanbootcamp.instagram.comment;


import com.kurdestanbootcamp.instagram.post.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICommentService {

    Comment save(Comment comment);
    void delete(Long id);
    Comment getById(Long id);

    List<Comment> getAll();




}
