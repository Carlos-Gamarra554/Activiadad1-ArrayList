package Ej1;

import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    protected ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacto>();
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto.getName()) >= 0) {
            return false;
        }
        myContacts.add(contacto);
        return true;
    }

    public boolean updateContact(Contacto contacto, Contacto newContacto) {
        if (findContact(contacto) >= 0 && findContact(newContacto) < 0) {
            myContacts.set(myContacts.indexOf(contacto), newContacto);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contacto contacto) {
        if (findContact(contacto.getName()) >= 0) {
            myContacts.remove(contacto);
            return true;
        } else {
            return false;
        }
    }

    private int findContact(Contacto contacto) {
        return myContacts.indexOf(contacto);
    }

    private int findContact(String nombre) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public Contacto queryContact(String nombre) {
        int position = findContact(nombre);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        int contador = 1;
        System.out.println("Lista de contactos:");
        for (Contacto contacto : myContacts) {
            System.out.println(contador++ + ". " + contacto.getName() + " -> " + contacto.getPhoneNumber());
        }
    }
}
