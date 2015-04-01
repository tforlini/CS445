package WineClub;

public class WineClub {

	protected MonthlySelection selection;
	protected DeliveryHistory deliveryHistory;
	protected NoShipList noShipList;
	
	
	public WineClub() {
		this.selection = null;
		this.deliveryHistory = null;
		this.noShipList = null;
	}
	
	public WineClub(MonthlySelection selection,DeliveryHistory deliveryHistory,NoShipList noShipList) {
		this.selection = selection;
		this.deliveryHistory = deliveryHistory;
		this.noShipList = noShipList;
	}

	public MonthlySelection getSelection() {
		return selection;
	}

	public void setSelection(MonthlySelection selection) {
		this.selection = selection;
	}

	public DeliveryHistory getDeliveryHistory() {
		return deliveryHistory;
	}

	public void setDeliveryHistory(DeliveryHistory deliveryHistory) {
		this.deliveryHistory = deliveryHistory;
	}

	public NoShipList getNoShipList() {
		return noShipList;
	}

	public void setNoShipList(NoShipList noShipList) {
		this.noShipList = noShipList;
	}
	
	
	
}
