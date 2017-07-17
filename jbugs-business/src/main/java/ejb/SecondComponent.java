package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SecondComponent {

	@EJB
	private FirstComponent firstEjb;

	public String doMagic() {
		return this.firstEjb.doSomething("nice");
	}
}
