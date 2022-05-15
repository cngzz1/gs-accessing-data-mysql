package com.example.accessingdatamysql.service;

import org.modelmapper.ModelMapper;
import com.example.accessingdatamysql.User;
import com.example.accessingdatamysql.UserDto;
import com.example.accessingdatamysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class MapService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    public UserDto getUserLocation(Integer id) {
        return convertToUserLocationDTO(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
    }

    public List<UserDto> getAllUsersLocation() {
        List<UserDto> list = new ArrayList<>();
        for (User<?> user : userRepository.findAll()) {
            UserDto userDto = convertToUserLocationDTO(user);
            list.add(userDto);
        }
        return list;
    }

    private UserDto convertToUserLocationDTO(User<?> user) {
        UserDto userLocationDTO = new UserDto(user.getId());
        userLocationDTO.setName(user.getName());
        userLocationDTO.setEmail(user.getEmail());
        return userLocationDTO;
    }

}
