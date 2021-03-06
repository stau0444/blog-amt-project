package ugo.blog.almostthere.content;


import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import ugo.blog.almostthere.domain.Content;
import ugo.blog.almostthere.domain.ContentSort;
import ugo.blog.almostthere.domain.QContent;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import java.util.List;

import static ugo.blog.almostthere.domain.QTag.tag;

public class ContentRepositoryExtImpl extends QuerydslRepositorySupport implements ContentRepositoryExt {
    public ContentRepositoryExtImpl() {
        super(Content.class);
    }

    @Override
    public Page<Content> findAllBySort(Pageable pageable, ContentSort sort) {
        QContent content = QContent.content1;
        JPQLQuery<Content> query =
                from(content)
                        .select(content)
                        .where(content.contentSort.eq(sort))
                        .leftJoin(content.tags, tag)
                        .orderBy(content.created_date.desc())
                        .distinct();

        JPQLQuery<Content> pageableQuery = getQuerydsl().applyPagination(pageable, query);
        QueryResults<Content> fetchResults = pageableQuery.fetchResults();

        return new PageImpl<>(fetchResults.getResults(),pageable,fetchResults.getTotal());
    }



    @Override
    public Page<Content> findByKeyword(String keyword, Pageable pageable) {

        QContent content = QContent.content1;
        JPQLQuery<Content> query =
                from(content)
                        .select(content)
                        .where(content.title.containsIgnoreCase(keyword)
                        .or(content.tags.any().tagName.containsIgnoreCase(keyword)))
                        .orderBy(content.created_date.desc())
                        .leftJoin(content.tags, tag)
                        .distinct();

        JPQLQuery<Content> pageableQuery = getQuerydsl().applyPagination(pageable,query);
        QueryResults<Content> fetchResults = pageableQuery.fetchResults();

        return new PageImpl<>(fetchResults.getResults(),pageable,fetchResults.getTotal());
    }

    @Override
    public Page<Content> findByQueryFactory(Pageable pageable, ContentSort sort) {

     
        QContent content = QContent.content1;
        QueryResults<Content> qr = from(content)
                .select(content)
                .leftJoin(content.tags, tag)
                .where(content.contentSort.eq(sort))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .distinct()
                .fetchResults();
        return new PageImpl<>(qr.getResults(),pageable,qr.getTotal());
    }
}
