package fr.michot.fidelity.viewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.michot.fidelity.db.Client;

public class ListClientView implements Serializable {
	
	private static final long serialVersionUID = 9027891117335643956L;
	
	private List<ListClientLineView> items;

	/**
	 * 
	 */
	public ListClientView() {
		super();
	}
	
	public static ListClientView fromDatabaseClient(List<Client> listClient) {
		ListClientView returnValue = new ListClientView();
		
		if (listClient != null && listClient.size() > 0) {
			List<ListClientLineView> populatedItems= new ArrayList<ListClientLineView>(listClient.size());
			for (Client aClient : listClient) {
				populatedItems.add(ListClientLineView.fromDatabaseClient(aClient));
			}
			returnValue.setItems(populatedItems);
		}
		return returnValue;
	}

	/**
	 * @return the items
	 */
	public List<ListClientLineView> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<ListClientLineView> items) {
		this.items = items;
	}

}
