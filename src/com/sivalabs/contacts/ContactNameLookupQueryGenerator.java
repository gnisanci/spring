package com.sivalabs.contacts;

import org.codehaus.grepo.query.commons.aop.QueryMethodParameterInfo;
import org.codehaus.grepo.query.hibernate.generator.CriteriaGenerator;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;

/**
 * Created with IntelliJ IDEA.
 * User: gurkan
 * Date: 12/08/12
 * Time: 09:06
 * To change this template use File | Settings | File Templates.
 */
public class ContactNameLookupQueryGenerator  implements CriteriaGenerator
{
    @Override
    public DetachedCriteria generate(QueryMethodParameterInfo parameterInfo)
    {
        String contactName = parameterInfo.getParameterByParamName("name", String.class);

        DetachedCriteria contactCriteria = DetachedCriteria.forClass(Contact.class);
        contactCriteria.add(Property.forName("name").like(contactName, MatchMode.ANYWHERE));

        return contactCriteria;
    }
}
