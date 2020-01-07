package kamenev.controller;

import kamenev.model.Post;
import kamenev.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value = "/posts")
@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allPosts() {
            List<Post> posts = postService.allPosts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("posts");
        modelAndView.addObject("postList", posts);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        Post post = postService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPost");
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editPost(@ModelAttribute("post") Post post) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/"); //redirect to "/" page
        postService.update(post);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPost");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addPost(@ModelAttribute("post") Post post) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        postService.create(post);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deletePost(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Post post = postService.getById(id);
        postService.delete(post);
        return modelAndView;
    }
}
