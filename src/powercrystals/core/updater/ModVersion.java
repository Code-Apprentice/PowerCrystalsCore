package powercrystals.core.updater;

public class ModVersion implements Comparable<ModVersion>
{
	private ReleaseVersion _mcVer;
	private ReleaseVersion _modVer;
	private String _desc;
	
	public ReleaseVersion minecraftVersion()
	{
		return _mcVer;
	}
	
	public ReleaseVersion modVersion()
	{
		return _modVer;
	}
	
	public String description()
	{
		return _desc;
	}
	
	public ModVersion(ReleaseVersion minecraftVersion, ReleaseVersion modVersion, String description)
	{
		_mcVer = minecraftVersion;
		_modVer = modVersion;
		_desc = description;
	}
	
	public static ModVersion parse(String s)
	{
		String[] parts = s.split(" ", 2);
		String desc = "";
		if(parts.length > 1)
		{
			desc = parts[1];
		}
		parts = parts[0].split("R", 2);
		return new ModVersion(ReleaseVersion.parse(parts[0]), ReleaseVersion.parse(parts[1]), desc);
	}
	
	@Override
	public int compareTo(ModVersion o)
	{
		if(_mcVer.compareTo(o.minecraftVersion()) != 0) return _mcVer.compareTo(o.minecraftVersion());
		return _modVer.compareTo(o.modVersion());
	}
	
	@Override
	public String toString()
	{
		return _mcVer.toString() + "R" + _modVer.toString();
	}
}
