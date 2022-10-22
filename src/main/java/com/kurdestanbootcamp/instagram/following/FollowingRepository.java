package com.kurdestanbootcamp.instagram.following;

import com.kurdestanbootcamp.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepository extends PagingAndSortingRepository<Following, Long>, JpaSpecificationExecutor<Following> {
    Page<Following> findAll(Pageable pageable);

    List<Following> findAllByUser(User user);

    Page<Following> findAllByUser(User user, Pageable pageable);

    List<Following> findAll(Specification<Following> specification);
}
