package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.model.Post;
import org.academiadecodigo.bootcamp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {

    private AuthService authService;
    private List<Post> postList;

    public FeedService(){
        postList = new ArrayList<>();

    }

    public List<Post> getPostList(){
        return postList;
    }

    public void addPost(Post post){
        postList.add(post);
        authService.getAccessingUser().addPost(post);

    }
    public void removePost(Post post){
        postList.remove(post);
        authService.getAccessingUser().removePost(post);
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
