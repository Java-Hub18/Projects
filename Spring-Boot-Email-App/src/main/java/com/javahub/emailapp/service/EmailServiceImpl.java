package com.javahub.emailapp.service;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javahub.emailapp.entity.Contact;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private Environment env; // to get valuse from property file.
	
	@Override
	public void sendSimpleEmail(Contact contact) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		// use the true flag to indicate you need a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true); 
        String content = "Hi, <b>"+contact.getName()+"</b> Thank you for Contacting Us. We will revert you soon.<br>";
        helper.setSubject(contact.getSubject());
        helper.setText(content+" <b>Comment:</b> "+ contact.getComment(), true); // set to html
        helper.setTo(contact.getEmail());
        helper.setFrom(env.getProperty("spring.mail.username"));
        emailSender.send(message);	
	}

	@Override
	public void sendAttachmentEmail(Contact contact, MultipartFile attachfile) throws MessagingException {     
		emailSender.send(new MimeMessagePreparator() {
            @SuppressWarnings("unlikely-arg-type")
			public void prepare(MimeMessage mimeMessage) throws Exception {
            	// Enable the multipart flag!
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 
                String content = "Hi, <b>"+contact.getName()+"</b> Thank you for Contacting Us. PFB attachment.<br>";
				helper.setSubject(contact.getSubject());
				helper.setText(content+" <b>Comment:</b> "+ contact.getComment(), true);
				System.out.println("In Service=========="+contact.getEmail());
				helper.setTo(contact.getEmail());
				System.out.println("In Service=========="+env.getProperty("spring.mail.username"));
				helper.setFrom(env.getProperty("spring.mail.username"));
                
                // Determine If There Is An File Upload. If Yes, Attach It To The Client Email              
                if ((attachfile != null) && (attachfile.getSize() > 0) && (!attachfile.equals(""))) {
                    System.out.println("\nAttachment Name?= " + attachfile.getOriginalFilename() + "\n");
                    helper.addAttachment(attachfile.getOriginalFilename(), new InputStreamSource() {                   
                        public InputStream getInputStream() throws IOException {
                            return attachfile.getInputStream();
                        }
                    });
                } else {
                    System.out.println("No Attachment Is Selected By The User. Sending Text Email.");
                    //logic for sending text email.
                }
            }
        });
	}

}
