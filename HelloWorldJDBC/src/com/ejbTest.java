package com;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ejbTest
 */
@Stateless
@LocalBean
public class ejbTest implements ejbTestRemote, ejbTestLocal {

    /**
     * Default constructor. 
     */
    public ejbTest() {
        // TODO Auto-generated constructor stub
    }

    public String prova() {
    	System.out.println("metodo chiamato");
    	return "hello";
    }
    
    public String pippo() {
    	return"d";
    }
}
