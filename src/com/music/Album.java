package com.music;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author radouane Tamouss,
 *  anwar Ammar,
 *   ayoub Sakour
 *
 */
public class Album {
	private String nom;
	private String artiste;
	private ArrayList<Song> songs;
	/**
	 * @param nom
	 * @param artiste
	 */
	public Album(String nom, String artiste) {
		super();
		this.nom = nom;
		this.artiste = artiste;
		this.songs = new ArrayList<Song>() ;
	}
	
	/**
	 * 
	 */
	public Album() { 
		
	}
	
	/**
	 * @param titre
	 * @return
	 */
	public Song trouverSong(String titre)
	{
		for(Song checkedSong : songs)
		{
			if(checkedSong.getTitre().equals(titre)) return checkedSong;
		}
		return null;
	}
	/**
	 * @param titre
	 * @param duree
	 * @return
	 */
	public boolean ajouterSong(String titre, double duree)
	{
		if(trouverSong(titre) == null)
		{
			songs.add(new Song(titre,duree));
			System.out.println(titre + "Ajouté Avec Succès!");
			return true;
		}
		else
		{
			System.out.println("la chanon "+ titre+" exist déjà dans la liste!");
			return false;
		}
	}
	
	/**
	 * @param trackNumber
	 * @param PlayList
	 * @return
	 */
	public boolean ajouterAuPlayList(int trackNumber, LinkedList<Song> PlayList)
	{
		int indice = trackNumber - 1;
		if(indice > 0 && indice <= this.songs.size())
		{
			PlayList.add(this.songs.get(indice));
			return true;
		}
		System.out.println("cet album n'a pas de chanson avec le numéro "+ trackNumber);
		return false;
	}
	/**
	 * @param titre
	 * @param PlayList
	 * @return
	 */
	public boolean ajouterAuPlayList(String titre, LinkedList<Song> PlayList)
	{
		for(Song checkedSong : this.songs)
		{
			if(checkedSong.getTitre().equals(titre));
			{
				PlayList.add(checkedSong);
				return true;
			}
		}
		System.out.println(titre +"Il n'y a pas une telle music sur l'album");
		return false;
	}
	
	
	
	
	
}



