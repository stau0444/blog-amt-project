package ugo.blog.almostthere.content;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ugo.blog.almostthere.content.ContentDataForm.ContentDetailForm;
import ugo.blog.almostthere.content.ContentDataForm.ContentForm;
import ugo.blog.almostthere.domain.Content;
import ugo.blog.almostthere.domain.ContentSort;
import ugo.blog.almostthere.domain.Tag;
import ugo.blog.almostthere.tag.TagRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService{


    private final ContentRepository contentRepository;
    private final TagRepository tagRepository;
    //static final Map<String,Long> requestIpList = new HashMap<>();

    public void addContent(ContentForm contentForm) {
        Set<Tag> tags = setTagNameToTag(contentForm);

        ContentSort sort = defineContentSort(contentForm);

        Content newContent = Content.builder()
                .title(contentForm.getTitle())
                .author(contentForm.getAuthor())
                .thumbnailImg(contentForm.getThumbnailImg())
                .contentSort(sort)
                .tags(tags)
                .content(contentForm.getContent())
                .created_date(LocalDateTime.now())
                .build();
        
        tags.stream().forEach(tag -> tag.getContents().add(newContent));
        contentRepository.save(newContent);
    }

    private Set<Tag> setTagNameToTag(ContentForm contentForm) {
        Set<Tag> tags = new HashSet<>();
        List<String> tagNames = contentForm.getTagName();
        for (String  tagName: tagNames) {
            Tag tag = tagRepository.findTagByTagName(tagName);
            if(tag == null){
                Tag newTag = new Tag(tagName);
                tagRepository.save(newTag);
                tags.add(newTag);
            }
            tags.add(tag);
        }
        return tags;
    }

    private ContentSort defineContentSort(ContentForm contentForm) {
        String contentSort = contentForm.getContentSort();
        ContentSort sort ;
        if(contentSort.equals("NEWS")){
            sort = ContentSort.NEWS;
        }else {
            sort = ContentSort.SUMMARY;
        }
        return sort;
    }

    public ContentDetailForm getContentDetail(Long content_id) {
        Optional<Content> byId = contentRepository.findById(content_id);

        ContentDetailForm contentDetailForm = new ContentDetailForm();

        byId.ifPresent(content -> {
            //Todo 조회수 증가 제한 (수정 필요)
            content.setView_count(content.getView_count()+1);

            contentDetailForm.setView_count(content.getView_count());
            contentDetailForm.setTitle(content.getTitle());
            contentDetailForm.setContent(content.getContent());
            contentDetailForm.setAuthor(content.getAuthor());
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.SHORT);
            String format = formatter.format(content.getCreated_date());
            contentDetailForm.setCreated_date(format);
            contentDetailForm.setTags(content.getTags());
        });
            return contentDetailForm;
    }

    public List<ContentDetailForm> getContentList(Page<Content> pageList) {

        List<ContentDetailForm> collect = pageList.stream().map(
                content -> {
                    ContentDetailForm contentDetailForm = new ContentDetailForm();
                    contentDetailForm.setId(content.getId());
                    contentDetailForm.setTitle(content.getTitle());
                    contentDetailForm.setContent(content.getContent());
                    contentDetailForm.setView_count(content.getView_count());
                    contentDetailForm.setAuthor(content.getAuthor());
                    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.SHORT);
                    String format = formatter.format(content.getCreated_date());
                    contentDetailForm.setCreated_date(format);
                    contentDetailForm.setTags(content.getTags());
                    contentDetailForm.setThumbnailImg(content.getThumbnailImg());
                    return contentDetailForm;
                }
        ).collect(Collectors.toList());
        return collect;
    }

    public void deleteContent(Long content_id) {
        Optional<Content> byId = contentRepository.findById(content_id);
        byId.ifPresent(content -> contentRepository.delete(content));
    }

    public void updateContent(Long content_id,ContentForm contentForm) {
        Optional<Content> byId = contentRepository.findById(content_id);

        ContentSort sort = defineContentSort(contentForm);

        byId.ifPresent(content -> {
            Set<Tag> tags = setTagNameToTag(contentForm);
            content.setContentSort(sort);
            content.setContent(contentForm.getContent());
            content.setTags(tags);
            content.setTitle(contentForm.getTitle());
            content.setThumbnailImg(contentForm.getThumbnailImg());
            content.setAuthor(contentForm.getAuthor());
            content.setCreated_date(LocalDateTime.now());
            content.setView_count(content.getView_count());
            content.setUpdated_date(LocalDateTime.now());
        });
    }


//Todo 조회수 증가 제한 (수정필요)
//     public void resetIPList(){
//        Timer t = new Timer();
//        TimmerTastasd timmerTastasd = new TimmerTastasd();
//        t.scheduleAtFixedRate(timmerTastasd, 3600, 315360000);
//    }
//    class TimmerTastasd extends TimerTask {
//        @Override
//        public void run() {
//            requestIpList.clear();
//            System.out.println(requestIpList.size());
//            System.out.println(LocalDateTime.now());
//        }
//    }
}
