package com.driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Node{
     Date date;
     String sender;
     String message;
     Node next, prev;
     Node(Date date, String sender, String message){
         this.date=date;
         this.sender=sender;
         this.message=message;
     }
 }

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

        Node head = new Node(new SimpleDateFormat("dd/MM/yyyy").parse("00/00/0000"), null, null);
        Node tail = new Node(new SimpleDateFormat("dd/MM/yyyy").parse("00/00/0000"), null, null);

    HashMap<String,Node> storage=new HashMap<>(this.inboxCapacity);
    HashMap<String,Node> trashStorage=new HashMap<>();

    public Gmail(String emailId, int inboxCapacity) throws ParseException {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        head.next=tail;
        tail.prev=head;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Node newNode=new Node(date,sender,message);
        if(!storage.containsKey(newNode.message)){
            storage.put(newNode.message,newNode);
            Node nextNode=head.next;
            head.next=newNode;
            newNode.next=nextNode;

            newNode.prev=head;
            nextNode.prev=newNode;
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        if(storage.containsKey(message)){
            delete(storage.get(message));
            storage.remove(message);
        }
    }

    // new method to delete node from linkedList
    public void delete(Node node){
        Node nextNode=node.next;
        Node prevNode=node.prev;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(storage.size()==0){
            return null;
        }else{
            return head.next.message;
        }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(storage.size()==0){
            return null;
        }else{
            return tail.prev.message;
        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int countMails=0;
        for(Node node: storage.values()){
            if(node.date.compareTo(start)==0 || node.date.compareTo(end)==0){
                countMails++;
            }
            else if(node.date.compareTo(start)>0 && node.date.compareTo(end)<0){
                countMails++;
            }
        }
        return countMails;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return storage.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trashStorage.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trashStorage.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
