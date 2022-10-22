package com.kurdestanbootcamp.instagram.like;


import com.kurdestanbootcamp.instagram.common.exception.NotFoundException;
import com.kurdestanbootcamp.instagram.post.IPostService;
import com.kurdestanbootcamp.instagram.post.Post;
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

public class LikeServiceImp implements ILikeService{

    private final LikeRepository repository;

    private final IUserService userService;
    private final IPostService postService;


    @Override
    public Like Save(Like like) {
        Long userId=like.getUser().getId();
        Long postId=like.getPost().getId();
        User user=userService.getById(userId);
        Post post=postService.getById(postId);
        like.setUser(user);
        like.setPost(post);
        return repository.save(like);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Like getById(Long id) {
        Optional<Like> likeOptional=repository.findById(id);
        if(likeOptional.isEmpty()){
            throw new NotFoundException("NOT FOUND LIKE");
        }
        return likeOptional.get();
    }

    @Override
    public List<Like> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Like> getByUser(Integer page, Integer size, Long userId) {
        return repository.findAllByUser_Id(PageRequest.of(page,size),userId);
    }


}
