package com.kurdestanbootcamp.instagram.following;


import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import com.kurdestanbootcamp.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFollowingService {
    Following save(Following following);
    void delete(Long id);
    Following getById(Long id);
    Page<Following> paging(Integer page, Integer size);

    List<Following> search(List<SearchCriteria> searchCriteria);

    List<Following> getAllByUser(Long userId);

    Page<Following> getAllByUser(Long userId, Integer page, Integer size);
}
