package jim.pers.jerp.model;


public class Program {
	private int uuid;
	private String name;
	private String icon;
	private String href;
	private int parentUuid;
	private int level;
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public int getParentUuid() {
		return parentUuid;
	}
	public void setParentUuid(int parentUuid) {
		this.parentUuid = parentUuid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
