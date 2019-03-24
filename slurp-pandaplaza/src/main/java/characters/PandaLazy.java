

/**
 * @author User
 * @version 1.0
 * @created 24-márc.-2019 11:31:00
 */
public class PandaLazy extends Panda {

	public PandaLazy(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void sit(){

	}
}//end PandaLazy