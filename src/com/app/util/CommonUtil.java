package com.app.util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class CommonUtil {
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String to,String sub,String txt,final CommonsMultipartFile cmf) {
		boolean isSent=false;
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(txt);
			helper.setFrom("mailsenderjitendra@gmail.com");
			if(cmf!=null){
				helper.addAttachment(cmf.getOriginalFilename(),
					new InputStreamSource() {
					@Override
					public InputStream getInputStream() throws IOException {
						return cmf.getInputStream();
					}
				});
			}//if
			//click on send button
			mailSender.send(message);
			isSent=true;
		} catch(Exception e){
			e.printStackTrace();
			isSent=false;
		}
		return isSent;
	}//method
}//class
