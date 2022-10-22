package com.kurdestanbootcamp.instagram.user;

import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IUserService {
    User save(User user);
    User update(User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAll();
    Page<User> paging(Integer page, Integer size);

    User getAllByUsername(String username);

    List<User> search(List<SearchCriteria> searchCriteria);
}
