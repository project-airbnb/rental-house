package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.PostRent;
import com.PKHS.airbnb.service.PostRentService;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/post")
public class PostRentController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/image";

    @Autowired
    private PostRentService postRentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private UploadFileService uploadFileService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return this.categoryService.findAll();
    }

    @ModelAttribute("users")
    public Iterable<User> users() {
        return this.userService.findAll();
    }

    @GetMapping
    public String listPostRents(Model model) {
        Iterable<PostRent> postRents = this.postRentService.findAll();
        model.addAttribute("postRents", postRents);
        return "post-rent/list";
    }

    @GetMapping("/view-post/{id}")
    public String viewPostRent(@PathVariable("id") int id, Model model) {
        PostRent postRent = this.postRentService.findById(id);
        model.addAttribute("postRent", postRent);
        return "post-rent/view-post";
    }

    @GetMapping("/delete-post-rent/{id}")
    public String deletePost(@PathVariable("id") int id, RedirectAttributes attributes) {
        if (this.postRentService.findById(id) != null) {
            this.postRentService.remove(id);
            attributes.addFlashAttribute("message", "Delete Successful");
            return "redirect:/post";
        }
        return "redirect:/errors-403";
    }

    @GetMapping("/edit-post-rent/{id}")
    public String editPost(@PathVariable("id") int id, Model model) {
        PostRent post = this.postRentService.findById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "post-rent/edit";
        }
        return "errors-403";
    }

    @PostMapping("/edit-post-rent")
    public String updatePost(@ModelAttribute("post") PostRent post,
                             RedirectAttributes attributes) {
        this.postRentService.save(post);
        attributes.addFlashAttribute("message", "Update post successful");
        return "redirect:/post";
    }

    @GetMapping("/add-post-rent")
    public String addPost(Model model) {
        PostRent post = new PostRent();
        model.addAttribute("post", post);
        return "post-rent/add";
    }

    @PostMapping("/add-post-rent-new")
    public String savePost(@RequestParam("files") MultipartFile[] files,
                           @ModelAttribute("post") PostRent post,
                           RedirectAttributes attributes) {
        List<Image> images = new ArrayList<Image>();
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            String file_name = file.getOriginalFilename();
            String file_link = "image/" + file_name;
            Image image = new Image(file_name, file_link);
            if (file_name != "" && file_name != null ){
                this.uploadFileService.save(image);
                images.add(image);
            }

            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(file.getOriginalFilename());
        }
        if (images.size() >0){
            post.setImages(images);
        }
        this.postRentService.save(post);
        attributes.addFlashAttribute("message", "Create post successfull");
        return "redirect:/post";
    }
}
