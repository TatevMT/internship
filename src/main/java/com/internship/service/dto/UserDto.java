package com.internship.service.dto;

import com.internship.persistence.entity.CommunityEntity;
import com.internship.persistence.entity.UserCommunityEntity;
import com.internship.persistence.entity.UserEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String status;
    private String address;
    private List<String> communities;

    public UserDto() {
    }

    public UserDto(Long id,
                   String firstName,
                   String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCommunities() {
        return communities;
    }

    public void setCommunities(List<String> communities) {
        this.communities = communities;
    }

    public static UserDto mapEntityToDo(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setStatus(entity.getStatus());
        dto.setAddress(entity.getUserDetail() == null ? null : entity.getUserDetail().getAddress());
        List<UserCommunityEntity> listOfUserCommunities = entity.getListOfUserCommunities();
        if (!CollectionUtils.isEmpty(listOfUserCommunities)) {
            dto.setCommunities(listOfUserCommunities.stream().map(UserCommunityEntity::getCommunity)
                    .map(CommunityEntity::getName).collect(Collectors.toList()));
        }
        return dto;
    }
}