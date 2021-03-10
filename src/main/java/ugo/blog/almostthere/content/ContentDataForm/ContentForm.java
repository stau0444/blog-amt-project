package ugo.blog.almostthere.content.ContentDataForm;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.List;

@Data
@NoArgsConstructor
public class ContentForm {


    private String author;

    private List<String> tagName;

    private String title;

    private String contentSort;

    @Lob
    private String thumbnailImg;


    private String content;

    @QueryProjection
    public ContentForm(String author, List<String> tagName, String title, String contentSort, String thumbnailImg, String content) {
        this.author = author;
        this.tagName = tagName;
        this.title = title;
        this.contentSort = contentSort;
        this.thumbnailImg = thumbnailImg;
        this.content = content;
    }
}
