package toDoListEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="listitems")
public class ListItem {
	
	public ListItem() {
		
	}
	public ListItem(String text) {
		this.text = text;
	}
	public int getItemID() {
		return ItemID;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "ListItem [ItemID=" + ItemID + ", text=" + text + "]";
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ItemID")
	private int ItemID;
	
	@Column(name="ItemContent")
	private String text;


}
