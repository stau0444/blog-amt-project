package ugo.blog.almostthere.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ugo.blog.almostthere.content.ContentRepository;
import ugo.blog.almostthere.domain.Content;
import ugo.blog.almostthere.domain.Tag;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final ContentRepository contentRepository;

    public void removeTag(TagForm tagForm) {
        Tag tag = tagRepository.findTagByTagName(tagForm.getTagTitle());
        Optional<Content> byId = contentRepository.findById(1L);
        byId.ifPresent(c -> c.getTags().remove(tag));
    }

    public void addTags(TagForm tagForm) {
        Tag tag = new Tag(tagForm.getTagTitle());
        tagRepository.save(tag);
        Optional<Content> byId = contentRepository.findById(1L);
        byId.ifPresent(c -> c.getTags().add(tag));
    }
}
