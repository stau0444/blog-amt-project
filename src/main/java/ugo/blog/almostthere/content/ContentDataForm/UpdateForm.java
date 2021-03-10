package ugo.blog.almostthere.content.ContentDataForm;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.List;

@Data
@NoArgsConstructor
public class UpdateForm {

    private String title;

    private List<String> tagName;

    @Lob
    private String content;

    private String contentSort;

    @Lob
    private String thumbnailImg;

}
