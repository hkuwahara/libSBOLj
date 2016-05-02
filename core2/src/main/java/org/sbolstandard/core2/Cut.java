package org.sbolstandard.core2;

import java.net.URI;

import javax.xml.namespace.QName;

/**
 * Represents the Cut extension of the SBOL Location class.
 * 
 * @author Zhen Zhang
 * @author Nicholas Roehner
 * @author Chris Myers
 * @version 2.1
 */

public class Cut extends Location{

	private int at;
	
	Cut(URI identity, int at) throws SBOLValidationException {
		super(identity);
		setAt(at);
	}

	private Cut(Cut cut) throws SBOLValidationException {
		super(cut);
		this.setAt(cut.getAt());
	}

	/**
	 * Returns the {@code at} property of this Cut object.
	 *
	 * @return the {@code at} property of this Cut object
	 */
	public int getAt() {
		return at;
	}

	/**
	 * Sets the {@code at} property of this Cut object to the given one.
	 * <p>
	 * If this Cut object belongs to an SBOLDocument instance,
	 * then the SBOLDcouement instance
	 * is checked for compliance first. Only a compliant SBOLDocument instance
	 * is allowed to be edited.
	 *
	 * @param at The discrete position that that corresponds to the index of a character in the elements String of a Sequence.
	 * @throws SBOLValidationException if the given {@code at} value is less than 0
	 */
	public void setAt(int at) throws SBOLValidationException {
		if (at<0) {
			throw new SBOLValidationException("sbol-11202", this);
		}
		this.at = at;
	}

	@Override
	protected Cut deepCopy() throws SBOLValidationException {
		return new Cut(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + at;
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cut other = (Cut) obj;
		if (at != other.at)
			return false;
		return orientation == other.orientation;
	}

	@Override
	public String toString() {
		return "Cut ["
				+ "identity=" + identity 
				+ (this.isSetDisplayId()?", displayId=" + displayId:"") 
				+ (this.isSetName()?", name=" + name:"")
				+ (this.isSetDescription()?", description=" + description:"") 
				+ ", at=" + at 
				+ (this.isSetOrientation()?", orientation=" + orientation:"") 
				+ "]";
	}

	@Override
	public int compareTo(Location location) {
		int thisPos = -1;
		Annotation annotation = this.getAnnotation(new QName(GenBank.GBNAMESPACE,GenBank.POSITION,GenBank.GBPREFIX));
		if (annotation!=null) {
			thisPos = Integer.parseInt(annotation.getStringValue().replace("position",""));
		}
		int otherPos = -1;
		annotation = location.getAnnotation(new QName(GenBank.GBNAMESPACE,GenBank.POSITION,GenBank.GBPREFIX));
		if (annotation!=null) {
			otherPos = Integer.parseInt(annotation.getStringValue().replace("position",""));
		}
		if (thisPos != -1 && otherPos != -1) {
			int result = thisPos - otherPos;
			return result;
		}
		if (location instanceof Range) {
			int result = this.at - ((Range)location).getStart();
			if (result==0) {
				result = ((Range)location).getEnd() - this.at;
			}
			return result;
		} else if (location instanceof Cut) {
			return this.at - ((Cut)location).getAt();
		} 
		return this.at;
	}
}
