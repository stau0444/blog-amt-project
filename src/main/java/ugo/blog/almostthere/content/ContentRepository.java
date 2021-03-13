package ugo.blog.almostthere.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ugo.blog.almostthere.domain.Content;

import java.util.List;

@Transactional(readOnly = true)
public interface ContentRepository extends JpaRepository<Content,Long>,ContentRepositoryExt {


    @Query(value = "select * from content order by view_count desc limit 5;"
            ,nativeQuery = true)
    List<Content> findTop5byViewCount();


    @Query(value = "select * from content order by created_date desc limit 5;"
            ,nativeQuery = true)
    List<Content> findTop5byCreatedData();

}
