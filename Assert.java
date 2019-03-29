
public class Assert {

	public static boolean notFalse(boolean cond) throws Exception {
		if (cond) {
			return true;
		}
		throw new Exception("Error");
	}
}
