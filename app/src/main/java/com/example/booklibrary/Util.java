package com.example.booklibrary;

import java.util.ArrayList;

public class Util {
    private static ArrayList<BOOKS> allbooks;
    private static ArrayList<BOOKS> currentlyread;
    private static ArrayList<BOOKS> wanttoread;
    private static ArrayList<BOOKS> alreadyread;
    public static int i=0;

    public Util() {
        if (allbooks == null){
            allbooks = new ArrayList<>();
            addbooks();
        }
        if (null == currentlyread ){
            currentlyread   = new ArrayList<>();


        }
        if (wanttoread == null){
            wanttoread = new ArrayList<>();
        }
        if (alreadyread == null){
            alreadyread = new ArrayList<>();
        }
    }

    public static int getI() {
        return i;
    }



    public static ArrayList<BOOKS> getAllbooks() {
        return allbooks;
    }


    public static ArrayList<BOOKS> getCurrently() {
        return currentlyread;
    }



    public static ArrayList<BOOKS> getWanttoread() {
        return wanttoread;
    }



    public static ArrayList<BOOKS> getAlreadyread() {
        return alreadyread;
    }



    public boolean addcurrent(BOOKS books){

        return currentlyread.add(books);
    }



    public boolean addwanttoread(BOOKS books){

        return wanttoread.add(books);
    }

    public boolean addalreadread(BOOKS books){

        return alreadyread.add(books);
    }


    public boolean removeallbooks(BOOKS books){

        return allbooks.remove(books);
    }

    public boolean removealreadread(BOOKS books){

        return alreadyread.remove(books);
    }

    public boolean removecurrent(BOOKS books){

        return currentlyread.remove(books);
    }

    public boolean removewantto(BOOKS books){

        return wanttoread.remove(books);
    }





    private static void addbooks() {
       String name ="";
        String author="";
        int pages = 0;
        String imageurl ="";
        String description ="";

        i++;

        allbooks.add(new BOOKS(i,"Le Répertoire de La Cuisine", "Louis Saulnier", 1,"https://covers.openlibrary.org/w/id/9248006-M.jpg","Recycleview"));

        i++;
        allbooks.add(new BOOKS(i,"The Art of French Horn Playing", "BIDEX", 7,"https://covers.openlibrary.org/w/id/666628-M.jpg","Published June 1956 by Alfred Publishing Company in USA .\\n\" +" +
                "Written in English. "));

        i++;
        allbooks.add(new BOOKS(i,"The Machinist's Bedside Reader  ", "Guy Lautard", 56,"https://covers.openlibrary.org/w/id/6642064-M.jpg"," Easy to read metalwork book. Lathes, Gunsmithing, etc. See Amazon for lots of detailed reviews. Guy Lautard wrote 3 Bedside books, highly regarded by machinists. "));
        i++;
        allbooks.add(new BOOKS(i,"Be Good, Harry", "BIDEX", 31,"https://covers.openlibrary.org/b/id/6917438-M.jpg","There's no description for this book yet."));
        i++;
        allbooks.add(new BOOKS(i,"Idioms and Idiomaticity", "Chitra Fernando", 13,"https://covers.openlibrary.org/w/id/2328944-M.jpg","There's no description for this book yet. "));
        i++;
        allbooks.add(new BOOKS(i,"The War That Ended Peace", "Margaret Olwen Macmillan", 15,"https://covers.openlibrary.org/w/id/7269546-M.jpg","About the Book\n" +
                "\n" +
                "From the bestselling and award-winning author of Paris 1919 comes a masterpiece of narrative nonfiction, a fascinating portrait of Europe from 1900 up to the outbreak of World War I. "));
        i++;
        allbooks.add(new BOOKS(i,"The relaxation response", "Herbert Benson", 34,"https://covers.openlibrary.org/w/id/237307-M.jpg","There's no description for this book yet."));
        i++;
        allbooks.add(new BOOKS(i,"\n" +
                "Crabs and their relatives of British Columbia ", "Josephine F. L. Hart", 65,"https://archive.org/services/img/crabstheirrelati0000hart","There's no description for this book yet. "));

    }
}
