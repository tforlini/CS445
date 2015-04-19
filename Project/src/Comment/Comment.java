package Comment;

import Entities.Shipment;
import Entities.Wine;

public interface Comment {


	public Wine rateWine();

	public Shipment addNote(int id);
}
