package IODades;

import java.util.ArrayList;

public interface DataSource {
	
	public int open ( String source, boolean mode );
	public int close ( String source );
	public int importdades ( ArrayList dades, String source );
	public int exportdades ( ArrayList dades, String source, int mode );
}
