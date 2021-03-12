package ugo.blog.almostthere.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ugo.blog.almostthere.domain.Content;

import java.util.List;

@Transactional
public interface ContentRepository extends JpaRepository<Content,Long>,ContentRepositoryExt {

    @Query(value = "select * from(select * , rank() over(order by view_count desc) as ranking from content)as t where t.ranking <=5 limit 5"
            ,nativeQuery = true)
    List<Content> findTop5byViewCount();


    @Query(value = "select * from(select * , rank() over(order by created_date desc) as ranking from content)as t where t.ranking <=5"
            ,nativeQuery = true)
    List<Content> findTop5byCreatedData();

}
