package ugo.blog.almostthere.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Tag {

    @Id @GeneratedValue
    private Long id;

    private String tagName;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Content> contents = new HashSet<>();

    public Tag(String tagTitle) {
        this.tagName = tagTitle;
    }
}
