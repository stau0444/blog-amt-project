package ugo.blog.almostthere.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ugo.blog.almostthere.domain.Tag;

@Transactional
public interface TagRepository extends JpaRepository<Tag,Long> {

    public Tag findTagByTagName(String tagName);
}
