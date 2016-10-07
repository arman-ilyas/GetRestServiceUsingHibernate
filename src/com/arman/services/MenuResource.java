package com.arman.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arman.entity.Menu;
import com.arman.entity.Menus;

@Path("/menu")
public class MenuResource {

	@Path("get")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Menu getMenu() {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Menus.class)
				.addAnnotatedClass(Menu.class).buildSessionFactory();
		Menu menu = new Menu();
		menu.setStatus("ok");

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			// MY NEW CODE
			// now get a new session and start transaction
			session.beginTransaction();

			// menu = session.get(Menus.class, 1);

			// session.save(tempMenu);
			List<Menus> menus =  session.createQuery("from Menus s where s.menu_id='1'").list();
			menu.setMenus(menus);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

		return menu;
	}

}
