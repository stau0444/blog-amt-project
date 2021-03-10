package ugo.blog.almostthere.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import ugo.blog.almostthere.content.ContentRepository;
import ugo.blog.almostthere.content.ContentService;
import ugo.blog.almostthere.tag.TagRepository;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final ContentRepository contentRepository;
    private final TagRepository tagRepository;
    private final ContentService contentService;


}
