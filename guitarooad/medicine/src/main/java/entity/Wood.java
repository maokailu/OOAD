package entity;

public enum Wood {
	MAPLE, NATO, BASSWOOD;

	  public String toString() {
	    switch(this) {
	      case BASSWOOD: return "basswood";
	      case MAPLE: return "maple";
	      default:       return "nato";
	    }
	  }

}
