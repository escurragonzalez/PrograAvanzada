package deliveryBoy;

public class DeliveryBoy {

	private double horasTrabajadas;
	private double pesoPaquete;
	private double tiempoEntrega;
	
	
	public boolean puedeLlevar()
	{
		if (this.necesitaDesacansar())
			{
			this.descansar();
			return false;
			}
			
		else
			if ((14-this.horasTrabajadas)<=(this.tiempoEntrega*2) && pesoPaquete <= 20)
				return true;
		return false;
	}
	
	public void llevar()
	{
		this.horasTrabajadas+=(this.tiempoEntrega*2);
	}
	
	//---
	
	public boolean necesitaDesacansar()
	{
		if (this.horasTrabajadas<14)
			return false;
		return true;
	}
	
	public void descansar()
	{
		this.horasTrabajadas=0;
	}
	
	
}
