package org.sms.modules.basemanage.dao;

import org.springframework.stereotype.Repository;

import org.sms.db.BaseDaoImpl;
import org.sms.modules.basemanage.model.SmsRemind;

@Repository
public class RemindDaoImpl extends BaseDaoImpl<SmsRemind> implements RemindDaoI {
}
