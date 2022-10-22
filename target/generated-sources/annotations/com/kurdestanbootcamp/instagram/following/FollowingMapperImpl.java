package com.kurdestanbootcamp.instagram.following;

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
public class FollowingMapperImpl implements FollowingMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Following toFollowing(FollowingDTO followingDTO) {
        if ( followingDTO == null ) {
            return null;
        }

        Following following = new Following();

        following.setId( followingDTO.getId() );
        following.setVersion( followingDTO.getVersion() );
        following.setCreatedDate( followingDTO.getCreatedDate() );
        following.setCreatedBy( followingDTO.getCreatedBy() );
        following.setLastModifiedDate( followingDTO.getLastModifiedDate() );
        following.setLastModifiedBy( followingDTO.getLastModifiedBy() );
        following.setUser( userMapper.toUser( followingDTO.getUser() ) );

        return following;
    }

    @Override
    public FollowingDTO toFollowingDTO(Following following) {
        if ( following == null ) {
            return null;
        }

        FollowingDTO followingDTO = new FollowingDTO();

        followingDTO.setId( following.getId() );
        followingDTO.setVersion( following.getVersion() );
        followingDTO.setCreatedDate( following.getCreatedDate() );
        followingDTO.setCreatedBy( following.getCreatedBy() );
        followingDTO.setLastModifiedDate( following.getLastModifiedDate() );
        followingDTO.setLastModifiedBy( following.getLastModifiedBy() );
        followingDTO.setUser( userMapper.toUserDTO( following.getUser() ) );

        return followingDTO;
    }

    @Override
    public List<FollowingDTO> toFollowingDTOS(List<Following> followings) {
        if ( followings == null ) {
            return null;
        }

        List<FollowingDTO> list = new ArrayList<FollowingDTO>( followings.size() );
        for ( Following following : followings ) {
            list.add( toFollowingDTO( following ) );
        }

        return list;
    }

    @Override
    public List<Following> toFollowings(List<FollowingDTO> followingDTOS) {
        if ( followingDTOS == null ) {
            return null;
        }

        List<Following> list = new ArrayList<Following>( followingDTOS.size() );
        for ( FollowingDTO followingDTO : followingDTOS ) {
            list.add( toFollowing( followingDTO ) );
        }

        return list;
    }
}
