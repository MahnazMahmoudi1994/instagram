package com.kurdestanbootcamp.instagram.like;

import com.kurdestanbootcamp.instagram.follower.Follower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends PagingAndSortingRepository<Like, Long> {

    List<Like> findAll();

    Page<Like> findAllByUser_Id(Pageable pageable,Long userId);


}
