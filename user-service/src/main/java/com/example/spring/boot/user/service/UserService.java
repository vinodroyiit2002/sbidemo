package com.example.spring.boot.user.service;

import com.example.spring.boot.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    private static List<User> list =new ArrayList<>();
    static{
        list.add(new User ( 12,"ram", "zee"));
        list.add( new User(15,"Vindoram","zeeram"));
        list.add( new User(155,"Vindoramiit","zeeramiit"));
        list.add( new User(165,"roramiit","zeerayymiit"));

    }

    public List<User> getAllUsers(){
        return list;
    }

    public User getUserById(int id){
        User user=null;
        user=list.stream().filter(e->e.getId()==id).findFirst().get();
        return user;

    }
    public User addUser ( User b)
    {
        list.add(b);
        return b;
    }

    public void updateUser( User user, int userid)
    {
        list=list.stream().map(b->{
            if (b.getId()==userid)
            {
                b.setTitle(user.getTitle());
                b.setName(user.getName());
            }
            return b;

        }).collect(Collectors.toList());
    }

}
