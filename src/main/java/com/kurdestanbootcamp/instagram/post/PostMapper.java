package com.kurdestanbootcamp.instagram.post;


import com.kurdestanbootcamp.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})

public interface PostMapper {

    Post toPost(PostDTO postDTO);
    PostDTO toPostDTO(Post post);
    List<Post> toPostList(List<PostDTO> postDTOS);
    List<PostDTO> toPostDTOList(List<Post> listPost);


}
