package ugo.blog.almostthere.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String thumbnailImg;

    private String author;

    private LocalDateTime created_date;

    private LocalDateTime updated_date;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Tag> tags = new HashSet<>();

    @Lob
    private String content;

    private int view_count;

    @Enumerated(EnumType.STRING)
    private ContentSort contentSort;
}
