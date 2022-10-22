package com.kurdestanbootcamp.instagram.like;


import com.kurdestanbootcamp.instagram.comment.Comment;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ILikeService {

    Like Save(Like like);
    void delete(Long id);
    Like getById(Long id);
    List<Like> getAll();

    Page<Like> getByUser(Integer page,Integer size,Long userAppId);

}
