package com.javahub.emailapp.controller;

import javax.mail.MessagingException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javahub.emailapp.entity.Contact;
import com.javahub.emailapp.service.EmailService;

@Controller
@RequestMapping("/email-app")
public class EmailController {

	private static Logger log = LoggerFactory.getLogger(EmailController.class);

	@Autowired
	private EmailService emailService;

	@GetMapping(value = { "/", "/home", "/index" })
	public String homePage() {
		log.info("Showing HomePage...");
		return "index";
	}

	@GetMapping("/success")
	public String successPage() {
		log.info("Showing successPage...");
		return "success";
	}

	@GetMapping("/text-email")
	public ModelAndView textEmail(Contact contact) {
		ModelAndView mav = new ModelAndView("text-email");
		mav.addObject("textEmail", contact);
		log.info("Showing Text-Based Email Form...");
		return mav;
	}

	@GetMapping("/attachment-email")
	public ModelAndView attachmentEmail(Contact contact) {
		ModelAndView mav = new ModelAndView("attachment-email");
		mav.addObject("attachmentEmail", contact);
		log.info("Showing Attachment-Based Email Form...");
		return mav;
	}

	@PostMapping("/sendTextEmail")
	public ModelAndView sendSimpleEmail(@Valid @ModelAttribute("textEmail") Contact contact, BindingResult br)
			throws MessagingException {
		try {
			ModelAndView mav = new ModelAndView("success");
			log.info("Spring Boot - Sending Text Email...");
			if (br.hasErrors()) {
				log.error("Something gone wrong...");
				return new ModelAndView("text-email");
			} else {
				log.info(contact.getName() + " " + contact.getPhone() + " " + contact.getEmail() + " "
			+ contact.getSubject() + " " + contact.getComment());
				contact.setName(contact.getName());
				contact.setPhone(contact.getPhone());
				contact.setEmail(contact.getEmail());
				contact.setSubject(contact.getSubject());
				contact.setComment(contact.getComment());
				mav.addObject("name", contact.getName());
				log.info("Sening Text Email...");
				emailService.sendSimpleEmail(contact);
				log.info("Done...");
			}
			return mav;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ModelAndView("text-email");
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(value = "/sendAttachmentEmail", consumes = "multipart/form-data", method = RequestMethod.POST)
	public ModelAndView sendEmailWithAttachment(@Valid @ModelAttribute("attachmentEmail") Contact contact,
			BindingResult br, final @RequestParam("attachment") MultipartFile attachFile) throws MessagingException {
		try {
			ModelAndView mav = new ModelAndView("success");
			log.info("Spring Boot - Sending Attachment Email...");
			if (br.hasErrors()) {
				log.error("Something gone wrong...");
				return new ModelAndView("attachment-email");
			} else {
				// reads form input
				final String email = contact.getEmail();
				final String phone = contact.getPhone();
				final String name = contact.getName();
				final String subject = contact.getSubject();
				final String comment = contact.getComment();

				log.info(name + " " + phone + " " + email + " " + subject + " " + comment);

				if ((attachFile != null) && (attachFile.getSize() > 0) && (!attachFile.equals(""))) {
					log.info("FileName=====" + attachFile.getOriginalFilename());
				} else {
					log.info("FileName=====" + attachFile.getOriginalFilename() + " " + attachFile);
				}
				contact.setName(name);
				contact.setPhone(phone);
				contact.setEmail(email);
				contact.setSubject(subject);
				contact.setComment(comment);
				mav.addObject("name", contact.getName());
				log.info("Sening Attachment Email...");
				emailService.sendAttachmentEmail(contact, attachFile);
				log.info("Done...");
				return mav;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ModelAndView("attachment-email");
		}
	}
}
