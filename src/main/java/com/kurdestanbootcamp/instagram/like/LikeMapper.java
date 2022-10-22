package com.kurdestanbootcamp.instagram.like;

import com.kurdestanbootcamp.instagram.post.PostMapper;
import com.kurdestanbootcamp.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PostMapper.class, UserMapper.class})
public interface LikeMapper {
    Like toLike(LikeDTO likeDTO);
    LikeDTO toLikeDTO(Like like);
    List<Like> toLikes(List<LikeDTO> likeDTOS);
    List<LikeDTO> toLikeDTOS(List<Like> likes);

}
