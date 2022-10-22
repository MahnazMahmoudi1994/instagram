package com.kurdestanbootcamp.instagram.follower;

import com.kurdestanbootcamp.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends PagingAndSortingRepository<Follower, Long>, JpaSpecificationExecutor<Follower> {

    Page<Follower> findAll(Pageable pageable);

    List<Follower> findAllByUser(User user);

    Page<Follower> findAllByUser(User user, Pageable pageable);

    List<Follower> findAll(Specification<Follower> specification);
}
