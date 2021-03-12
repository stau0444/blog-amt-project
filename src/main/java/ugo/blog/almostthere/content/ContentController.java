package ugo.blog.almostthere.content;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ugo.blog.almostthere.content.ContentDataForm.ContentDetailForm;
import ugo.blog.almostthere.content.ContentDataForm.ContentForm;
import ugo.blog.almostthere.content.ContentDataForm.SearchForm;
import ugo.blog.almostthere.content.ContentDataForm.UpdateForm;
import ugo.blog.almostthere.domain.Content;
import ugo.blog.almostthere.domain.ContentSort;
import ugo.blog.almostthere.domain.Tag;
import ugo.blog.almostthere.tag.TagForm;
import ugo.blog.almostthere.tag.TagService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;
    private final ContentRepository contentRepository;
    private final TagService tagService;

    @GetMapping("/api/checkIp")
    public Map<String, Object> isAdmin(){

        Map<String, Object> isAdmin = checkIp();
        return isAdmin;
    }

    private Map<String, Object> checkIp() {
        String adminIP="172.31.46.77";
        String requsetIp = null;
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        requsetIp = request.getRemoteAddr();
        System.out.println("requsetIp------------"+requsetIp);

        Map<String,Object> isAdmin = new HashMap<>();

        if (requsetIp.equals(adminIP)){
            isAdmin.put("isAdmin",true);
        }else {
            isAdmin.put("isAdmin",false);
        }
        return isAdmin;
    }

    @GetMapping("/api/hello")
    public String hello(){
        System.out.println("frontend api 요청");
        return "hello";
    }

    @GetMapping("/api/content/detail/{content_id}")
    public ContentDetailForm getContent(@PathVariable Long content_id){
        ContentDetailForm contentDetailForm = contentService.getContentDetail(content_id);
        return contentDetailForm;
    }

    @GetMapping("/api/content/list")
    public Page<ContentDetailForm> getList(Pageable pageable,String path){
        System.out.println(path);
        ContentSort sort;
        if(path.equals("/")){
            sort = ContentSort.SUMMARY;
        }else {
            sort = ContentSort.NEWS;
        }
        Page<Content> pageList = contentRepository.findAllBySort(pageable, sort);
        List<ContentDetailForm> transformedList = contentService.getContentList(pageList);
        return new PageImpl<>(transformedList,pageable,pageList.getTotalElements());
    }

    @GetMapping("/api/content/create")
    public String createContent(){
        return "createContent";
    }

    @PostMapping("/api/content/add")
    public void addContent(@RequestBody ContentForm contentForm){
        contentService.addContent(contentForm);
    }
    @PostMapping("/api/content/update/{content_id}")
    public void updateContentForm(@PathVariable Long content_id,@RequestBody ContentForm contentForm) throws Exception{
        contentService.updateContent(content_id,contentForm);
    }
    @GetMapping("/api/content/update/{content_id}")
    public UpdateForm dataForUpdate(@PathVariable Long content_id) throws Exception{
        Optional<Content> byId = contentRepository.findById(content_id);
        UpdateForm updateForm = new UpdateForm();
        byId.ifPresent(content -> {
            List<String> tagNames = content.getTags().stream().map(tag -> tag.getTagName()).collect(Collectors.toList());
            updateForm.setContent(content.getContent());
            updateForm.setTitle(content.getTitle());
            updateForm.setTagName(tagNames);
            updateForm.setThumbnailImg(content.getThumbnailImg());
            updateForm.setContentSort(content.getContentSort().toString());
        });
        return updateForm;
    }
    @GetMapping("/api/content/delete/{content_id}")
    public void deleteContent(@PathVariable Long content_id){
        contentService.deleteContent(content_id);
    }
    @PostMapping("/api/content/tags/add")
    public void addTags(@RequestBody TagForm tagForm){
        tagService.addTags(tagForm);
    }

    @PostMapping("/api/content/tags/remove")
    public void removeTags(@RequestBody TagForm tagForm){
        tagService.removeTag(tagForm);
    }


    @GetMapping("/api/content/tags/list")
    public List<String> getTagList(){
        Optional<Content> content = contentRepository.findById(1L);
        Content foundContent = content.orElseGet(Content::new);
        List<String> tags = foundContent.getTags().stream().map(Tag::getTagName).collect(Collectors.toList());
        return tags;
    }
    @GetMapping("/api/content/pop_rank")
    public List<Content> getPopRank(){
        List<Content> top5byViewCount = contentRepository.findTop5byViewCount();
        return top5byViewCount;
    }
    @GetMapping("/api/content/latest_rank")
    public List<Content> getLatestRank(){
        List<Content> top5byCreatedData = contentRepository.findTop5byCreatedData();
        return top5byCreatedData;
    }
    @GetMapping("/api/content/search")
    public Map<String,Object> searchContent(SearchForm searchForm, Pageable pageable){

        Map<String,Object> searchContentList = new HashMap<>();

        Page<Content> searchContent = contentRepository.findByKeyword(searchForm.getKeyword(), pageable);
        List<ContentDetailForm> contentList = contentService.getContentList(searchContent);
        PageImpl<ContentDetailForm> contentDetailForms = new PageImpl<>(contentList, pageable, searchContent.getTotalElements());

        searchContentList.put("searchContentList",contentDetailForms);
        searchContentList.put("searchKeyword",searchForm.getKeyword());
        return searchContentList;
    }
}
