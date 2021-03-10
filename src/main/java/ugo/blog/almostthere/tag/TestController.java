package ugo.blog.almostthere.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ugo.blog.almostthere.content.ContentDataForm.ContentForm;
import ugo.blog.almostthere.content.ContentRepository;
import ugo.blog.almostthere.content.ContentService;
import ugo.blog.almostthere.domain.Content;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ContentRepository contentRepository;
    private final ContentService contentService;

    @GetMapping("/content/create")
    public String createForm(){
        return "content/content_create";
    }

    @GetMapping("/content/detail")
    public String content_detail(){
        return "content/content_detail";
    }

    @PostMapping("/content/add2")
    public String addContent(ContentForm contentForm){
        System.out.println("thumb------------------------"+contentForm.getThumbnailImg());
        contentService.addContent(contentForm);
        return "redirect:/";
    }
    @GetMapping("/content/image")
    public String image(Model model){
        Content one = contentRepository.getOne(30L);
        String asd = one.getThumbnailImg();
        model.addAttribute("image",asd);
        return "content/content_image";
    }
}
