package com.kurdestanbootcamp.instagram.comment;

import com.kurdestanbootcamp.instagram.post.PostMapper;
import com.kurdestanbootcamp.instagram.user.UserMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T19:45:37+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Comment toComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentDTO.getId() );
        comment.setVersion( commentDTO.getVersion() );
        comment.setCreatedDate( commentDTO.getCreatedDate() );
        comment.setCreatedBy( commentDTO.getCreatedBy() );
        comment.setLastModifiedDate( commentDTO.getLastModifiedDate() );
        comment.setLastModifiedBy( commentDTO.getLastModifiedBy() );
        comment.setText( commentDTO.getText() );
        comment.setPost( postMapper.toPost( commentDTO.getPost() ) );
        comment.setUser( userMapper.toUser( commentDTO.getUser() ) );

        return comment;
    }

    @Override
    public CommentDTO toCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId( comment.getId() );
        commentDTO.setVersion( comment.getVersion() );
        commentDTO.setCreatedDate( comment.getCreatedDate() );
        commentDTO.setCreatedBy( comment.getCreatedBy() );
        commentDTO.setLastModifiedDate( comment.getLastModifiedDate() );
        commentDTO.setLastModifiedBy( comment.getLastModifiedBy() );
        commentDTO.setText( comment.getText() );
        commentDTO.setPost( postMapper.toPostDTO( comment.getPost() ) );
        commentDTO.setUser( userMapper.toUserDTO( comment.getUser() ) );

        return commentDTO;
    }

    @Override
    public List<Comment> toComment(List<CommentDTO> commentDTOList) {
        if ( commentDTOList == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( commentDTOList.size() );
        for ( CommentDTO commentDTO : commentDTOList ) {
            list.add( toComment( commentDTO ) );
        }

        return list;
    }

    @Override
    public List<CommentDTO> toCommentDTOS(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( toCommentDTO( comment ) );
        }

        return list;
    }
}
