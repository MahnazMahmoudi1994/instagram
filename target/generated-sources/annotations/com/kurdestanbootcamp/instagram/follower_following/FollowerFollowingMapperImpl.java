package com.kurdestanbootcamp.instagram.follower_following;

import com.kurdestanbootcamp.instagram.follower.FollowerMapper;
import com.kurdestanbootcamp.instagram.following.FollowingMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T19:45:38+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class FollowerFollowingMapperImpl implements FollowerFollowingMapper {

    @Autowired
    private FollowerMapper followerMapper;
    @Autowired
    private FollowingMapper followingMapper;

    @Override
    public FollowerFollowing toFollowerFollowing(FollowerFollowingDTO followerFollowingDTO) {
        if ( followerFollowingDTO == null ) {
            return null;
        }

        FollowerFollowing followerFollowing = new FollowerFollowing();

        followerFollowing.setId( followerFollowingDTO.getId() );
        followerFollowing.setVersion( followerFollowingDTO.getVersion() );
        followerFollowing.setCreatedDate( followerFollowingDTO.getCreatedDate() );
        followerFollowing.setCreatedBy( followerFollowingDTO.getCreatedBy() );
        followerFollowing.setLastModifiedDate( followerFollowingDTO.getLastModifiedDate() );
        followerFollowing.setLastModifiedBy( followerFollowingDTO.getLastModifiedBy() );
        followerFollowing.setFollower( followerMapper.toFollower( followerFollowingDTO.getFollower() ) );
        followerFollowing.setFollowing( followingMapper.toFollowing( followerFollowingDTO.getFollowing() ) );

        return followerFollowing;
    }

    @Override
    public FollowerFollowingDTO toFollowerFollowingDTO(FollowerFollowing followerFollowing) {
        if ( followerFollowing == null ) {
            return null;
        }

        FollowerFollowingDTO followerFollowingDTO = new FollowerFollowingDTO();

        followerFollowingDTO.setId( followerFollowing.getId() );
        followerFollowingDTO.setVersion( followerFollowing.getVersion() );
        followerFollowingDTO.setCreatedDate( followerFollowing.getCreatedDate() );
        followerFollowingDTO.setCreatedBy( followerFollowing.getCreatedBy() );
        followerFollowingDTO.setLastModifiedDate( followerFollowing.getLastModifiedDate() );
        followerFollowingDTO.setLastModifiedBy( followerFollowing.getLastModifiedBy() );
        followerFollowingDTO.setFollower( followerMapper.toFollowerDTO( followerFollowing.getFollower() ) );
        followerFollowingDTO.setFollowing( followingMapper.toFollowingDTO( followerFollowing.getFollowing() ) );

        return followerFollowingDTO;
    }

    @Override
    public List<FollowerFollowingDTO> toFollowerFollowingDTOS(List<FollowerFollowing> followerFollowings) {
        if ( followerFollowings == null ) {
            return null;
        }

        List<FollowerFollowingDTO> list = new ArrayList<FollowerFollowingDTO>( followerFollowings.size() );
        for ( FollowerFollowing followerFollowing : followerFollowings ) {
            list.add( toFollowerFollowingDTO( followerFollowing ) );
        }

        return list;
    }

    @Override
    public List<FollowerFollowing> toFollowerFollowings(List<FollowerFollowingDTO> followerFollowingDTOS) {
        if ( followerFollowingDTOS == null ) {
            return null;
        }

        List<FollowerFollowing> list = new ArrayList<FollowerFollowing>( followerFollowingDTOS.size() );
        for ( FollowerFollowingDTO followerFollowingDTO : followerFollowingDTOS ) {
            list.add( toFollowerFollowing( followerFollowingDTO ) );
        }

        return list;
    }
}
