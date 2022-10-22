package com.kurdestanbootcamp.instagram.comment;

import com.kurdestanbootcamp.instagram.post.PostMapper;
import com.kurdestanbootcamp.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PostMapper.class,UserMapper.class})
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);
    CommentDTO toCommentDTO(Comment comment);
    List<Comment> toComment(List<CommentDTO> commentDTOList);
    List<CommentDTO> toCommentDTOS(List<Comment> comments);


}
