
public class D {

	private B objectB;
	private F objectF[] = new F[5];
	
	public D() {
		
	}

	public D(B objectB) {
		
		this.setObjectB(objectB);
	}

	public B getObjectB() {
		return objectB;
	}

	public void setObjectB(B objectB) {
		this.objectB = objectB;
	}

	public F[] getObjectF() {
		return objectF;
	}

	public void setObjectF(F objectF[]) {
		this.objectF = objectF;
	}
}
