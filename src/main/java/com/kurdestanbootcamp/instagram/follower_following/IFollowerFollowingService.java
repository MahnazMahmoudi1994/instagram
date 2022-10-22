package com.kurdestanbootcamp.instagram.follower_following;


import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.user.User;

import java.util.List;

public interface IFollowerFollowingService {
    FollowerFollowing save(FollowerFollowing followerFollowing);
    FollowerFollowing update(FollowerFollowing followerFollowing);
    void delete(Long id);
    FollowerFollowing getById(Long id);
    List<FollowerFollowing> getAll();

    List<FollowerFollowing> getAllByFollower(Long followerId);


    List<FollowerFollowing> getAllByFollower_User(Long userId);

    List<FollowerFollowing> getAllByFollowing(Long followingId);

    List<FollowerFollowing> getAllByFollowing_User(Long userId);
}
