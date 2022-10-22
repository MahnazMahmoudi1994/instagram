package com.kurdestanbootcamp.instagram.user;

import com.kurdestanbootcamp.instagram.common.SearchCriteria;
import com.kurdestanbootcamp.instagram.common.SearchSpecification;
import com.kurdestanbootcamp.instagram.common.exception.ConflictException;
import com.kurdestanbootcamp.instagram.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private  final UserRepository repository;


    @Override
    public User save(User user) {
        List<User> users = getAll();
        for(User user1:users){
            if(user1.getPhoneNumber().equals(user.getPhoneNumber())){
                throw new ConflictException("This phone number is already registered");
            }

            if ((user1.getUsername().equals(user.getUsername())) &&
                    (user1.getPassword().equals(user.getPassword()))){
                throw new ConflictException("This is has already been registered");
            }
        }
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User lastUser = getById(user.getId());
        List<User> users = getAll();
        for(User user1:users){
            if(user1.getPhoneNumber().equals(user.getPhoneNumber())){
                if(user1.getId() == user.getId()){
                    continue;
                }
                throw new ConflictException("This phone number is already registered");
            }

            if ((user1.getUsername().equals(user.getUsername())) &&
                    (user1.getPassword().equals(user.getPassword()))){
                if(user1.getId() == user.getId()){
                    continue;
                }
                throw new ConflictException("This is has already been registered");
            }

        }

        lastUser.setFullName(user.getFullName());
        lastUser.setUsername(user.getUsername());
        lastUser.setPassword(user.getPassword());
        lastUser.setPhoneNumber(user.getPhoneNumber());
        lastUser.setProfilePhoto(user.getProfilePhoto());
        lastUser.setBio(user.getBio());
        lastUser.setEmail(user.getEmail());
        lastUser.setGender(user.getGender());


        return repository.save(lastUser);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser = repository.findById(id);

        if (!optionalUser.isPresent()){

            throw new NotFoundException("User Not Found");
        }

        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Page<User> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public User getAllByUsername(String username) {
        return repository.findAllByUsername(username);
    }

    @Override
    public List<User> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<User> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));

        return repository.findAll(searchSpecification);
    }
}
