package ugo.blog.almostthere.content.ContentDataForm;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import ugo.blog.almostthere.domain.Tag;

import javax.persistence.Lob;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ContentDetailForm {

    private Long id;

    private String title;

    private String author;

    private String created_date;

    private Set<Tag> tags = new HashSet<>();


    @Lob
    private String content;

    private int view_count;

    @Lob
    private String thumbnailImg;

    @QueryProjection
    public ContentDetailForm(Long id,String title, String author, String created_date, Set<Tag> tags, String content, int view_count ,String thumbnailImg) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.created_date = created_date;
        this.tags = tags;
        this.content = content;
        this.view_count = view_count;
        this.thumbnailImg = thumbnailImg;
    }
}
