package ugo.blog.almostthere.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ugo.blog.almostthere.content.ContentRepository;
import ugo.blog.almostthere.content.ContentService;
import ugo.blog.almostthere.domain.Content;
import ugo.blog.almostthere.domain.ContentSort;
import ugo.blog.almostthere.domain.Tag;
import ugo.blog.almostthere.tag.TagRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final ContentRepository contentRepository;
    private final TagRepository tagRepository;
    private final ContentService contentService;

    @Bean
    @Profile("dev")
    public void insertTestData(){
        Set<Tag> tags = new HashSet<>();
        Tag tag;
        for (int i =0 ; i<4; i++){
            tag = new Tag();
            tag.setTagName("asd"+i);
            tagRepository.save(tag);
            Tag tagByTagName = tagRepository.findTagByTagName("asd" + i);
            tags.add(tagByTagName);
        }
        for (int i = 0 ; i <50; i++){
            Content content = new Content();
            content.setContent("The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform. Wikipedia"+i);
            content.setAuthor("testAuthor"+i);
            content.setCreated_date(LocalDateTime.now());
            content.setTags(tags);
            content.setTitle("S2:E5 - COVID Tracking Project, Apple’s Reduced App Store Commission, Tesla Security Flaws, and Twitter Fleets"+i);
            content.setThumbnailImg("https://cdn.pixabay.com/photo/2021/02/08/16/03/dinosaur-5995333_1280.png");
            content.setView_count(i);
            if(i%2==0){
                content.setContentSort(ContentSort.SUMMARY);
            }else{
                content.setContentSort(ContentSort.NEWS);
            }
            contentRepository.save(content);
        }

    }


}
