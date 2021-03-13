package ugo.blog.almostthere.content;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ugo.blog.almostthere.domain.Content;
import ugo.blog.almostthere.domain.ContentSort;

@Transactional(readOnly = true)
public interface ContentRepositoryExt {
    Page<Content> findByKeyword(String keyword, Pageable pageable);
    Page<Content> findAllBySort(Pageable pageable,  ContentSort sort);
    Page<Content> findByQueryFactory(Pageable pageable , ContentSort sort);
}
