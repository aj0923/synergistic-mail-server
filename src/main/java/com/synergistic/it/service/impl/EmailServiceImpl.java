package com.synergistic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergistic.it.dao.EmailDao;
import com.synergistic.it.email.spring.form.EmailForm;
import com.synergistic.it.hibernate.entity.EmailEntity;
import com.synergistic.it.service.EmailService;

@Service("EmailServiceImpl")
public class EmailServiceImpl implements EmailService {

	@Autowired
	@Qualifier("EmailDaoImpl")
	private EmailDao emailDao;

	@Override
	public String uploadSentEmail(EmailForm emailForm) {
		// convert customerForm into customerEntity
		EmailEntity emailEntity = new EmailEntity();
		BeanUtils.copyProperties(emailForm, emailEntity);
		String result = emailDao.uploadEmails(emailEntity);
		return result;
	}

	@Override
	public List<EmailForm> getEmails(String userid, String folderName) {
		List<EmailEntity> emailEntities = emailDao.findEmails(userid,
				folderName);
		List<EmailForm> emailForms = new ArrayList<EmailForm>();
		for (EmailEntity emailEntity : emailEntities) {
			EmailForm ef = new EmailForm();
			BeanUtils.copyProperties(emailEntity, ef);
			emailForms.add(ef);
		}
		return emailForms;
	}

	@Override
	public void moveEmail(String destFolder, String[] selectedMails) {
		emailDao.moveEmails(destFolder, selectedMails);
	}

	@Override
	public void deleteEmail(String[] selectedMails) {
		emailDao.deleteEmails(selectedMails);
	}

}
