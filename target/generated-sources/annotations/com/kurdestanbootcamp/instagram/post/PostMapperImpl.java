package com.kurdestanbootcamp.instagram.post;

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
public class PostMapperImpl implements PostMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Post toPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postDTO.getId() );
        post.setVersion( postDTO.getVersion() );
        post.setCreatedDate( postDTO.getCreatedDate() );
        post.setCreatedBy( postDTO.getCreatedBy() );
        post.setLastModifiedDate( postDTO.getLastModifiedDate() );
        post.setLastModifiedBy( postDTO.getLastModifiedBy() );
        post.setText( postDTO.getText() );
        post.setImage( postDTO.getImage() );
        post.setNumberOfLike( postDTO.getNumberOfLike() );
        post.setNumberOfComment( postDTO.getNumberOfComment() );
        post.setUser( userMapper.toUser( postDTO.getUser() ) );

        return post;
    }

    @Override
    public PostDTO toPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( post.getId() );
        postDTO.setVersion( post.getVersion() );
        postDTO.setCreatedDate( post.getCreatedDate() );
        postDTO.setCreatedBy( post.getCreatedBy() );
        postDTO.setLastModifiedDate( post.getLastModifiedDate() );
        postDTO.setLastModifiedBy( post.getLastModifiedBy() );
        postDTO.setText( post.getText() );
        postDTO.setImage( post.getImage() );
        postDTO.setNumberOfLike( post.getNumberOfLike() );
        postDTO.setNumberOfComment( post.getNumberOfComment() );
        postDTO.setUser( userMapper.toUserDTO( post.getUser() ) );

        return postDTO;
    }

    @Override
    public List<Post> toPostList(List<PostDTO> postDTOS) {
        if ( postDTOS == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( postDTOS.size() );
        for ( PostDTO postDTO : postDTOS ) {
            list.add( toPost( postDTO ) );
        }

        return list;
    }

    @Override
    public List<PostDTO> toPostDTOList(List<Post> listPost) {
        if ( listPost == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( listPost.size() );
        for ( Post post : listPost ) {
            list.add( toPostDTO( post ) );
        }

        return list;
    }
}
