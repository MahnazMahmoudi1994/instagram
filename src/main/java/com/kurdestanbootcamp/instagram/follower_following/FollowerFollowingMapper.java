package com.kurdestanbootcamp.instagram.follower_following;

import com.kurdestanbootcamp.instagram.follower.FollowerMapper;
import com.kurdestanbootcamp.instagram.following.FollowingMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {FollowerMapper.class, FollowingMapper.class})
public interface FollowerFollowingMapper {

    FollowerFollowing toFollowerFollowing(FollowerFollowingDTO followerFollowingDTO);

    FollowerFollowingDTO toFollowerFollowingDTO(FollowerFollowing followerFollowing);

    List<FollowerFollowingDTO> toFollowerFollowingDTOS(List<FollowerFollowing> followerFollowings);

    List<FollowerFollowing> toFollowerFollowings(List<FollowerFollowingDTO> followerFollowingDTOS);
}
