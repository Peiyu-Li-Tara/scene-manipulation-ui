package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.TABLE)
public class ATable<T> implements Table<T>{
	static final int MAX_SIZE = 50;
	ArrayList<String> stringContents;
	ArrayList<T> objectContents;
	int size = 0;
	
	public ATable() {
		this.stringContents = new ArrayList<String>();
		this.objectContents = new ArrayList<T>();
	}

	@Override
	public void put(String key, T val) {
		if(key == null || val == null) {
			return;
		}
		if(stringContents.contains(key)) {
			this.objectContents.add(stringContents.indexOf(key), val);
			size ++;
		} else {
			this.stringContents.add(key);
	        this.objectContents.add(stringContents.indexOf(key), val);
	        size ++;
		}
	}
	@Override
	public T get(String key) {
		if (!(stringContents.contains(key)) || objectContents.get(stringContents.indexOf(key)) == null)
			return null;
		else
			return objectContents.get(stringContents.indexOf(key));
	}
	@Override
	public int size() {
		return this.size;
	}
}
