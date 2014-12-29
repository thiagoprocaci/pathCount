package com.tbp.model;

/**
 * Describes a graph link
 * 
 * @author Thiago B. Procaci
 * 
 */
public class Link {

	private Vertex source;
	private Vertex dest;
	private Integer label;



	/**
	 * Creates a new Link
	 */
	public Link(Vertex source, Vertex dest, Integer label) {
		this.source = source;
		this.dest = dest;
		this.label = label;
	}

	/**
	 * 
	 * @return Returns source vertex
	 */
	public Vertex getSource() {
		return source;
	}


	/**
	 * 
	 * @return Returns dest vertex
	 */
	public Vertex getDest() {
		return dest;
	}



	/**
	 * 
	 * @return Returns label
	 */
	public Integer getLabel() {
		return label;
	}

	/**
	 * Sets label
	 * 
	 * @param label
	 */
	public void setLabel(Integer label) {
		this.label = label;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!dest.equals(link.dest)) return false;
        if (!source.equals(link.source)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + dest.hashCode();
        return result;
    }
}
