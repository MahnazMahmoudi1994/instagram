package com.kurdestanbootcamp.instagram.post;

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
public class PostServiceImp implements IPostService {

    private final PostRepository repository;
    private final IUserService service;

    @Override
    public Post save(Post post) {
        Long userId=post.getUser().getId();
        User user=service.getById(userId);
        post.setUser(user);

        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        Long userId = post.getUser().getId();
        User user = service.getById(userId);
        Post lastPost = getById(post.getId());
        lastPost.setText(post.getText());
        lastPost.setUser(user);
        return repository.save(lastPost);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Post getById(Long id) {
        Optional<Post> optionalPost = repository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new NotFoundException("Post Not Found");
        }
        return optionalPost.get();
    }


    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }
}
