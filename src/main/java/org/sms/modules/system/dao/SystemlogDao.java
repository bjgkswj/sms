package org.sms.modules.system.dao;

import org.sms.db.BaseDaoImpl;
import org.sms.modules.system.model.SmsSystemlog;
import org.springframework.stereotype.Repository;

@Repository
public class SystemlogDao extends BaseDaoImpl<SmsSystemlog> implements SystemlogDaoImpl{

}
