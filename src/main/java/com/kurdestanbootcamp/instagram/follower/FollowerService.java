package com.kurdestanbootcamp.instagram.follower;


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
public class FollowerService implements IFollowerService{

    private  final FollowerRepository repository;
    private  final IUserService userService;


    @Override
    public Follower save(Follower follower) {
        Long userId = follower.getUser().getId();
        User user = userService.getById(userId);
        follower.setUser(user);
        return repository.save(follower);
    }


    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Follower getById(Long id) {
        Optional<Follower> optionalFollower = repository.findById(id);

        if (!optionalFollower.isPresent()){

            throw new NotFoundException("Follower Not Found");
        }

        return optionalFollower.get();
    }

    @Override
    public Page<Follower> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Follower> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Follower> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));

        return repository.findAll(searchSpecification);
    }

    @Override
    public List<Follower> getAllByUser(Long userId) {
        User user = userService.getById(userId);
        return repository.findAllByUser(user);
    }

    @Override
    public Page<Follower> getAllByUser(Long userId, Integer page, Integer size) {
        User user = userService.getById(userId);
        return repository.findAllByUser(user, PageRequest.of(page,size, Sort.by("id").descending()));
    }

}
