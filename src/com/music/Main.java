/**
 * 
 */
package com.music;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author radouane,anwar,ayoub
 *
 */
public class Main {

	/**
	 * @param args
	 */
	private static ArrayList<Album> albums = new ArrayList<>();
	public static void main(String[] args) {
		
		
		
		Album album = new Album("Album1","Anonyme");
		
		album.ajouterSong("TESTsong", 4.4);
		album.ajouterSong("test 2", 4);
		album.ajouterSong("test song 3", 2.4);
		album.ajouterSong("test song 4", 3.7);
		albums.add(album);
		
		album = new Album("Album2", "artiste2");
		album.ajouterSong("test 2 aritst2", 4.3);
		album.ajouterSong("test song 3 artist 2", 1.4);
		album.ajouterSong("test song 4 artist 2", 3.2);
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<>();
		albums.get(0).ajouterAuPlayList("TESTsong",playList_1);
		albums.get(1).ajouterAuPlayList("test 2 aritst2",playList_1 );
		albums.get(0).ajouterAuPlayList("test song 3",playList_1 );
		albums.get(1).ajouterAuPlayList("test song 4 artist 2",playList_1 );
		
		play(playList_1);
		
		

	}

	private static void play(LinkedList<Song> playList)
	{
	
		Scanner scan = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size()==0)
		{
			System.out.println("cette playlist est vide!");
		}
		else
		{
			System.out.println("lecture en cours" + listIterator.next().toString());
			printMenu();
			
		}
		
		while(!quit)
		{
			int action = scan.nextInt();
			scan.nextLine();
			
			switch (action) {
				
			case 0:
				System.out.println("PlayList complete");
				quit = true;
				break;
			case 1:
				if(!forward)
				{
					if(listIterator.hasNext()) 
					{
						listIterator.next();	
					}
					forward = true;
				}
				if(listIterator.hasNext())
				{
					System.out.println("lecture en cours :"+listIterator.next().toString());
				}
				else
				{
					System.out.println("pas de chanson, la fin de list.");
					forward = false;
				}
				break;
			case 2:
				if(forward)
				{
					if(listIterator.hasPrevious())
					{
						listIterator.previous();
					}
					forward = false;
					
				}
				if(listIterator.hasPrevious())
				{
					System.out.println("Lecture en cours: "+listIterator.previous().toString());
				}
				else
				{
					System.out.println("we are the first song");
					forward = false;
				}
				break;
				
			}
		}
	
	}
	
	private static void printMenu()
	{
		System.out.println("--------------- MENU DE CHOIX -------------\n");
		System.out.println("0 - quiter\n"+
						   "1 - lire la chanson suivant\n"+
						   "2 - lire la chanson precedent\n"+
						   "3 - rejouer la chanson\n"+
						   "4 - afficher la liste du musiques\n "+
						   "5 - MENU\n"+
						   "6 - supprimer la chanson actuelle\n");

		
	}
	
	
	private static void printList(LinkedList<Song> playList)
	{
		Iterator<Song> iterator = playList.iterator();
		System.out.println("-------------");
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("-------------");
		
	}
	
	
	
	
	
	
}
