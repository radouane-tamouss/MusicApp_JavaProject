/**
 * 
 */
package com.music;

/**
 * @author radouane, anwar, ayoub
 *
 */
public class Song{

	String titre;
	double durée;
	/**
	 * @param titre;
	 * @param durée
	 */
	public Song(String titre, double durée) {
		this.titre = titre;
		this.durée = durée;
	}
	
	/**
	 * @return the title
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the title to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the duration
	 */
	public double getDurée() {
		return durée;
	}
	/**
	 * @param durée the duration to set
	 */
	public void setDurée(double durée) {
		this.durée = durée;
	}

	@Override
	public String toString() {
		return "song [titre=" + titre + ", durée=" + durée + "]";
	}
}
