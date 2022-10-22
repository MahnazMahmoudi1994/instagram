package com.kurdestanbootcamp.instagram.like;

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
public class LikeMapperImpl implements LikeMapper {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Like toLike(LikeDTO likeDTO) {
        if ( likeDTO == null ) {
            return null;
        }

        Like like = new Like();

        like.setId( likeDTO.getId() );
        like.setVersion( likeDTO.getVersion() );
        like.setCreatedDate( likeDTO.getCreatedDate() );
        like.setCreatedBy( likeDTO.getCreatedBy() );
        like.setLastModifiedDate( likeDTO.getLastModifiedDate() );
        like.setLastModifiedBy( likeDTO.getLastModifiedBy() );
        like.setPost( postMapper.toPost( likeDTO.getPost() ) );
        like.setUser( userMapper.toUser( likeDTO.getUser() ) );

        return like;
    }

    @Override
    public LikeDTO toLikeDTO(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeDTO likeDTO = new LikeDTO();

        likeDTO.setId( like.getId() );
        likeDTO.setVersion( like.getVersion() );
        likeDTO.setCreatedDate( like.getCreatedDate() );
        likeDTO.setCreatedBy( like.getCreatedBy() );
        likeDTO.setLastModifiedDate( like.getLastModifiedDate() );
        likeDTO.setLastModifiedBy( like.getLastModifiedBy() );
        likeDTO.setPost( postMapper.toPostDTO( like.getPost() ) );
        likeDTO.setUser( userMapper.toUserDTO( like.getUser() ) );

        return likeDTO;
    }

    @Override
    public List<Like> toLikes(List<LikeDTO> likeDTOS) {
        if ( likeDTOS == null ) {
            return null;
        }

        List<Like> list = new ArrayList<Like>( likeDTOS.size() );
        for ( LikeDTO likeDTO : likeDTOS ) {
            list.add( toLike( likeDTO ) );
        }

        return list;
    }

    @Override
    public List<LikeDTO> toLikeDTOS(List<Like> likes) {
        if ( likes == null ) {
            return null;
        }

        List<LikeDTO> list = new ArrayList<LikeDTO>( likes.size() );
        for ( Like like : likes ) {
            list.add( toLikeDTO( like ) );
        }

        return list;
    }
}
