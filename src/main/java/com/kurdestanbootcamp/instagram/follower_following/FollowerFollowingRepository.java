package com.kurdestanbootcamp.instagram.follower_following;

import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.following.Following;
import com.kurdestanbootcamp.instagram.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerFollowingRepository extends PagingAndSortingRepository<FollowerFollowing, Long> {

    List<FollowerFollowing> findAllByFollower(Follower follower);

    List<FollowerFollowing> findAllByFollower_User(User user);

    List<FollowerFollowing> findAllByFollowing(Following following);

    List<FollowerFollowing> findAllByFollowing_User(User user);
}
