package org.sms.modules.usermanage.dao;

import org.sms.db.BaseDaoImpl;
import org.sms.modules.usermanage.model.SmsUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<SmsUser> implements UserDaoI{

}
