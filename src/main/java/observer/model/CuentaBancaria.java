package observer.model;

public class CuentaBancaria {

	private double monto;
	
	public CuentaBancaria(double monto) {
		this.monto = monto;
	}
	
	public void depositar(double monto) {
		this.monto += monto;
	}
	
	public String saldo() {
		return "$" + monto;
	}
}
