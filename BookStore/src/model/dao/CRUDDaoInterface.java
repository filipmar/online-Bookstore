package model.dao;

import java.util.List;

public interface CRUDDaoInterface<TO,TI> {
	
	public boolean add(TO bean);
	public TO get(TI identifier);
	public boolean update(TO bean);
	public boolean delete(TO bean);
	public List<TO> getList(String[] conditions);
	public List<TO> getAll();
	
}
