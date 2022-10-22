package com.kurdestanbootcamp.instagram.follower;

import com.kurdestanbootcamp.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface FollowerMapper {

    Follower toFollower(FollowerDTO followerDTO);

    FollowerDTO toFollowerDTO(Follower follower);

    List<FollowerDTO> toFollowerDTOS(List<Follower> followers);

    List<Follower> toFollowers(List<FollowerDTO> followerDTOS);
}
