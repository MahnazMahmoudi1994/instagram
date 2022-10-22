package com.kurdestanbootcamp.instagram.comment;

import com.kurdestanbootcamp.instagram.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {

    List<Comment> findAll();

}
