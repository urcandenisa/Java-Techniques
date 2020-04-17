package PT2019.assignment4.Assignment4.businessLayer;

import java.util.List;
/**
 * @invariant: menuItems.size() >= 0
 * @invariant: isWellFormed() == true
 * @author Denii
 *
 */
public interface RestaurantProcessing {
	/** adds a new element to the end of the list
	 * @pre menuItem != null
	 * @post getSize() == getSize()@pre + 1
	 * @param menuItem
	 */
	public void addItem(MenuItem menuItem);
	/** remove an element from the list
	 * @pre menuItem != null
	 * @pre getSize() > 0
	 * @pre list contains menuItem
	 * @post getSize() == getSize()@pre - 1
	 * @param menuItem
	 */
	public void deleteItem(MenuItem menuItem);
	/** replace an element from the list with another element
	 * @pre newItem != null
	 * @pre menuItem != null
	 * @pre menuItem = newItem
	 * @param menuItem
	 * @param newItem
	 */
	public void editItem(MenuItem menuItem, MenuItem newItem);
	/**create a new order; the order will be inserted into the hashmap -> order is the key, items are added
	 * @pre order != null
	 * @pre items != null
	 * @post getSize() == getSize()@pre + 1
	 * @param order
	 * @param items
	 */
	public void createOrder(Order order, List<MenuItem> items);
}
