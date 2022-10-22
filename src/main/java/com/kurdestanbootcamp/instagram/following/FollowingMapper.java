package com.kurdestanbootcamp.instagram.following;

import com.kurdestanbootcamp.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface FollowingMapper {

    Following toFollowing(FollowingDTO followingDTO);

    FollowingDTO toFollowingDTO(Following following);

    List<FollowingDTO> toFollowingDTOS(List<Following> followings);

    List<Following> toFollowings(List<FollowingDTO> followingDTOS);
}
