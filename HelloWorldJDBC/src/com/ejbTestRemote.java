package com;

import javax.ejb.Remote;

@Remote
public interface ejbTestRemote {
	
	// interfaccia invocazione remote per invocare il metodo da una macchina diversa

	public String prova();
	public String pippo();
}
