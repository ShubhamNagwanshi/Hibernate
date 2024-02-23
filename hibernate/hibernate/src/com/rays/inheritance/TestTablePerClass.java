package com.rays.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTablePerClass {

	public static void main(String[] args) {
		
		CreditCardPayment cc = new CreditCardPayment();
		
		cc.setAmount(1000);
		cc.setCcType("Visa");
		cc.setPaymentType("imps");
		
		
		Cheque ch = new Cheque();
		
		ch.setAmount(5000);
		ch.setPaymentType("cheque");
		ch.setBankName("Central Bank");
		ch.setChequeNo("CB0100");
		
		Cash c = new Cash();
		c.setAmount(2000);
		c.setPaymentType("Cash");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(cc);

		session.save(ch);

		session.save(c);

		tx.commit();

		session.close();

		
	}
}
