package com.kurdestanbootcamp.instagram.comment;

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

public class CommentServiceImp implements ICommentService {
    private final CommentRepository repository;
    private final IPostService postService;

    private final IUserService userService;

    @Override
    public Comment save(Comment comment) {
        Long postId = comment.getPost().getId();
        Long userId=comment.getUser().getId();
        Post post = postService.getById(postId);
        User user=userService.getById(userId);
        comment.setPost(post);
        comment.setUser(user);
        return repository.save(comment);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Comment Not Found");
        }
        return optional.get();
    }

    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }
}
