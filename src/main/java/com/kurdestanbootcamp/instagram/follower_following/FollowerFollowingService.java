package com.kurdestanbootcamp.instagram.follower_following;


import com.kurdestanbootcamp.instagram.common.exception.NotFoundException;
import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.follower.IFollowerService;
import com.kurdestanbootcamp.instagram.following.Following;
import com.kurdestanbootcamp.instagram.following.IFollowingService;
import com.kurdestanbootcamp.instagram.user.IUserService;
import com.kurdestanbootcamp.instagram.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class FollowerFollowingService implements IFollowerFollowingService {

    private  final FollowerFollowingRepository repository;
    private  final IFollowingService followingService;
    private  final IFollowerService followerService;
    private  final IUserService userService;


    @Override
    public FollowerFollowing save(FollowerFollowing followerFollowing) {

        Long followingId = followerFollowing.getFollowing().getId();
        Long followerId = followerFollowing.getFollower().getId();
        Following following = followingService.getById(followingId);
        Follower follower = followerService.getById(followerId);
        followerFollowing.setFollowing(following);
        followerFollowing.setFollower(follower);
        return repository.save(followerFollowing);
    }

    @Override
    public FollowerFollowing update(FollowerFollowing followerFollowing) {
        FollowerFollowing lastFollowerFollowing = getById(followerFollowing.getId());

        Long followingId = followerFollowing.getFollowing().getId();
        Long followerId = followerFollowing.getFollower().getId();
        Following following = followingService.getById(followingId);
        Follower follower = followerService.getById(followerId);


        lastFollowerFollowing.setFollower(follower);
        lastFollowerFollowing.setFollowing(following);

        return repository.save(lastFollowerFollowing);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public FollowerFollowing getById(Long id) {
        Optional<FollowerFollowing> optionalFollowerFollowing = repository.findById(id);

        if (!optionalFollowerFollowing.isPresent()){

            throw new NotFoundException("FollowerFollowing Not Found");
        }

        return optionalFollowerFollowing.get();
    }

    @Override
    public List<FollowerFollowing> getAll() {
        return (List<FollowerFollowing>) repository.findAll();
    }

    @Override
    public List<FollowerFollowing> getAllByFollower(Long followerId) {
        Follower follower = followerService.getById(followerId);
        return repository.findAllByFollower(follower);
    }

    @Override
    public List<FollowerFollowing> getAllByFollower_User(Long userId) {
        User user = userService.getById(userId);
        return repository.findAllByFollower_User(user);
    }

    @Override
    public List<FollowerFollowing> getAllByFollowing(Long followingId) {
        Following following = followingService.getById(followingId);
        return repository.findAllByFollowing(following);
    }

    @Override
    public List<FollowerFollowing> getAllByFollowing_User(Long userId) {
        User user = userService.getById(userId);
        return repository.findAllByFollowing_User(user);
    }
}
