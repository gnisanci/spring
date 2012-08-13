package com.sivalabs.contacts;

import org.codehaus.grepo.core.annotation.Param;
import org.codehaus.grepo.query.commons.annotation.GenericQuery;
import org.codehaus.grepo.query.hibernate.annotation.HibernateCaching;
import org.codehaus.grepo.query.hibernate.annotation.HibernateQueryOptions;
import org.codehaus.grepo.query.hibernate.executor.GetQueryExecutor;
import org.codehaus.grepo.query.hibernate.repository.ReadWriteHibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gurkan
 * Date: 12/08/12
 * Time: 09:00
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface ContactRepository extends ReadWriteHibernateRepository<Contact, Long>
{
    @GenericQuery
    @HibernateQueryOptions(criteriaGenerator = ContactNameLookupQueryGenerator.class, caching = HibernateCaching.ENABLED)
    List<Contact> findContactsByName(@Param("name") String name);

    @GenericQuery(query = "from Contact")
    @HibernateQueryOptions(caching = HibernateCaching.ENABLED)
    List<Contact> findAllContacts();

    @GenericQuery(query = "from Contact where id = ?", queryExecutor = GetQueryExecutor.class)
    @HibernateQueryOptions(caching = HibernateCaching.ENABLED)
    Contact getById(Integer id);
}
