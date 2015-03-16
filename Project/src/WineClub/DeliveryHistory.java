package WineClub;

public class DeliveryHistory {

	protected Shipment[] previousDeliveries;
	
	public DeliveryHistory() {
		this.previousDeliveries=null;
	}

	public DeliveryHistory(Shipment[] previousDeliveries) {
		this.previousDeliveries=previousDeliveries;
	}

	public Shipment[] getPreviousDeliveries() {
		return previousDeliveries;
	}

	public void setPreviousDeliveries(Shipment[] previousDeliveries) {
		this.previousDeliveries = previousDeliveries;
	}

	
}
