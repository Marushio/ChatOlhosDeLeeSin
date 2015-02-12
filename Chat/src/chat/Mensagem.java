/*
 *:) ;) O.O
 */

package chat;

import java.util.Date;

/**
 *
 * @author a1320548
 */
public class Mensagem implements Comparable{
    
    private String nick,texto;
    private Date date;
    
    


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public int compareTo(Object t) {
        Mensagem msg2 = (Mensagem) t;
        
        if(this.date.compareTo(msg2.getDate())==0)
            return this.nick.compareTo(msg2.getTexto());
        else return this.date.compareTo(msg2.getDate());
    }
    @Override
    public boolean equals(Object t){
         Mensagem msg2 = (Mensagem) t;
         if(this.date.equals(msg2.getDate()) &&
           this.texto.equals(msg2.getTexto()) &&
           this.nick.equals(msg2.getNick()))
             return true;
        else return false;
    }
    
    
    
}
