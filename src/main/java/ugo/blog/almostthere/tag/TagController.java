package ugo.blog.almostthere.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ugo.blog.almostthere.domain.Tag;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagRepository tagRepository;


    @GetMapping("/api/tag")
    public List<String> getTags(){
        List<Tag> tagList = tagRepository.findAll();
        List<String> collect = tagList.stream().map(t -> t.getTagName()).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
        return collect;
    }

    @PostMapping("/api/tag/add")
    public void addTag(String tagName){
        System.out.println(tagName);
        Tag tag = new Tag(tagName);
        tagRepository.save(tag);
    }

}
