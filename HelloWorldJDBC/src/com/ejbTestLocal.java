package com;

import javax.ejb.Local;

@Local
public interface ejbTestLocal {

	// interfaccia invocazione locale per invocare il metodo dalla stessa macchina dov'è presente il file
	public String prova();
	public String pippo();
}
