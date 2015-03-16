package WineClub;
import java.util.ArrayList;


public class ShipmentList {

	protected ArrayList<Shipment> shipmentList= new ArrayList<Shipment>();
	
	public ShipmentList() {

			this.shipmentList = null;
	}

	public ShipmentList(ArrayList<Shipment> shipmentList) {

		this.shipmentList = shipmentList;
}
	
}
