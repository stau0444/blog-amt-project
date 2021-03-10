package ugo.blog.almostthere.tag;

import lombok.Data;

@Data
public class TagForm {

    private String tagTitle;

    public TagForm(String tagName) {
        this.tagTitle = tagName;
    }
}
