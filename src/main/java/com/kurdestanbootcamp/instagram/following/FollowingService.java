package com.kurdestanbootcamp.instagram.following;

import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import com.kurdestanbootcamp.instagram.common.SearchSpecification;
import com.kurdestanbootcamp.instagram.common.exception.NotFoundException;
import com.kurdestanbootcamp.instagram.user.IUserService;
import com.kurdestanbootcamp.instagram.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class FollowingService implements IFollowingService {

    private  final FollowingRepository repository;
    private  final IUserService userService;


    @Override
    public Following save(Following following) {
        Long userId = following.getUser().getId();
        User user = userService.getById(userId);
        following.setUser(user);
        return repository.save(following);
    }


    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Following getById(Long id) {
        Optional<Following> optionalFollowing = repository.findById(id);

        if (!optionalFollowing.isPresent()){

            throw new NotFoundException("Following Not Found");
        }

        return optionalFollowing.get();
    }

    @Override
    public Page<Following> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Following> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Following> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));

        return repository.findAll(searchSpecification);
    }

    @Override
    public List<Following> getAllByUser(Long userId) {
        User user = userService.getById(userId);
        return repository.findAllByUser(user);
    }

    @Override
    public Page<Following> getAllByUser(Long userId, Integer page, Integer size) {
        User user = userService.getById(userId);
        return repository.findAllByUser(user, PageRequest.of(page,size, Sort.by("id").descending()));
    }

}
