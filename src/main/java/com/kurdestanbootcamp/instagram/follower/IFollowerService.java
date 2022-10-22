package com.kurdestanbootcamp.instagram.follower;

import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IFollowerService {
    Follower save(Follower follower);
    void delete(Long id);
    Follower getById(Long id);

    Page<Follower> paging(Integer page, Integer size);

    List<Follower> search(List<SearchCriteria> searchCriteria);

    List<Follower> getAllByUser(Long userId);

    Page<Follower> getAllByUser(Long userId, Integer page, Integer size);
}
