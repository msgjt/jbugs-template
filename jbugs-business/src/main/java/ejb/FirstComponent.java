package ejb;

import javax.ejb.Stateless;

@Stateless
public class FirstComponent {
	
	public String doSomething(String value) {
		return "something " + value;
	}

}
