package com.demo.Service;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.DAO.adminDAO;
import com.demo.VO.adminVO;

@Service
@Transactional

public class adminServiceImpl implements adminService {

	@Autowired
	private adminDAO d;
	@Override
	public boolean insert(adminVO av) {
		// TODO Auto-generated method stub
		d.insert(av);
		return false;
		
	
		
	}
	@Override
	public List search() {
		// TODO Auto-generated method stub
		return d.search();
	}
	@Override
	public ResponseEntity delete(adminVO v) {
		return d.delete(v);
		 
		
	}
	@Override
	public List viewByID(adminVO v) {
		// TODO Auto-generated method stub
		return d.viewByID(v);
	}
	@Override
	public List edit(adminVO v) {
		// TODO Auto-generated method stub
		return d.edit(v);
	}
	@Override
	public boolean sendemail(adminVO av) {
		// TODO Auto-generated method stub{
		boolean b=false;
		//from=to & to=from
			String to="chetankagda238@gmail.com";
			String host="smtp.gmail.com";
			String subject="Employe Welcome";
			String msg="Hi..this is chetan kagda here.";
			
			//get the system properties
			
			Properties p=System.getProperties();
			System.out.println("PROPERTIES :"+p);
			
			//setting important information to the properties
			
			p.put("mail.smtp.host",host);
			p.put("mail.smtp.port","465");//email client to  server communication
			p.put("mail.smtp.ssl.enable","true");
			p.put("mail.smtp.auth","true");
			
			// step 1:to get the session object.

			Session session = Session.getInstance(p, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication("chetankagda238@gmail.com", "7046371993");
				}

			});
			session.setDebug(true);

			// step 2 : compose the msg [TEXT]

			MimeMessage m = new MimeMessage(session);

			try {
				
				// from email id
				m.setFrom(to);

				// to email id
				m.addRecipient(Message.RecipientType.TO,new InternetAddress(av.getEmail()));
				
				//adding subject to msg
				m.setSubject(subject);
				
				//attachment
				//file path
				String path="C:\\Users\\cheta\\OneDrive\\Desktop\\plum.txt";
				
				MimeMultipart mm =new MimeMultipart();
				//text
				//file
				MimeBodyPart text=new MimeBodyPart();
				MimeBodyPart file=new MimeBodyPart();
				
				try{
					text.setText(msg);
					//create file for storing file object
					
					File file1=new File(path);
					file.attachFile(file1);
					
					mm.addBodyPart(text);
					mm.addBodyPart(file);
					
					
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				m.setContent(mm);
				
				
				//send
				
				//step 3:send the msg using transport class.
				Transport.send(m);
				System.out.println("Send Success..........");
				b=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return b;

		}
		
	}


