package sbs.applitools.hackathon.productFilter;

public class productFilter {

	private String filterType;
	private String[] filterOptions;
	private String[] selectedOptions;
	
	
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public String[] getFilterOptions() {
		return filterOptions;
	}
	public void setFilterOptions(String[] filterOptions) {
		this.filterOptions = filterOptions;
	}
	
	public productFilter selectFilterOption(String filterOption) {
		return null;
		
	}
	
	public productFilter deselectFilterOption(String filterOption) {
		return null;
		
	}
	
	public int getMatchCount(){
		
		return 0;
	}
	
	
	
	
}
