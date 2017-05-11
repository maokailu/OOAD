package entity;

public enum Builder {
	FENDER, GISBON;

	  public String toString() {
	    switch(this) {
	      case FENDER: return "fender";
	      case GISBON: return "gibson";
	      default:       return "epiphone";
	    }
	  }
}
